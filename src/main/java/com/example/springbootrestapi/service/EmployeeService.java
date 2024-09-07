package com.example.springbootrestapi.service;

import java.util.List;

import com.example.springbootrestapi.entity.Employee;

public interface EmployeeService {
	
	Employee getEmployeeById(Long id);
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee emp);
	Employee updateEmployee(Employee emp, Long id);
	void deleteEmployee(Long id);
	
}
