package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	//Lab 19.1: Tạo JPA DAO implementation cho REST API
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){

		return employeeService.findAll();
	}
	//Lab 19.2: Tạo Spring Data JPA Repository
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee employee = employeeService.findById(employeeId);

		if(employee == null){
			throw new RuntimeException("Empoyee id not found - " + employeeId);
		}

		return  employee;
	}
	

}
