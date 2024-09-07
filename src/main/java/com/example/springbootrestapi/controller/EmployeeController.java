package com.example.springbootrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.entity.Employee;
import com.example.springbootrestapi.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(emp),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable long id) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(emp, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
	}
	
	
}
