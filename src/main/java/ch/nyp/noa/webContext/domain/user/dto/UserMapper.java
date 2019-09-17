package ch.nyp.noa.webContext.domain.user.dto;

import ch.nyp.noa.config.generic.DTOMapper;
import ch.nyp.noa.webContext.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface UserMapper extends DTOMapper<User, UserDTO> {
	
}
