package org.springframework.social.orcid.api.impl;

import java.util.Map;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

/**
 * @author Yuci Gou
 */
public class OrcidOAuth2Template extends OAuth2Template {

	public OrcidOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
	    super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }
	
	@Override
	@SuppressWarnings("unchecked")	
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
	    Map<String, Object> result = getRestTemplate().postForObject(accessTokenUrl, parameters, Map.class);
	    String orcidId = (String) result.get("orcid");
	    String accessToken = (String) result.get("access_token");
	    OrcidInfo.getInstance().addOrcid(orcidId, accessToken);
		return createAccessGrant(accessToken, (String) result.get("scope"), (String) result.get("refresh_token"), getIntegerValue(result, "expires_in"), result);
	}
	
	private Long getIntegerValue(Map<String, Object> map, String key) {
        try {
            return Long.valueOf(String.valueOf(map.get(key))); // normalize to String before creating integer value;            
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
