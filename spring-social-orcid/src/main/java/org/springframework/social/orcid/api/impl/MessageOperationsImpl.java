package org.springframework.social.orcid.api.impl;

import java.net.URI;

import org.springframework.social.orcid.api.MessageOperations;
import org.springframework.social.orcid.jaxb.beans.OrcidProfile;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

public class MessageOperationsImpl extends AbstractOrcidOperations implements MessageOperations {

	private final RestTemplate restTemplate;
	
	public MessageOperationsImpl(OrcidTemplate orcidTemplate, RestTemplate restTemplate, boolean authorized) {
		super(authorized);
		this.restTemplate = restTemplate;
	}

	@Override
	public OrcidProfile getOrcidProfile(String orcidId) {
		requireAuthorization();
		URI uri = URIBuilder.fromUri("https://pub.orcid.org/v1.2/"+orcidId+"/orcid-bio/").build();
		OrcidProfile response = restTemplate.getForObject(uri, OrcidProfile.class);
		return response;
	}

	@Override
	public OrcidProfile getOrcidProfile() {
		// TODO Auto-generated method stub
		return null;
	}
}
