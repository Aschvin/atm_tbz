package ch.nyp.atm.webContext.domain.authority;

import ch.nyp.atm.config.generic.ExtendedService;

/**
 * This interface holds all data access related methods targeted towards the
 * entity authority
 *
 * @author Yves Kaufmann
 */
interface AuthorityService extends ExtendedService<Authority> {

	/**
	 * This method finds an authority with a given name.
	 *
	 * @param name Descriptive name of Authority
	 * @return Returns requested Authority with given descriptive name of Authority
	 */
	Authority findByName(String name);

	/**
	 * This method deletes the requested authority with a given name.
	 *
	 * @param name Descriptive name of Authority
	 */
	void deleteByName(String name);
}
