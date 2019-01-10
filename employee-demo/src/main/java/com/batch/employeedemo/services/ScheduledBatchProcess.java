package com.batch.employeedemo.services;

import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.batch.employeedemo.domain.Employee;

@Component
public class ScheduledBatchProcess {

	@Value("${employee_file_location}")
	private String dataFile;

	@Autowired
	private LoadCSVData loadCSVData;

	@Autowired
	private EmployeeDataService employeeDataService;

	@Scheduled(cron = "0 15 13 * * *")
	public void batchFileupdate() throws Exception {
		System.out.println("The time is now ");
		FileInputStream data = new FileInputStream(dataFile);
		List<Employee> employee = loadCSVData.readCSVFile(Employee.class, data);
		employee.stream().forEach(emp -> employeeDataService.save(emp));
	}
}
