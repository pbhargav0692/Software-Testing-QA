package com.Service.Customer.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CUSTOMER")
public class Customer {
	private int id;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	public Customer() {
		super();
	}
	public Customer(int id, String firstname, String lastname, String street, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
	}
	@XmlElement(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement(name = "FIRSTNAME")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@XmlElement(name = "LASTNAME")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@XmlElement(name = "STREET")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@XmlElement(name = "CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
