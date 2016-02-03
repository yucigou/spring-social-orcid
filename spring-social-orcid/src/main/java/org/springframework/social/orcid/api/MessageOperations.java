package org.springframework.social.orcid.api;

import org.springframework.social.orcid.jaxb.beans.OrcidProfile;

public interface MessageOperations {
	OrcidProfile getOrcidProfile();
	OrcidProfile getOrcidProfile(String orcidId);
}
