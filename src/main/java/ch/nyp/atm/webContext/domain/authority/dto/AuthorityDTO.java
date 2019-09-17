package ch.nyp.atm.webContext.domain.authority.dto;

import ch.nyp.atm.config.generic.ExtendedDTO;

public class AuthorityDTO extends ExtendedDTO {

	private String name;

	public AuthorityDTO() {
		super();
	}

	public AuthorityDTO(Long id) {
		super(id);
	}

	public AuthorityDTO(Long id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
