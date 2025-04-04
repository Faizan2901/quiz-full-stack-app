package com.codemind.quiz_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codemind.quiz_app.bean.User;
import com.codemind.quiz_app.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtUtility;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public String registerUser(User user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new RuntimeException("User already exists!");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		user.setUsername(user.getUsername());
		userRepository.save(user);
		
		return "User registered successfully!";
	}
	
	public String loginUser(String username,String password) {
		User user=userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found!"));
		
		if(!passwordEncoder.matches(password,user.getPassword())) {
			throw new RuntimeException("Invalid credentials!");
		}
		
		return jwtUtility.generateToken(username);
	}
	
	
}
