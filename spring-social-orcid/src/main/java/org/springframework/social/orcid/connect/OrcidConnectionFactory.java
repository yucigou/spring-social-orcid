package org.springframework.social.orcid.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.orcid.api.OrcidApi;


/**
 * Facebook ConnectionFactory implementation.
 * @author Keith Donald
 * @author Craig Walls
 */
public class OrcidConnectionFactory extends OAuth2ConnectionFactory<OrcidApi> {
	/**
	 * Creates a FacebookConnectionFactory for the given application ID, secret, and namespace.
	 * @param appId The application's App ID as assigned by Facebook 
	 * @param appSecret The application's App Secret as assigned by Facebook
	 */
	public OrcidConnectionFactory(String appId, String appSecret) {
		super("orcid", new OrcidServiceProvider(appId, appSecret), new OrcidAdapter());
	}

}
