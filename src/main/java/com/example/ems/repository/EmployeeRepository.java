package com.example.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByDepartmentID(Long departmentId);
	
	List<Employee> findByIsActivateTrue();
	
	
	@Query("SELECT e FROM Employee e WHERE "+
	"LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR" +
	"LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR" +
	"LOWER(e.email) LIKE LOWER(CONCAT ('%' ,:keyword, '%'))")
	List <Employee> searchEmployees(@Param("keyword") String keyword);
	
	boolean existsByEmail(String email);
}
