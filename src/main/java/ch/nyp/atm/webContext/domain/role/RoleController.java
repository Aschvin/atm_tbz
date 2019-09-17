package ch.nyp.atm.webContext.domain.role;

import ch.nyp.atm.webContext.domain.role.dto.RoleDTO;
import ch.nyp.atm.webContext.domain.role.dto.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This class holds all REST endpoints targeted towards the entity role.
 *
 * @author Yves Kaufmann
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
	
	private RoleService roleService;

	private RoleMapper roleMapper;

	public RoleController() {
		super();
	}

	@Autowired
	public RoleController(RoleService roleservice, RoleMapper roleMapper) {
		this.roleService = roleservice;
		this.roleMapper = roleMapper;
	}
	
	/**
	 * This method returns the requested role
	 *
	 * @param  id Id of the requested role
	 * @return    ResponseEntity with the role that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<RoleDTO> getById(@PathVariable Long id) {
		Role role = roleService.findById(id);
		return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
	}
	
	/**
	 * This method returns all roles
	 *
	 * @return ResponseEntity with all existing roles
	 */
	@GetMapping("")
	public @ResponseBody ResponseEntity<List<RoleDTO>> getAll() {
		List<Role> roles = roleService.findAll();
		return new ResponseEntity<>(roleMapper.toDTOs(roles), HttpStatus.OK);
	}
	
	/**
	 * This method creates an role
	 *
	 * @return ResponseEntity with the role that was created
	 */
	@PostMapping("")
	public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO role) {
		roleService.save(roleMapper.fromDTO(role));
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested role
	 *
	 * @param  id   Id of the role that should get updated
	 * @param  role role entity to which the requested role should get updated to
	 * @return      ResponseEntity with the updated role
	 */
	@PutMapping("/{id}")
	public ResponseEntity<RoleDTO> updateById(@PathVariable Long id, @RequestBody RoleDTO role) {
		roleService.updateById(id, roleMapper.fromDTO(role));
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested role
	 *
	 * @param  id Id of the role that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		roleService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
