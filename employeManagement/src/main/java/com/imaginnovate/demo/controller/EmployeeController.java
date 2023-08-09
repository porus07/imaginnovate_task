package com.imaginnovate.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.demo.payload.EmployeeDto;
import com.imaginnovate.demo.payload.EmployeeTaxIInfoDto;
import com.imaginnovate.demo.service.EmployeeDetailsService;


import jakarta.validation.Valid;






@RestController
@RequestMapping("demo/api")
public class EmployeeController {
	
	
	Logger logger =LoggerFactory.getLogger(EmployeeController.class);
	
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	
//	http://localhost:8080/demo/api/employee
	@PostMapping("/employee")
	public ResponseEntity<?> addemploye(@Valid @RequestBody EmployeeDto employeedto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);

		} else {

			EmployeeDto st = employeeDetailsService.createEmployee(employeedto);
	        logger.debug("A DEBUG Message");
			return new ResponseEntity<EmployeeDto>(st, HttpStatus.CREATED);
		}
	}
	
	
//	http://localhost:8080/demo/api/employees/{id}
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeTaxIInfoDto> taxDeductionCurrentYear(@PathVariable("id")Long id){
		return new ResponseEntity<EmployeeTaxIInfoDto>(employeeDetailsService.taxdeductionForCurrentYear(id),HttpStatus.OK);
		
	}
	

}
