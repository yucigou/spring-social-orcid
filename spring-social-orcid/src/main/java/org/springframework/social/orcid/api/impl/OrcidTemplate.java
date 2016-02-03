package org.springframework.social.orcid.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.orcid.api.MessageOperations;
import org.springframework.social.orcid.api.OrcidApi;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

public class OrcidTemplate extends AbstractOAuth2ApiBinding implements OrcidApi {

	private MessageOperations messageOperations;
	private String orcidId;

	/**
	 * Create a new instance of FacebookTemplate. This constructor creates a new
	 * FacebookTemplate able to perform unauthenticated operations against
	 * Facebook's Graph API. Some operations do not require OAuth
	 * authentication. For example, retrieving a specified user's profile or
	 * feed does not require authentication (although the data returned will be
	 * limited to what is publicly available). A FacebookTemplate created with
	 * this constructor will support those operations. Those operations
	 * requiring authentication will throw {@link NotAuthorizedException}.
	 */
	public OrcidTemplate() {
		initialize();
	}

	/**
	 * Create a new instance of FacebookTemplate. This constructor creates the
	 * FacebookTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Facebook after a successful OAuth 2
	 *            authentication (or through Facebook's JS library).
	 */
	public OrcidTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	// private helpers
	private void initialize() {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}

	private void initSubApis() {
		messageOperations = new MessageOperationsImpl(this, getRestTemplate(), isAuthorized());
	}

	@Override
	public MessageOperations messageOperations() {
		return messageOperations;
	}
}
