package com.batch.employeedemo.crud.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;
import com.batch.employeedemo.domain.Employee;
import com.batch.employeedemo.services.EmployeeDataService;
import com.batch.employeedemo.services.LoadCSVData;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeDataService employeeDataService;

	@MockBean
	private LoadCSVData loadCSVData;

	@Test
	public void EmployeeContollerFetch_Test() throws Exception {

		String expected = "{\"firstName\":\"Frank\",\"lastName\":\"Dole\",\"companyName\":\"Compiuter Data\",\"address\":\"Switzerland\",\"city\":\"Zurich\",\"county\":\"Holiday ibn\",\"postal\":\"8080\",\"phone1\":\"123456\",\"phone2\":\"123456789\",\"email\":\"frank@frank.com\",\"web\":\"www.frank.com\"}";
		when(employeeDataService.findById("Frank"))
				.thenReturn(new Employee("Frank", "Dole", "Compiuter Data", "Switzerland", "Zurich", "Holiday ibn",
						"8080", "123456", "123456789", "frank@frank.com", "www.frank.com"));

		RequestBuilder request = MockMvcRequestBuilders.get("/api/employees/Frank").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(expected))
				.andReturn();

	}

}
