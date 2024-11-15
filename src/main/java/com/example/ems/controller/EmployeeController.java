package com.example.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.service.EmployeeService;

import jakarta.websocket.server.PathParam;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.createEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id){
		
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
		return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<EmployeeDto>> searchEmployees(@PathVariable String keyword){
		return ResponseEntity.ok(employeeService.serachEmployees(keyword));
	}
}
