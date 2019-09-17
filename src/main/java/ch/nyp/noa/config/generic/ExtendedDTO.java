package ch.nyp.noa.config.generic;

public class ExtendedDTO { // not abstract so that DTOs can reference only-id nested entities

	private Long id;

	public ExtendedDTO() {
		super();
	}

	public ExtendedDTO(Long id) {
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
