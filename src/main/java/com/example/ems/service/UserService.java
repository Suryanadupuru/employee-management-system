package com.example.ems.service;

import com.example.ems.dto.UserDto.LoginRequest;
import com.example.ems.dto.UserDto.LoginResponse;
import com.example.ems.dto.UserDto.SignupRequest;
import com.example.ems.entity.User;

public interface UserService {
	
	LoginResponse authencateUser(LoginRequest loginRequest);
	User registerUser(SignupRequest signupRequest);
	User getCurrentUser();
}
