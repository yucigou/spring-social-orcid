package org.springframework.social.orcid.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * @author Yuci Gou
 *
 */
public class AbstractOrcidOperations {
	
	private final boolean isAuthorized;

	public AbstractOrcidOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("orcid");
		}
	}
	
}
