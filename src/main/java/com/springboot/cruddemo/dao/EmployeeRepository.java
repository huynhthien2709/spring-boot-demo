package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "members") cấu hình dùng "members" thay cho "employees" trên đường dẫn
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
