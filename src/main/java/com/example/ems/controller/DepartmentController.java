package com.example.ems.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		return new ResponseEntity<>(departmentService.createDepartment(departmentDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long id){
		
		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		return ResponseEntity.ok(departmentService.getAllDepartments());
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable long id, @RequestBody DepartmentDto departmentDto){
		return ResponseEntity.ok(departmentService.updateDepartment(id, departmentDto));
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable long id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/with-employees")
	public ResponseEntity<List<DepartmentDto>> getAllDepartmentsWithEmployees(){
		List<DepartmentDto> departments=departmentService.getAllDepartmentsWithEmployees();
		return ResponseEntity.ok(departments);
	}
}
