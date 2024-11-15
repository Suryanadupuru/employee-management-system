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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name ="last_name",nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_number",nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name="date_of_birth",nullable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate dateOfBirth;
	
	@Column(name="date_of_joining",nullable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate dateOfJoining;
	
	private double salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Department department;
	
	@Column(name="is_active",nullable = false)
	private boolean isActive;
	

}
