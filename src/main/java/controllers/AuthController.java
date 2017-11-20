package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import models.User;

@RestController
public class AuthController {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/login")
	public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
		// Hash password
		String hashedPassword = passwordEncoder.encode(password);
		
		// Get username
		validateUserExists(username);
		User user = userRepository.findByUsername(username).get();
		
		// Check if user exists
		if(passwordEncoder.matches(password, user.getPassword())) {
			return user;
		} else {
			throw new UserNotFoundException(username);
		}
	}
	
	@PostMapping("/register")
	public User register(@RequestParam("username") String username, @RequestParam("password") String password) {
		// Check if username already exists
		if(userExists(username)) {
			throw new UserAlreadyExistsException(username);
		}
		
		// Encode password
		String hashedPassword = passwordEncoder.encode(password);
		
		// Create new user
		User user = new User();
		user.setUsername(username);
		user.setPassword(hashedPassword);
		
		return userRepository.save(user);
	}
	
	/**
	 * Used to check if username exists in database without
	 * throwing an exception
	 * 
	 * @param username String representation of username
	 * @return True if username already exists in db
	 */
	private boolean userExists(String username) {
		return userRepository.findByUsername(username)
			.isPresent();
	}
	
	/**
	 * Throws exception if username already exists
	 * 
	 * @param username Username to check
	 */
	private void validateUserExists(String username) {
		if(!userExists(username)) {
			throw new UserNotFoundException(username);
		}
	}
}
