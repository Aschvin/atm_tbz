package ch.nyp.atm.webContext.domain.authority.dto;

import ch.nyp.atm.config.generic.DTOMapper;
import ch.nyp.atm.webContext.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AuthorityMapper extends DTOMapper<Authority, AuthorityDTO> {
	
}