package ch.nyp.noa.webContext.domain.user;

import ch.nyp.noa.config.generic.ExtendedEntity;
import ch.nyp.noa.webContext.domain.role.Role;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * This class is the Entity User. A User can hold multiple roles with its own
 * authorities.
 *
 * @author Yves Kaufmann
 */
@Entity
@Table(name = "users")
public class User extends ExtendedEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Column(name = "email")
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_role",
		joinColumns = @JoinColumn(name = "users_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;

	@Column(name = "account_expiration_date")
	private LocalDate accountExpirationDate;

	@Column(name = "credentials_expiration_date")
	private LocalDate credentialsExpirationDate;

	@Column(name = "locked")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean locked;

	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;

	public User() {
		super();
	}

	public User(
			String username, String password, String firstName, String lastName, LocalDate birthdate, String email,
			Set<Role> roles, LocalDate accountExpirationDate, LocalDate credentialsExpirationDate, Boolean locked,
			Boolean enabled
	) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.roles = roles;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
	}

	public User(
			Long id, String username, String password, String firstName, String lastName, LocalDate birthdate,
			String email, Set<Role> roles, LocalDate accountExpirationDate, LocalDate credentialsExpirationDate,
			Boolean locked, Boolean enabled
	) {
		super(id);
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.roles = roles;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the accountExpirationDate
	 */
	public LocalDate getAccountExpirationDate() {
		return accountExpirationDate;
	}

	/**
	 * @param accountExpirationDate the accountExpirationDate to set
	 */
	public void setAccountExpirationDate(LocalDate accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	/**
	 * @return the credentialsExpirationDate
	 */
	public LocalDate getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	/**
	 * @param credentialsExpirationDate the credentialsExpirationDate to set
	 */
	public void setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	/**
	 * @return the locked
	 */
	public Boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the enabled
	 */
	public Boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}