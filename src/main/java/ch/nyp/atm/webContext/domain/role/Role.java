package ch.nyp.atm.webContext.domain.role;

import ch.nyp.atm.config.generic.ExtendedEntity;
import ch.nyp.atm.webContext.domain.authority.Authority;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity Role. A user can hold multiple roles e.g "ROLE_ADMIN".
 *
 * @author Yves Kaufmann
 */

@Entity
@Table(name = "role")
public class Role extends ExtendedEntity {

    @Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "role_authority",
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "authority_id")
	)
	private Set<Authority> authorities;

	public Role() {
		super();
	}

	public Role(String name, Set<Authority> authorities) {
		this.name = name;
		this.authorities = authorities;
	}

	public Role(Long id, String name, Set<Authority> authorities) {
		super(id);
		this.name = name;
		this.authorities = authorities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
