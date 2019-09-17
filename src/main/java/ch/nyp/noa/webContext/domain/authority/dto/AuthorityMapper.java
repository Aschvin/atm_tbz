package ch.nyp.noa.webContext.domain.authority.dto;

import ch.nyp.noa.config.generic.DTOMapper;
import ch.nyp.noa.webContext.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AuthorityMapper extends DTOMapper<Authority, AuthorityDTO> {
	
}