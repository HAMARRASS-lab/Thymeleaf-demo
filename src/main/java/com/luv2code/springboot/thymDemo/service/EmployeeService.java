package com.luv2code.springboot.thymDemo.service;

import java.util.List;

import com.luv2code.springboot.thymDemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
