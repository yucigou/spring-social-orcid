package org.springframework.social.orcid.api.impl;

import java.util.HashMap;
import java.util.Map;

public class OrcidInfo {
    private Map<String, String> accessTokenOrcidMap;
    
    private static OrcidInfo orcidInfo = new OrcidInfo();
    private OrcidInfo() {
        accessTokenOrcidMap = new HashMap<String, String>();
    }
    
    public static OrcidInfo getInstance() {
        return orcidInfo;
    }
    
    public String getOrcid(String accessToken) {
        return accessTokenOrcidMap.get(accessToken);
    }
    
    public synchronized void addOrcid(String orcid, String accessToken) {
        accessTokenOrcidMap.put(accessToken, orcid);
    }
}
