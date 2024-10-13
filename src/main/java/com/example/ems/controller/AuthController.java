package com.example.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.dto.UserDto.LoginRequest;
import com.example.ems.dto.UserDto.SignupRequest;
import com.example.ems.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final UserService userService;
	
	public AuthController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		userService.registerUser(signupRequest);
		return ResponseEntity.ok("User registred successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest){
		return ResponseEntity.ok(userService.authencateUser(loginRequest));
	}
	

}
