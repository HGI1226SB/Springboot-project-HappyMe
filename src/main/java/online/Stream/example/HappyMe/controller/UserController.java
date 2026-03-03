package online.Stream.example.HappyMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.User;
import online.Stream.example.HappyMe.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	
	@Autowired
	private UserService userService;
	@RequestMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		ResponseStructure<User> structure = userService.registerUser(user);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}
	
	/*login
	 * findbyemail
	 * findbyId
	 */
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		ResponseStructure<User> structure = userService.loginUser(user);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	@GetMapping("/findByEmail")
	public ResponseEntity<?> findByEmail(@RequestParam String email) {
		ResponseStructure<User> structure = userService.findByEmail(email);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	@GetMapping("/findById")
	public ResponseEntity<?> findById(@RequestParam int id) {
		ResponseStructure<User> structure = userService.findById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam int id) {
		ResponseStructure structure = userService.deleteById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	
	

}
