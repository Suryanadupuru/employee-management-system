package com.example.ems.service;

import java.util.List;

import com.example.ems.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentById(long id);
	List<DepartmentDto> getAllDepartments();
	DepartmentDto updateDepartment(long id, DepartmentDto departmentDto);
	void deleteDepartment(long id);
	List<DepartmentDto> getAllDepartmentsWithEmployees();
	

}
