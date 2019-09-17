package ch.nyp.atm.webContext.domain.authority;

import ch.nyp.atm.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This class implements all data access related methods targeted towards the
 * entity authority
 *
 * @author Yves Kaufmann
 */
@Service
class AuthorityServiceImpl extends ExtendedServiceImpl<Authority> implements AuthorityService {

	@Autowired
	AuthorityServiceImpl(AuthorityRepository repository) {
		super(repository);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Authority findByName(String name) {
		Optional<Authority> optional = ((AuthorityRepository) repository).findByName(name);

		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new NoSuchElementException(String.format("Authority with name '%s' could not be found", name));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByName(String name) {
		((AuthorityRepository) repository).deleteByName(name);
	}
}
