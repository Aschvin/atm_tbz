package ch.nyp.atm.webContext.domain.role.dto;

import ch.nyp.atm.config.generic.ExtendedDTO;
import ch.nyp.atm.config.validation.notnull.NotNull;

public class RoleDTO extends ExtendedDTO {

    @NotNull
	private String name;

	public RoleDTO() {
		super();
	}

	public RoleDTO(Long id) {
		super(id);
	}

	public RoleDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
