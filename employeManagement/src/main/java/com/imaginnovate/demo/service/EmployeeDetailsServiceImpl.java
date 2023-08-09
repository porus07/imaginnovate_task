package com.imaginnovate.demo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.demo.exceptions.ResourceNotFoundExceptiont;
import com.imaginnovate.demo.model.Employee;
import com.imaginnovate.demo.model.EmployeeTaxInfo;
import com.imaginnovate.demo.payload.EmployeeDto;
import com.imaginnovate.demo.payload.EmployeeTaxIInfoDto;
import com.imaginnovate.demo.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	Logger logger = LoggerFactory.getLogger(EmployeeDetailsServiceImpl.class);

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(@Valid EmployeeDto employeedto) {
		logger.debug("Enter createEmployee");
		Employee employee = modelMapper.map(employeedto, Employee.class);
		EmployeeDto empDto = null;
		Employee emp = null;
		try {
			emp = employeeRepository.save(employee);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new ResourceNotFoundExceptiont("employee allready existed");
		}
		empDto = modelMapper.map(emp, EmployeeDto.class);
		return empDto;

	}

	@Override
	public EmployeeTaxIInfoDto taxdeductionForCurrentYear(Long id) {

		Double tax = 0.0;
		Double cess = 0.0;
		EmployeeTaxInfo employeetaxInfo = new EmployeeTaxInfo();
		System.out.println("check");
		Employee employeebyid = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptiont("EmployeeNotFoundException"));

		EmployeeDto employeeDto = modelMapper.map(employeebyid, EmployeeDto.class);
		LocalDate employeestartingdate = employeeDto.getDoj();
		LocalDate employeeendingdate = LocalDate.now();
		long totalemployeemonthsworking = ChronoUnit.MONTHS.between(employeestartingdate, employeeendingdate);
		Double totalsalaryofemployee = employeeDto.getSalary() * totalemployeemonthsworking;

		if (totalsalaryofemployee > 250000 && totalsalaryofemployee <= 500000) {

			tax = (totalsalaryofemployee - 250000) * 0.05;

		} else if (totalsalaryofemployee > 500000 && totalsalaryofemployee <= 1000000) {
			tax = 12500 + (totalsalaryofemployee - 500000) * 0.1;
		} else if (totalsalaryofemployee > 1000000) {

			tax = 112500 + (totalsalaryofemployee - 1000000) * 0.2;
		}

		if (totalsalaryofemployee > 2500000) {
			cess = (totalsalaryofemployee - 2500000) * 0.02;
		}
		double employeetotaltax = tax + cess;
		employeetaxInfo.setEmployeeID(employeeDto.getEmpId());
		employeetaxInfo.setFirstName(employeeDto.getFirstname());
		employeetaxInfo.setLastName(employeeDto.getLastname());
		employeetaxInfo.setEmail(employeeDto.getEmail());
		employeetaxInfo.setPhoneNumber(employeeDto.getPhoneNumber());
		employeetaxInfo.setDOJ(employeeDto.getDoj());
		employeetaxInfo.setSalary(employeeDto.getSalary());
		employeetaxInfo.setTotalTexAmount(tax);
		employeetaxInfo.setTotalCessAmount(cess);
		
		EmployeeTaxIInfoDto employeeTaxIInfoDto = modelMapper.map(employeetaxInfo, EmployeeTaxIInfoDto.class);

		return employeeTaxIInfoDto;
	}

}
