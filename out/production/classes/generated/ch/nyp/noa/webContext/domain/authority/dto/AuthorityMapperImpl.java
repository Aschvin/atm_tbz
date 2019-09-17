package ch.nyp.noa.webContext.domain.authority.dto;

import ch.nyp.noa.webContext.domain.authority.Authority;
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
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public Authority fromDTO(AuthorityDTO authorityDTO) {
        if ( authorityDTO == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( authorityDTO.getId() );
        authority.setName( authorityDTO.getName() );

        return authority;
    }

    @Override
    public AuthorityDTO toDTO(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( authority.getId() );
        authorityDTO.setName( authority.getName() );

        return authorityDTO;
    }

    @Override
    public List<Authority> fromDTOs(List<AuthorityDTO> authorityDTOs) {
        if ( authorityDTOs == null ) {
            return null;
        }

        List<Authority> list = new ArrayList<Authority>( authorityDTOs.size() );
        for ( AuthorityDTO authorityDTO : authorityDTOs ) {
            list.add( fromDTO( authorityDTO ) );
        }

        return list;
    }

    @Override
    public List<AuthorityDTO> toDTOs(List<Authority> authorities) {
        if ( authorities == null ) {
            return null;
        }

        List<AuthorityDTO> list = new ArrayList<AuthorityDTO>( authorities.size() );
        for ( Authority authority : authorities ) {
            list.add( toDTO( authority ) );
        }

        return list;
    }

    @Override
    public Set<Authority> fromDTOs(Set<AuthorityDTO> authorityDTOs) {
        if ( authorityDTOs == null ) {
            return null;
        }

        Set<Authority> set = new HashSet<Authority>( Math.max( (int) ( authorityDTOs.size() / .75f ) + 1, 16 ) );
        for ( AuthorityDTO authorityDTO : authorityDTOs ) {
            set.add( fromDTO( authorityDTO ) );
        }

        return set;
    }

    @Override
    public Set<AuthorityDTO> toDTOs(Set<Authority> authorities) {
        if ( authorities == null ) {
            return null;
        }

        Set<AuthorityDTO> set = new HashSet<AuthorityDTO>( Math.max( (int) ( authorities.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : authorities ) {
            set.add( toDTO( authority ) );
        }

        return set;
    }
}
