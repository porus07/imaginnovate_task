package com.imaginnovate.demo.payload;

import java.time.LocalDate;

public class EmployeeTaxIInfoDto {

	private Long employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate dOJ;
	private Double salary;
	private Double totalTexAmount;
	private Double totalCessAmount;
	public EmployeeTaxIInfoDto(Long employeeID, String firstName, String lastName, String email, String phoneNumber,
			LocalDate dOJ, Double salary, Double totalTexAmount, Double totalCessAmount) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dOJ = dOJ;
		this.salary = salary;
		this.totalTexAmount = totalTexAmount;
		this.totalCessAmount = totalCessAmount;
	}
	public EmployeeTaxIInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getdOJ() {
		return dOJ;
	}
	public void setdOJ(LocalDate dOJ) {
		this.dOJ = dOJ;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getTotalTexAmount() {
		return totalTexAmount;
	}
	public void setTotalTexAmount(Double totalTexAmount) {
		this.totalTexAmount = totalTexAmount;
	}
	public Double getTotalCessAmount() {
		return totalCessAmount;
	}
	public void setTotalCessAmount(Double totalCessAmount) {
		this.totalCessAmount = totalCessAmount;
	}
	@Override
	public String toString() {
		return "EmployeeTaxIInfoDto [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", dOJ=" + dOJ + ", salary=" + salary
				+ ", totalTexAmount=" + totalTexAmount + ", totalCessAmount=" + totalCessAmount + "]";
	}
	
	
}
