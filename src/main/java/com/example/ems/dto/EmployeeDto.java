package com.example.ems.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeDto {

	private long id;
	
	@NotBlank(message = "Firstname is required")
	private String firstName;
	
	@NotBlank(message = "Lastname is required")
	private String lastName;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
	private String phoneNumber;
	
	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth;
	
	@NotNull(message = "Date of joining is required")
	private LocalDate dateOfJoining;
	
	@NotNull(message = "salary is required")
	@Positive
	private double salary;
	
	private long departmentId;
	
	private boolean isActive=true;
}
