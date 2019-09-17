package ch.nyp.atm.config.generic;

import javax.persistence.*;

/**
 * This class that covers the common attributes of all entities
 *
 * @author Yves Kaufmann
 */
@MappedSuperclass
public abstract class ExtendedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	public ExtendedEntity() {
		super();
	}

	public ExtendedEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}