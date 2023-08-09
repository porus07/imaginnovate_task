package com.imaginnovate.demo.service;

import com.imaginnovate.demo.payload.EmployeeDto;
import com.imaginnovate.demo.payload.EmployeeTaxIInfoDto;

import jakarta.validation.Valid;

public interface EmployeeDetailsService {

	EmployeeDto createEmployee(@Valid EmployeeDto employeedto);

	EmployeeTaxIInfoDto taxdeductionForCurrentYear(Long id);

}
