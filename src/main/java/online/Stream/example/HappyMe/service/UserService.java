package online.Stream.example.HappyMe.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import online.Stream.example.HappyMe.Dao.UserDao;
import online.Stream.example.HappyMe.ResponseEntity.ResponseStructure;
import online.Stream.example.HappyMe.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	public ResponseStructure<User> registerUser(User user) {
		User user2 = userDao.registerUser(user);
		if (user2 != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(user2);
			structure.setTimestamp(LocalDateTime.now());
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("User registered successfully");
			return structure;
		} else {
			throw new RuntimeException("User registration failed");
		}
	}
	public ResponseStructure<User> loginUser(User user) {
		User user2 = userDao.loginUser(user);
		if (user2 != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(user2);
			structure.setTimestamp(LocalDateTime.now());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User logged in successfully");
			return structure;
		} else {
			throw new RuntimeException("Invalid email or password");
		}
	
	}
	public ResponseStructure<User> findByEmail(String email) {
		User user2 = userDao.findByEmail(email);
		if(user2!=null)
		{
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(user2);
			structure.setTimestamp(LocalDateTime.now());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User found successfully");
			return structure;
		}
		else
		{
			throw new RuntimeException("User not found with email: " + email);
		}
	}
	public ResponseStructure<User> findById(int id) {
		User user2 = userDao.findById(id);
		if (user2 != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(user2);
			structure.setTimestamp(LocalDateTime.now());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User found successfully");
			return structure;
		}
		else
		{
			throw new RuntimeException("User not found with id: " + id);
		}
	}
	public ResponseStructure deleteById(int id) {
		User user2=userDao.deleteById(id);;
		if (user2 != null) {
			
			ResponseStructure structure = new ResponseStructure<>();
			structure.setData(null);
			structure.setTimestamp(LocalDateTime.now());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User deleted successfully");
			return structure;
		} else {
			throw new RuntimeException("User not found with id: " + id);
		}
		
	}
	
	
	
	

}
