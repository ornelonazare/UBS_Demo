package com.batch.employeedemo;

import java.io.FileInputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.batch.employeedemo.domain.Employee;
import com.batch.employeedemo.services.EmployeeDataService;
import com.batch.employeedemo.services.LoadCSVData;

@SpringBootApplication
@EnableScheduling
public class EmployeeDemoApplication {

	@Value("${employee_file_location}")
	private String dataFile;

	@Autowired
	private LoadCSVData loadCSVData;

	@Autowired
	private EmployeeDataService employeeDataService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDemoApplication.class, args);
	}

	@PostConstruct
	void LoadEmployeeFirstTime() throws Exception {
		FileInputStream data = new FileInputStream(dataFile);
		List<Employee> employee = loadCSVData.readCSVFile(Employee.class, data);
		employeeDataService.saveAll(employee);
	}

}
