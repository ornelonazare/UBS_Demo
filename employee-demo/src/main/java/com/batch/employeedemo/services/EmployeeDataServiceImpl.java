package com.batch.employeedemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.employeedemo.domain.Employee;
import com.batch.employeedemo.domain.EmployeeRepository;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(String firstName) {
		Optional<Employee> emp = employeeRepository.findById(firstName);
		Employee aEmp = null;
		if (emp.isPresent()) {
			aEmp = emp.get();
		} else {
			throw new RuntimeException("Employee name not found : " + firstName);
		}
		return aEmp;
	}

	@Override
	public void save(Employee aEmployee) {
		employeeRepository.save(aEmployee);
	}

	@Override
	public void saveAll(List<Employee> employees) {
		employeeRepository.saveAll(employees);

	}

	@Override
	public void deleteById(String firstName) {
		employeeRepository.deleteById(firstName);
	}

}
