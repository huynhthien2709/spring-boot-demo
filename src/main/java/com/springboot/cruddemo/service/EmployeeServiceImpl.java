package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	private EmployeeRepository employeeRepository;




	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	
	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}


	//Lab 19.2: Tạo Spring Data JPA Repository
	@Override
	@Transactional
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;

		if(result.isPresent()){
			employee = result.get();
		}else {
			// didn't find the employee
			throw  new RuntimeException("Did not find employee id - " + id);
		}

		return  employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
