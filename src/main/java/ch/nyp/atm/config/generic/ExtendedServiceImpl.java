package ch.nyp.atm.config.generic;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This class that implements the CrudService
 *
 * @author Yves Kaufmann
 * @param T Entity to be used. Childclass of ExtendedEntity
 */
public abstract class ExtendedServiceImpl<T extends ExtendedEntity> implements ExtendedService<T> {

	protected ExtendedJpaRepository<T> repository;

	public ExtendedServiceImpl(ExtendedJpaRepository<T> repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(T entity) {
		repository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T entity) {
		//TODO is this really needed?

		repository.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(Long id) throws NoSuchElementException {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new NoSuchElementException(String.format("Entity with ID '%d' could not be found", id));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateById(Long id, T entity) throws NoSuchElementException {
		if(repository.existsById(id)) {
			entity.setId(id);

			repository.save(entity);
		} else {
			throw new NoSuchElementException(String.format("Entity with ID '%d' could not be found", id));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findById(Long id) {
		Optional<T> entity = repository.findById(id);

		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new NoSuchElementException(String.format("Entity with ID '%d' could not be found", id));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

}
