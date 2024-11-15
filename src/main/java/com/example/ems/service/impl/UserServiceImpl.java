package com.example.ems.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ems.dto.UserDto.LoginRequest;
import com.example.ems.dto.UserDto.LoginResponse;
import com.example.ems.dto.UserDto.SignupRequest;
import com.example.ems.entity.Role;
import com.example.ems.entity.User;
import com.example.ems.repository.UserRepository;
import com.example.ems.security.JwtTokenProvider;
import com.example.ems.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthenticationManager authenticationManager;

	@Override
	public LoginResponse authenticateUser(LoginRequest loginRequest) {
		 
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		Authentication authentication= authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt=jwtTokenProvider.generateToken(authentication);
		UserDetails userDetails=(UserDetails) authentication.getPrincipal();
		return new LoginResponse(
				jwt, "Bearer",userDetails.getUsername(),
				userDetails.getAuthorities().iterator().next().getAuthority()
				);
	}

	@Override
	public User registerUser(SignupRequest signUpRequest) {
		if(userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new RuntimeException("Username is already taken!");
		}
		if(userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new RuntimeException("Email is already in Use");
		}
		
		User user=new User();
		user.setUsername(signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setRole(Role.ROLE_USER);
		return userRepository.save(user);
	}

	@Override
	public User getCurrentUser() {
		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername()).orElseThrow(()->new RuntimeException("User not found"));
	}
	
}