package ch.nyp.noa.webContext.domain.user.dto;

import ch.nyp.noa.webContext.domain.user.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDTO(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setBirthdate( userDto.getBirthdate() );
        user.setEmail( userDto.getEmail() );

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setBirthdate( user.getBirthdate() );
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }

    @Override
    public List<User> fromDTOs(List<UserDTO> userDTOs) {
        if ( userDTOs == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOs.size() );
        for ( UserDTO userDTO : userDTOs ) {
            list.add( fromDTO( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public Set<User> fromDTOs(Set<UserDTO> userDTOs) {
        if ( userDTOs == null ) {
            return null;
        }

        Set<User> set = new HashSet<User>( Math.max( (int) ( userDTOs.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : userDTOs ) {
            set.add( fromDTO( userDTO ) );
        }

        return set;
    }

    @Override
    public Set<UserDTO> toDTOs(Set<User> users) {
        if ( users == null ) {
            return null;
        }

        Set<UserDTO> set = new HashSet<UserDTO>( Math.max( (int) ( users.size() / .75f ) + 1, 16 ) );
        for ( User user : users ) {
            set.add( toDTO( user ) );
        }

        return set;
    }
}
