package org.springframework.social.orcid.api;

import javax.xml.transform.dom.DOMSource;

import org.springframework.social.orcid.jaxb.beans.OrcidProfile;

/**
 * ORCID APIs
 * 
 * @author Yuci Gou
 *
 */
public interface MessageOperations {
	OrcidProfile getOrcidProfile();
	OrcidProfile getOrcidProfile(String orcidId, boolean isPublic);
		
	/**
	 * Add works to the ORCID record
	 * 
	 * @param orcidId
	 * @param document
	 * @return
	 */
	boolean addWorks(String orcidId, DOMSource document);
}
