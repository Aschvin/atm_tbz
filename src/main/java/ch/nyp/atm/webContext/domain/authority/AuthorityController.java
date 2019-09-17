package ch.nyp.atm.webContext.domain.authority;

import ch.nyp.atm.webContext.domain.authority.dto.AuthorityMapper;
import ch.nyp.atm.webContext.domain.authority.dto.AuthorityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class holds all REST endpoints targeted towards the entity authority
 *
 * @author Yves Kaufmann
 */
@RestController
@RequestMapping("/authorities")
public class AuthorityController {

	private AuthorityService authorityService;
	private AuthorityMapper authorityMapper;

	public AuthorityController() {
	}

	@Autowired
	public AuthorityController( AuthorityService authorityService, AuthorityMapper authorityMapper) {
		this.authorityService = authorityService;
		this.authorityMapper = authorityMapper;
	}

	/**
	 * This method returns the requested authority
	 *
	 * @param id The Authority's ID
	 * @return ResponseEntity with the Authority that was requested
	 */
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorityDTO> getById(@PathVariable Long id) {
		Authority authority = authorityService.findById(id);

		return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.OK);
	}

	/**
	 * This method returns all authorities
	 *
	 * @return ResponseEntity with all existing authorities
	 */
	@GetMapping("")
	public @ResponseBody ResponseEntity<List<AuthorityDTO>> getAll() {
		List<Authority> authorities = authorityService.findAll();
		return new ResponseEntity<>(authorityMapper.toDTOs(authorities), HttpStatus.OK);
	}

	/**
	 * This method creates an authority
	 *
	 * @param authority Authority entity which should be created
	 * @return ResponseEntity with the created Authority
	 */
	@PostMapping("")
	public @ResponseBody ResponseEntity<AuthorityDTO> create(@RequestBody AuthorityDTO authority) {
		authorityService.save(authorityMapper.fromDTO(authority));
		return new ResponseEntity<>(authority, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested authority
	 *
	 * @param id The Authority's ID
	 * @param authority Authority entity which should get updated
	 * @return ResponseEntity with the HTTP Status
	 */
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorityDTO> updateById(@PathVariable Long id, AuthorityDTO authority) {
		authorityService.updateById(id, authorityMapper.fromDTO(authority));
		return new ResponseEntity<>(authority, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested authority
	 *
	 * @param id The Authority's ID
	 * @return ResponseEntity with the HTTP Status
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		authorityService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
