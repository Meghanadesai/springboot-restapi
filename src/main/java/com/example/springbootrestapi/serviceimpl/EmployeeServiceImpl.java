package com.example.springbootrestapi.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootrestapi.entity.Employee;
import com.example.springbootrestapi.exception.ResourceNotFoundException;
import com.example.springbootrestapi.repository.EmployeeRepository;
import com.example.springbootrestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp, Long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmail(emp.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}

}
