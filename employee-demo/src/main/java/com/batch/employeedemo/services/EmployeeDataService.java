package com.batch.employeedemo.services;

import java.util.List;

import com.batch.employeedemo.domain.Employee;

public interface EmployeeDataService {

	public List<Employee> findAll();
	
	public Employee findById(String firstName);
	
	public void save(Employee aEmployee);
	
	public void saveAll(List<Employee> employees);
	
	public void deleteById(String firstName);
}
