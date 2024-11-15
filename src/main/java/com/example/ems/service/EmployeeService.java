package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(long id);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(long id, EmployeeDto employeeDto);
	void deleteEmployee(long id);
	List<EmployeeDto> serachEmployees(String keyword);

}
