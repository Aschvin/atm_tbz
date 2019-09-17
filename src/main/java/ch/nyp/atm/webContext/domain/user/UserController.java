package ch.nyp.atm.webContext.domain.user;

import ch.nyp.atm.webContext.domain.user.dto.UserMapper;
import ch.nyp.atm.webContext.domain.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This class holds the endpoints is responsible for users
 *
 * @author Yves Kaufmann
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	private UserMapper userMapper;

	public UserController() {}

	@Autowired
	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}
	
	/**
	 * This method returns the requested user
	 *
	 * @param  id Id of the requested user
	 * @return    ResponseEntity with the user that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
	}
	
	/**
	 * This method returns all users
	 *
	 * @return ResponseEntity with all existing users
	 */
	@GetMapping("")
	public @ResponseBody ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
	}
	
	/**
	 * This method creates an user
	 *
	 * @return ResponseEntity with the user that was created
	 */
	@PostMapping("")
	public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO user) {
		userService.save(userMapper.fromDTO(user));
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested user
	 *
	 * @param  id   Id of the user that should get updated
	 * @param  user user entity to which the requested user should get updated to
	 * @return      ResponseEntity with the updated user
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO user) {
		userService.updateById(id, userMapper.fromDTO(user));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested user
	 *
	 * @param  id Id of the user that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
