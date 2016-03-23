package org.springframework.social.orcid.api.impl;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.orcid.api.MessageOperations;
import org.springframework.social.orcid.jaxb.beans.OrcidProfile;
import org.springframework.social.support.URIBuilder;
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
	    
		URI uri = URIBuilder.fromUri("http://pub.sandbox.orcid.org/v1.2/"+orcidId+"/orcid-profile").build();
		// OrcidProfile response = restTemplate.getForObject(uri, OrcidProfile.class);
		HttpEntity<OrcidProfile> request = new HttpEntity<>(null);
		ResponseEntity<OrcidProfile> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, request, OrcidProfile.class);
		OrcidProfile response = responseEntity.getBody();
		return response;
	}

	@Override
	public OrcidProfile getOrcidProfile() {
        requireAuthorization();
        Assert.hasText(accessToken, "Authorized but no access token!");
		String orcidId = OrcidInfo.getInstance().getOrcid(accessToken);
		return getOrcidProfile(orcidId);
	}
}
