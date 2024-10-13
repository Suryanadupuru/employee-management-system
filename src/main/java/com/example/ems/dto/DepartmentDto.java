package com.example.ems.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDto {
	
	private long id;
	
	@NotBlank(message = "Department name is required")
	private String name;
	
	private String description;
	
	private List<EmployeeDto> employees;

}
