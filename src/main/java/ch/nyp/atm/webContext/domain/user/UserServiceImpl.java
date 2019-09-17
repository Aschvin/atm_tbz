package ch.nyp.atm.webContext.domain.user;

import ch.nyp.atm.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(repository);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void save(User entity) {
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

		repository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		
		if (user == null) { throw new UsernameNotFoundException(String.format("User with name '%s' could not be found", username)); }
		return new UserDetailsImpl(user);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByUsername(String name) {
		Optional<User> optional = ((UserRepository) repository).findByUsername(name);

		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new NoSuchElementException(String.format("User with name '%s' could not be found", name));
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByUsername(String name) {
		((UserRepository) repository).deleteByUsername(name);
	}
	
}
