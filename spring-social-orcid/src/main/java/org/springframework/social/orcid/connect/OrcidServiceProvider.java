package org.springframework.social.orcid.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.orcid.api.Orcid;
import org.springframework.social.orcid.api.impl.OrcidTemplate;


/**
 * @author ygou
 *
 * Reference:
 *   1. http://members.orcid.org/api/tokens-through-3-legged-oauth-authorization
 */
public class OrcidServiceProvider extends AbstractOAuth2ServiceProvider<Orcid> {

    public OrcidServiceProvider(String clientId, String clientSecret) {
            super(getOAuth2Template(clientId, clientSecret));
    }

    private static OAuth2Template getOAuth2Template(String clientId, String clientSecret) {
            OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret,
                    "https://orcid.org/oauth/authorize",
                    "https://api.orcid.org/oauth/token");
            oAuth2Template.setUseParametersForClientAuthentication(true);
            return oAuth2Template;
    }

    public Orcid getApi(String accessToken) {
            return new OrcidTemplate(accessToken);
    }
    
}

