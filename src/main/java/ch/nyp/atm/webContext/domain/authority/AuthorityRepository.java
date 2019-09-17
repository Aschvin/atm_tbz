package ch.nyp.atm.webContext.domain.authority;

import ch.nyp.atm.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface holds all data access related methods targeted towards the
 * entity authority
 *
 * @author Yves Kaufmann
 */
@Repository
interface AuthorityRepository extends ExtendedJpaRepository<Authority> {

	/**
	 * This method finds an authority with a given name.
	 *
	 * @param name Descriptive name of Authority
	 * @return Returns requested Authority with given descriptive name of Authority
	 */
	Optional<Authority> findByName(String name);

	/**
	 * This method deletes the requested authority with a given name.
	 *
	 * @param name Descriptive name of Authority
	 */
	void deleteByName(String name);
}
