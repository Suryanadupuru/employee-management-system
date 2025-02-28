package com.example.ems.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.entity.Employee;
import com.example.ems.exception.EmployeeAlreadyExistsException;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
			throw new EmployeeAlreadyExistsException("Employee with email id "+employeeDto.getEmail()+" already exists");
		}
		Employee employee=modelMapper.map(employeeDto, Employee.class);
		Employee savedEmployee=employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee=employeeRepository.findById(id).orElseThrow(() ->new RuntimeException("Employee not found"));
		
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method
		List<Employee> employees=employeeRepository.findAll();
		
		return employees.stream().map(emp -> modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {
		Employee employee=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		modelMapper.map(employeeDto, employee);
		employee.setId(id);
		Employee updatedEmployee=employeeRepository.save(employee);
		
		return modelMapper.map(updatedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(long id) {
		if(!employeeRepository.existsById(id)) {
			throw new RuntimeException("Employee not found");
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> serachEmployees(String keyword) {
		List<Employee> employees=employeeRepository.searchEmployees(keyword);
		return employees.stream().map(emp -> modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
		
	}

}
