package ch.nyp.noa.webContext.domain.role;

import ch.nyp.noa.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This class implements all data access related methods targeted towards the
 * entity role.
 *
 * @author Yves Kaufmann
 */
@Service
class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {
	
	/**
	 * @param repository
	 */
	@Autowired
	RoleServiceImpl(RoleRepository repository) {
		super(repository);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role findByName(String name) {
		Optional<Role> optional = ((RoleRepository) repository).findByName(name);

		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new NoSuchElementException(String.format("Role with name '%s' could not be found", name));
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByName(String name) {
		((RoleRepository) repository).deleteByName(name);
	}
}
