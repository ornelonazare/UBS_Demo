package com.batch.employeedemo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.batch.employeedemo.domain.Employee;
import com.batch.employeedemo.domain.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDataServiceTest {
	
	@InjectMocks
	private EmployeeDataService employeeDataService = new EmployeeDataServiceImpl();
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Test
	public void findAll_Test() {
		when(employeeRepository.findAll()).thenReturn(Arrays.asList(new Employee("Frank","Dole","Compiuter Data","Zurich Switzerland","Zurich","Holiday ibn","8080","123456","123456789","frank@frank.com","www.frank.com"),
				new Employee("Mike","lopes","Compiuter Data","Zurich Switzerland","Zurich","Holiday ibn","8080","123456","123456789","mike@ornelo.com","www.mike.com")));
		List<Employee> empls = employeeDataService.findAll();
		
		assertEquals("Frank", empls.get(0).getFirstName());
		assertEquals("Mike", empls.get(1).getFirstName());
	}
}
