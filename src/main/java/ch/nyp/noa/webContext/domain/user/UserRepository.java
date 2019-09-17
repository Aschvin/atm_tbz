package ch.nyp.noa.webContext.domain.user;

import ch.nyp.noa.config.generic.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 *
 * @author Yves Kaufmann
 */
@Repository
public interface UserRepository extends ExtendedJpaRepository<User> {
	
	/**
	 * This method finds a User with a given name
	 *
	 * @param  name Descriptive name of User
	 * @return      Returns requested User with given descriptive name of User
	 */
	Optional<User> findByUsername(String name);
	
	/**
	 * This method deletes the requested User with a given name
	 *
	 * @param name Descriptive name of User
	 */
	void deleteByUsername(String name);
}
