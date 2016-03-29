package org.springframework.social.orcid.api.impl;

import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.orcid.api.MessageOperations;
import org.springframework.social.orcid.api.OrcidApi;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

public class OrcidApiImpl extends AbstractOAuth2ApiBinding implements OrcidApi {

	private MessageOperations messageOperations;

	/**
	 * Create a new instance of FacebookTemplate. This constructor creates the
	 * FacebookTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Facebook after a successful OAuth 2
	 *            authentication (or through Facebook's JS library).
	 */
	public OrcidApiImpl(String accessToken) {
		super(accessToken);
		initialize(accessToken);		
	}

    public OrcidApiImpl() {
        initialize(null);
    }

    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
    }
    
    // private helpers
	private void initialize(String accessToken) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis(accessToken);
	}

	private void initSubApis(String accessToken) {
		messageOperations = new MessageOperationsImpl(this, getRestTemplate(), isAuthorized(), accessToken);
	}

	@Override
	public MessageOperations messageOperations() {
		return messageOperations;
	}
}
