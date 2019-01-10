package com.batch.employeedemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private String firstName;
	private String lastName;
	private String companyName;
	private String address;
	private String city;
	private String county;
	private String postal;
	private String phone1;
	private String phone2;
	private String email;
	private String web;

	private Employee() {
	}

	public Employee(String firstName, String lastName, String companyName, String address, String city, String county,
			String postal, String phone1, String phone2, String email, String web) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.address = address;
		this.city = city;
		this.county = county;
		this.postal = postal;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.web = web;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCounty() {
		return county;
	}

	public String getPostal() {
		return postal;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getEmail() {
		return email;
	}

	public String getWeb() {
		return web;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", companyName=" + companyName
				+ ", address=" + address + ", city=" + city + ", county=" + county + ", postal=" + postal + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", email=" + email + ", web=" + web + "]";
	}

}
