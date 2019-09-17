package ch.nyp.noa.webContext.domain.role;

import ch.nyp.noa.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface holds all data access related methods targeted towards the
 * entity role.
 *
 * @author Yves Kaufmann
 */
@Repository
interface RoleRepository extends ExtendedJpaRepository<Role> {
	
	/**
	 * This method finds an role with a given name
	 *
	 * @param  name Descriptive name of role
	 * @return      Returns requested role with given descriptive name of role
	 */
	Optional<Role> findByName(String name);
	
	/**
	 * This method deletes the requested role with a given name
	 *
	 * @param name Descriptive name of role
	 */
	void deleteByName(String name);
}
