package com.batch.employeedemo.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch.employeedemo.domain.Employee;
import com.batch.employeedemo.services.EmployeeDataService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeDataService employeeDataService;
	
	
		@GetMapping("/employees")
		public List<Employee> findAll() {
			return employeeDataService.findAll();
		}

				
		@GetMapping("/employees/{firstName}")
		public Employee getEmployee(@PathVariable String firstName) {
			
			Employee theEmployee = employeeDataService.findById(firstName);
			
			if (theEmployee == null) {
				throw new RuntimeException("Employee not found - " + firstName);
			}
			
			return theEmployee;
		}
		
		
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee theEmployee) {
			
						
			employeeDataService.save(theEmployee);
			
			return theEmployee;
		}
		
		
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			
			employeeDataService.save(theEmployee);
			
			return theEmployee;
		}
		
	
		@DeleteMapping("/employees/{firstName}")
		public String deleteEmployee(@PathVariable String firstName) {
			
			Employee tempEmployee = employeeDataService.findById(firstName);
			
			if (tempEmployee == null) {
				throw new RuntimeException("Employee not found - " + firstName);
			}
			
			employeeDataService.deleteById(firstName);
			
			return "Deleted employee - " + firstName;
		}
}
