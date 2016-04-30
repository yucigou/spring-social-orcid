package org.springframework.social.orcid.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.orcid.api.OrcidApi;
import org.springframework.social.orcid.api.impl.OrcidOAuth2Template;
import org.springframework.social.orcid.utils.OrcidConfigBroker;
import org.springframework.social.orcid.api.impl.OrcidApiImpl;


/**
 * @author ygou
 *
 * Reference:
 *   1. http://members.orcid.org/api/tokens-through-3-legged-oauth-authorization
 */
public class OrcidServiceProvider extends AbstractOAuth2ServiceProvider<OrcidApi> {

    public OrcidServiceProvider(String clientId, String clientSecret) {
        super(getOAuth2Template(clientId, clientSecret));
    }

//    private static OAuth2Template getOAuth2Template(String clientId, String clientSecret) {
//            OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret,
//                    "http://sandbox.orcid.org/oauth/authorize",
//                    "http://api.sandbox.orcid.org/oauth/token");
//            oAuth2Template.setUseParametersForClientAuthentication(true);
//            return oAuth2Template;
//    }
    private static OAuth2Template getOAuth2Template(String clientId, String clientSecret) {
        String authorizeUrl = OrcidConfigBroker.getOrcidConfig().getAuthorizeUrl();
        String accessTokenUrl = OrcidConfigBroker.getOrcidConfig().getAccessTokenUrl();
        OrcidOAuth2Template oAuth2Template = new OrcidOAuth2Template(clientId, clientSecret, authorizeUrl, accessTokenUrl);                
                // "http://sandbox.orcid.org/oauth/authorize",
                // "http://api.sandbox.orcid.org/oauth/token");
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    public OrcidApi getApi(String accessToken) {
            return new OrcidApiImpl(accessToken);
    }
    
}

