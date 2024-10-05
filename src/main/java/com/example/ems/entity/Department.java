package com.example.ems.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	
	private String description;
	
	@OneToMany(mappedBy ="department",cascade = CascadeType.ALL)
	private List<Employee> employees=new ArrayList<>();
}
