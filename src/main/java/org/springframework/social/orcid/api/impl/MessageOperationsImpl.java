package org.springframework.social.orcid.api.impl;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.orcid.api.MessageOperations;
import org.springframework.social.orcid.jaxb.beans.OrcidMessage;
import org.springframework.social.orcid.jaxb.beans.OrcidProfile;
import org.springframework.social.orcid.jaxb.beans.impl.OrcidMessageImpl;
import org.springframework.social.orcid.utils.OrcidConfigBroker;
import org.springframework.util.Assert;
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
}
