package org.springframework.social.orcid.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.orcid.api.OrcidApi;
import org.springframework.social.orcid.jaxb.beans.OrcidProfile;

/**
 * ORCID ApiAdapter implementation.
 * @author Yuci Gou
 */
public class OrcidAdapter implements ApiAdapter<OrcidApi> {

	public boolean test(OrcidApi orcid) {
		try {
			orcid.messageOperations().getOrcidProfile("0000-0001-7155-7939");
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(OrcidApi orcidApi, ConnectionValues values) {
		OrcidProfile profile = orcidApi.messageOperations().getOrcidProfile();
		values.setProviderUserId(profile.getOrcidIdentifier().getPath());
		values.setDisplayName(profile.getOrcidBio().getPersonalDetails().getGivenNames() + profile.getOrcidBio().getPersonalDetails().getFamilyName());
		values.setProfileUrl("http://sandbox.orcid.org/" + profile.getOrcidIdentifier().getPath());
	}

	public UserProfile fetchUserProfile(OrcidApi orcidApi) {
		OrcidProfile profile = orcidApi.messageOperations().getOrcidProfile();
		return new UserProfileBuilder().setName(profile.getOrcidBio().getPersonalDetails().getGivenNames()).
				setFirstName(profile.getOrcidBio().getPersonalDetails().getGivenNames()).
				setLastName(profile.getOrcidBio().getPersonalDetails().getFamilyName()).
				setEmail(null).setUsername(profile.getOrcidIdentifier().getPath()).build();
	}

	@Override
	public void updateStatus(OrcidApi api, String message) {
		// TODO Auto-generated method stub
	}
	
}
