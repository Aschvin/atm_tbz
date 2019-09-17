package ch.nyp.atm.webContext.domain.user.dto;

import ch.nyp.atm.config.generic.DTOMapper;
import ch.nyp.atm.webContext.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface UserMapper extends DTOMapper<User, UserDTO> {
	
}
