package org.springframework.social.orcid.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.orcid.api.Orcid;

public class OrcidAdapter implements ApiAdapter<Orcid> {

    @Override
    public boolean test(Orcid api) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setConnectionValues(Orcid api, ConnectionValues values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserProfile fetchUserProfile(Orcid api) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateStatus(Orcid api, String message) {
        // TODO Auto-generated method stub
        
    }

}
