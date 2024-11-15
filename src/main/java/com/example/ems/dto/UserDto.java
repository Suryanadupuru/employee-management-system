package com.example.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


public class UserDto {
	
	@Data
	public static class LoginRequest{
		
		@NotBlank(message="username is required")
		private String username;
		
		@NotBlank(message = "password is required")
		private String password;
	}
	
	@Data
	public static class SignupRequest{
		
		@NotBlank(message = "Username is required")
		@Size(min = 3 , max = 20)
		private String username;
		
		@NotBlank(message = "Email is required")
		@Email
		private String email;
		
		@NotBlank(message = "Password is required")
		@Size(min=6, max = 20)
		private String password;
	}
	
	@Data
	@AllArgsConstructor
	public static class LoginResponse{
		private String token;
		private String type;
		private String username;
		private String role;
	}

}
