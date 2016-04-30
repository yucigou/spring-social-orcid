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
//import org.springframework.social.support.URIBuilder;
//import java.net.URI;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class MessageOperationsImpl extends AbstractOrcidOperations implements MessageOperations {

	private final RestTemplate restTemplate;
	
	private String accessToken;
	
	public MessageOperationsImpl(OrcidApiImpl orcidTemplate, RestTemplate restTemplate, boolean authorized, String accessToken) {
		super(authorized);
		this.restTemplate = restTemplate;
		this.accessToken = accessToken;
	}

	@Override
	public OrcidProfile getOrcidProfile(String orcidId) {
	    Assert.hasText(orcidId, "ORCID ID empty");
	    
        ////////////////////////////////////////
	    // URI uri = URIBuilder.fromUri("http://pub.sandbox.orcid.org/v1.2/"+orcidId+"/orcid-profile").build();
	    // OrcidMessage response = restTemplate.getForObject(uri, OrcidMessageImpl.class);
        ////////////////////////////////////////
		
	    ////////////////////////////////////////
		// RestTemplate restTemplate = new RestTemplate();
		// String url = "http://pub.sandbox.orcid.org/v1.2/"+orcidId+"/orcid-profile";
	    // OrcidMessage response = restTemplate.getForObject(url, OrcidMessageImpl.class);
	    ////////////////////////////////////////
	    
	    ////////////////////////////////////////
	    // String url = "http://api.sandbox.orcid.org/v1.2/"+orcidId+"/orcid-profile";
		// OrcidMessage response = restTemplate.getForObject(url, OrcidMessageImpl.class);
		////////////////////////////////////////
		
		// String url = "http://api.sandbox.orcid.org/v1.2/"+orcidId+"/orcid-profile";
		String url = OrcidConfigBroker.getOrcidConfig().getApiUrl() + orcidId + "/orcid-profile";
		// Set XML content type explicitly to force response in XML (If not spring gets response in JSON)
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<OrcidMessageImpl> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, OrcidMessageImpl.class);
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
		return getOrcidProfile(orcidId);
	}
}
