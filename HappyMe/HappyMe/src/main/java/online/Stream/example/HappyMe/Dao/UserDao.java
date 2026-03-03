package online.Stream.example.HappyMe.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.Stream.example.HappyMe.Repository.UserRepository;
import online.Stream.example.HappyMe.entity.User;
@Repository
public class UserDao
{

	@Autowired
	private UserRepository userRepository;
	public  User registerUser(User user) {
		
		return userRepository.save(user);
	}
	public User loginUser(User user) {
		User user2 = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (user2 != null) {
			return user2;
		} else {
			throw new RuntimeException("Invalid email or password");
		}
		
	}
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		User user2 = userRepository.findByEmailAndPassword(email, null);
		if (user2 != null) {
			return user2;
		}
		else 
		{
			throw new RuntimeException("User not found with email: " + email);
		}
	}
	public User findById(int id) {
		
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}
	public User deleteById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

}
