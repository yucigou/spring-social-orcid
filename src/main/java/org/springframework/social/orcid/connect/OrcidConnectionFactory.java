package org.springframework.social.orcid.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.orcid.api.OrcidApi;


/**
 * ORCID ConnectionFactory implementation.
 * 
 * @author Yuci Gou
 */
public class OrcidConnectionFactory extends OAuth2ConnectionFactory<OrcidApi> {
    
    public static final String PROVIDER_ID_ORCID = "orcid";
	/**
	 * Creates a OrcidConnectionFactory for the given application ID and secret
	 * 
	 * @param appId The application's App ID as assigned by ORCID 
	 * @param appSecret The application's App Secret as assigned by ORCID
	 */
	public OrcidConnectionFactory(String appId, String appSecret) {
		super(PROVIDER_ID_ORCID, new OrcidServiceProvider(appId, appSecret), new OrcidAdapter());
	}

}
