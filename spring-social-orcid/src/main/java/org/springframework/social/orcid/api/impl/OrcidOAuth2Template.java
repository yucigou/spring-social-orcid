/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.orcid.api.impl;

import java.util.Map;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.converter.xml.SourceHttpMessageConverter;

/**
 * @author Yuci Gou
 */
public class OrcidOAuth2Template extends OAuth2Template {

    /*
	public OrcidOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://www.facebook.com/v1.0/dialog/oauth", "https://graph.facebook.com/v1.0/oauth/access_token");
		setUseParametersForClientAuthentication(true);
	}*/
	
	public OrcidOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
	    super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }
	
//	@Override
//    protected RestTemplate createRestTemplate() {
//	    RestTemplate restTemplate = super.createRestTemplate();
//	    restTemplate.getMessageConverters().add(new SourceHttpMessageConverter<>());
//        return restTemplate;
//    }
	
	@Override
	@SuppressWarnings("unchecked")	
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
	    Map<String, Object> result = getRestTemplate().postForObject(accessTokenUrl, parameters, Map.class);
		// MultiValueMap<String, String> response = getRestTemplate().postForObject(accessTokenUrl, parameters, MultiValueMap.class);
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
