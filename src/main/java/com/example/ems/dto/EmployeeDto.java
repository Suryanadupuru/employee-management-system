package com.example.ems.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private long id;
	
	@NotBlank(message = "Firstname is required")
	@JsonProperty("firstName")
	private String firstName;
	
	@NotBlank(message = "Lastname is required")
	@JsonProperty("lastName")
	private String lastName;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@JsonProperty("email")
	private String email;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	
	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("dateOfBirth")
	private LocalDate dateOfBirth;
	
	@NotNull(message = "Date of joining is required")
	@JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("dateOfJoining")
	private LocalDate dateOfJoining;
	
	@NotNull(message = "salary is required")
	@Positive(message = "Salary must be positive")
    @JsonProperty("salary")
	private double salary;
	
	@NotNull(message = "Department ID is required")
	@JsonProperty("departmentId")
	private long departmentId;
	
	@JsonProperty("isActive")
	private boolean isActive=true;
}
