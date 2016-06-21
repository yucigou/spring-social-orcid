package org.springframework.social.orcid.api.impl;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.springframework.social.orcid.jaxb.beans.OrcidProfile;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.*;

/**
 * @author Yuci Gou
 *
 */
public class MessageOperationsImplTest extends AbstractOrcidApiTest {
    @Test
    public void getDirectMessage() {
        unauthorizedMockServer.expect(requestTo("http://pub.sandbox.orcid.org/v1.2/0000-0001-7155-7939/orcid-profile"))
            .andExpect(method(GET))
            .andRespond(withSuccess(xmlResource("orcidProfile"), APPLICATION_XML));
        OrcidProfile message = unauthorizedOrcid.messageOperations().getOrcidProfile("0000-0001-7155-7939", true);
        assertSingleOrcidProfile(message);
    }
    
    private void assertSingleOrcidProfile(OrcidProfile profile) {
        assertEquals("Gou", profile.getOrcidBio().getPersonalDetails().getFamilyName());
    }
}
