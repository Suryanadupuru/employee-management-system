package com.example.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;
import com.example.ems.exception.DepartmentAlreadyExistsException;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private final DepartmentRepository departmentRepository;
	private final ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		if (departmentRepository.existsByName(departmentDto.getName())) {
			throw new DepartmentAlreadyExistsException("Department with name"+departmentDto.getName()+" already exists");
		}
		Department department=modelMapper.map(departmentDto, Department.class);
		Department savedDepartment=departmentRepository.save(department);
		return modelMapper.map(savedDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentById(long id) {
		Department department=departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
		
		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> departments=departmentRepository.findAll();
		
		return departments.stream().map(dept ->modelMapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public DepartmentDto updateDepartment(long id, DepartmentDto departmentDto) {
		Department department=departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department not found"));
		modelMapper.map(departmentDto, department);
		department.setId(id);
		Department updatedDepartment=departmentRepository.save(department);
		
		return modelMapper.map(updatedDepartment, DepartmentDto.class);
	}

	@Override
	public void deleteDepartment(long id) {
		
		if(!departmentRepository.existsById(id)) {
			throw new RuntimeException("Department not found");
		}
		departmentRepository.deleteById(id);
	}

	@Override
	public List<DepartmentDto> getAllDepartmentsWithEmployees() {
		List<Department> departments=departmentRepository.findAllWithEmployees();
		return departments.stream().map(dept ->modelMapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
	}

}
