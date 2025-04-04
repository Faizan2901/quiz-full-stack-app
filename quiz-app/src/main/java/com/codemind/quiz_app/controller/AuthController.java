package com.codemind.quiz_app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.quiz_app.bean.User;
import com.codemind.quiz_app.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
	    try {
	        String result = authService.registerUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body(result);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}

	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        return ResponseEntity.ok(authService.loginUser(request.get("username"), request.get("password")));
    }

}
