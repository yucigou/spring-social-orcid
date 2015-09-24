package org.springframework.social.orcid.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import org.springframework.social.orcid.api.Orcid;

public class OrcidConnectionFactory extends OAuth2ConnectionFactory<Orcid> {

    public OrcidConnectionFactory(String providerId, OAuth2ServiceProvider<Orcid> serviceProvider,
            ApiAdapter<Orcid> apiAdapter) {
        super(providerId, serviceProvider, apiAdapter);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
