package org.springframework.social.orcid.api.impl;

import java.util.Arrays;
import java.util.List;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.social.orcid.api.MessageOperations;
import org.springframework.social.orcid.jaxb.beans.OrcidMessage;
import org.springframework.social.orcid.jaxb.beans.OrcidProfile;
import org.springframework.social.orcid.jaxb.beans.impl.OrcidMessageImpl;
import org.springframework.social.orcid.utils.OrcidConfigBroker;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yuci Gou
 *
 */
public class MessageOperationsImpl extends AbstractOrcidOperations implements MessageOperations {

	private final RestTemplate restTemplate;
	private RestTemplate pubRestTemplate;
	
	private String accessToken;
	
	public MessageOperationsImpl(OrcidApiImpl orcidTemplate, RestTemplate restTemplate, boolean authorized, String accessToken) {
		super(authorized);
		this.restTemplate = restTemplate;
		this.accessToken = accessToken;
		this.pubRestTemplate = new RestTemplate();
	}

	@Override
	public OrcidProfile getOrcidProfile(String orcidId, boolean isPublic) {
	    Assert.hasText(orcidId, "ORCID ID empty");
	    
	    String url;
	    RestTemplate restTmp;
	    if (isPublic) {
	        url = OrcidConfigBroker.getOrcidConfig().getPubApiUrl();
	        restTmp = pubRestTemplate;
	    } else {
	        url = OrcidConfigBroker.getOrcidConfig().getApiUrl();
	        restTmp = restTemplate;
	    }
		url += orcidId + "/orcid-profile";

		// Set XML content type explicitly to force response in XML (If not spring gets response in JSON)
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<OrcidMessageImpl> responseEntity = restTmp.exchange(url, HttpMethod.GET, entity, OrcidMessageImpl.class);;
		if (responseEntity == null) {
		    return null;
		}
		OrcidMessage response = responseEntity.getBody();		
		return response != null ? response.getOrcidProfile() : null;
	}

	@Override
	public OrcidProfile getOrcidProfile() {
        requireAuthorization();
        Assert.hasText(accessToken, "Authorized but no access token!");
		String orcidId = OrcidInfo.getInstance().getOrcid(accessToken);
		return getOrcidProfile(orcidId, true);
	}

    @Override
    public boolean addWorks(String orcidId, DOMSource domSource) {
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        boolean gotSourceHttpMessageConverter = false;
        for (HttpMessageConverter<?> messageConverter: messageConverters) {
            if (messageConverter instanceof SourceHttpMessageConverter) {
                gotSourceHttpMessageConverter = true;
            }
        }
        if (!gotSourceHttpMessageConverter) {
            messageConverters.add(new SourceHttpMessageConverter<DOMSource>());
            restTemplate.setMessageConverters(messageConverters);
        }
        
        String url = OrcidConfigBroker.getOrcidConfig().getApiUrl();
        url += orcidId + "/orcid-works";        
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        headers.set("Content-Type", "application/orcid+xml");

        HttpEntity<DOMSource> entity = new HttpEntity<DOMSource>(domSource, headers);
               
        ResponseEntity<SAXSource> orcidOutput;
        try {
            orcidOutput = restTemplate.exchange(url, HttpMethod.POST, entity, SAXSource.class);
        } catch (HttpClientErrorException e) {
            HttpStatus httpStatus = e.getStatusCode();
            if (HttpStatus.UNAUTHORIZED == httpStatus) {
                throw e;
            } else if(HttpStatus.CONFLICT == httpStatus){
                System.out.println("The queried Orcid Account is locked. Can't retrieve data. Don't worry.");
                throw e;
            } else {
                System.out.println("URL in question: " + url);
                System.out.println("Exception getting ORCID document: " + e.getMessage());
                throw e;
            }
        } catch (Exception e) {
            System.out.println("URL in question: " + url);
            System.out.println("Exception getting ORCID document: " + e.getMessage());
            throw e;
        }
        
        return orcidOutput != null && orcidOutput.getStatusCode() != null && orcidOutput.getStatusCode().value() == HttpStatus.CREATED.value(); 
    }
}
