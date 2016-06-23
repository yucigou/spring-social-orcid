package org.springframework.social.orcid.jaxb;

import java.net.URI;

import org.junit.Test;
import org.springframework.social.orcid.jaxb.beans.OrcidMessage;
import org.springframework.social.orcid.jaxb.beans.impl.OrcidMessageImpl;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yuci Gou
 *
 */
public class ProfileTest {
    @Test
    public void getProfile() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = URIBuilder.fromUri("http://pub.sandbox.orcid.org/v1.2/0000-0001-8160-1147/orcid-profile").build();
        OrcidMessage response = restTemplate.getForObject(uri, OrcidMessageImpl.class);

        System.out.println(response.getOrcidProfile().getOrcidBio().getPersonalDetails().getFamilyName());
    }
}
