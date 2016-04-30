package org.springframework.social.orcid.utils;

public class OrcidConfig {
    
    private String frontendUrl;    
    private String apiUrl;
    private String pubApiUrl;
    private String authorizeUrl;
    private String accessTokenUrl;
    
    public void setFrontendUrl(String frontendUrl) {
        this.frontendUrl = frontendUrl;        
    }
    public String getFrontendUrl() {
        return this.frontendUrl;
    }
    public String getApiUrl() {
        return apiUrl;
    }
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    public String getPubApiUrl() {
        return pubApiUrl;
    }
    public void setPubApiUrl(String pubApiUrl) {
        this.pubApiUrl = pubApiUrl;
    }
    public String getAuthorizeUrl() {
        return authorizeUrl;
    }
    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }
    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }
    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }
}
