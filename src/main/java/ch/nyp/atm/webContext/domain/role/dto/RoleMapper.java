package ch.nyp.atm.webContext.domain.role.dto;

import ch.nyp.atm.config.generic.DTOMapper;
import ch.nyp.atm.webContext.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface RoleMapper extends DTOMapper<Role, RoleDTO> {
	
}
