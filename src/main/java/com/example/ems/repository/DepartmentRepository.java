package com.example.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	boolean existsByName(String name);
	
	@Query("SELECT d FROM Department d LEFT JOIN FETCH d.employees")
	List<Department> findAllWithEmployees();
}

