package com.imaginnovate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
