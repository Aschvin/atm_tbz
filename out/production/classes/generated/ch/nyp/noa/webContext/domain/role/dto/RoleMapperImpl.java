package ch.nyp.noa.webContext.domain.role.dto;

import ch.nyp.noa.webContext.domain.role.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-04T10:32:07+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role fromDTO(RoleDTO roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    @Override
    public RoleDTO toDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    @Override
    public List<Role> fromDTOs(List<RoleDTO> roleDTOs) {
        if ( roleDTOs == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( roleDTOs.size() );
        for ( RoleDTO roleDTO : roleDTOs ) {
            list.add( fromDTO( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toDTOs(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( toDTO( role ) );
        }

        return list;
    }

    @Override
    public Set<Role> fromDTOs(Set<RoleDTO> roleDTOs) {
        if ( roleDTOs == null ) {
            return null;
        }

        Set<Role> set = new HashSet<Role>( Math.max( (int) ( roleDTOs.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : roleDTOs ) {
            set.add( fromDTO( roleDTO ) );
        }

        return set;
    }

    @Override
    public Set<RoleDTO> toDTOs(Set<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        Set<RoleDTO> set = new HashSet<RoleDTO>( Math.max( (int) ( roles.size() / .75f ) + 1, 16 ) );
        for ( Role role : roles ) {
            set.add( toDTO( role ) );
        }

        return set;
    }
}
