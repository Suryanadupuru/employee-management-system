package com.example.ems.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String phonenumber;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(nullable = false)
	private LocalDate dateOfJoining;
	
	private double salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	
	@Column(nullable = false)
	private Boolean isActive;
	

}
