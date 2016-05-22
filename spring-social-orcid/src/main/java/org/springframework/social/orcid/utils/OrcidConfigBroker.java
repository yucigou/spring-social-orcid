package org.springframework.social.orcid.utils;

/**
 * @author Yuci Gou
 *
 */
public class OrcidConfigBroker {
    private static OrcidConfig orcidConfig;
    
    private OrcidConfigBroker(OrcidConfig orcidConfig) {
        OrcidConfigBroker.orcidConfig = orcidConfig;
    }
    
    public static OrcidConfig getOrcidConfig() {
        return OrcidConfigBroker.orcidConfig;
    }
}
