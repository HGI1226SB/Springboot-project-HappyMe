package com.Happyme.project.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Happyme.project.entity.User;
import com.Happyme.project.repository.UserRepository;
@Service
public class UserService {
	private UserRepository userrepo;

	public User registeruser(User user) {
		return userrepo.save(user);
	}

	public Optional<User> finduser(Long id) {
		return userrepo.findById(id);
	}

	public Optional<User> finduserbyemail(String email) {
		return userrepo.findByEmail(email);
	}

}
