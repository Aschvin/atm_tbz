package ch.nyp.noa.webContext.domain.authority;

import ch.nyp.noa.config.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * This class is the entity authority. A role can hold multiple authorities e.g
 * "WRITE_PRIVILEDGE" or "READ_PRIVILEDGE"
 *
 * @author Yves Kaufmann
 */

@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {

	@Column(name = "name")
	private String name;

	public Authority() {
		super();
	}

	public Authority(Long id) {
		super(id);
	}

	public Authority(Long id, String authority) {
		super(id);
		name = authority;
	}

	public Authority(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
