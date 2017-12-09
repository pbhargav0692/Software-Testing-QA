package com.service.customer.test;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.service.customer.entity.Customer;

public class CustomerServiceClientUnmarshal {

	public static void main(String[] args) throws JAXBException {

		String XML = "<CUSTOMER><CITY>Fremont</CITY><FIRSTNAME>John</FIRSTNAME><ID>1</ID><LASTNAME>xyz</LASTNAME><STREET>main st</STREET></CUSTOMER>";
		unmarshalling(XML);

		/*
		 * try { JAXBContext jaxbContext =
		 * JAXBContext.newInstance(Customer.class); Unmarshaller
		 * jaxbUnmarshaller = jaxbContext.createUnmarshaller(); String XML =
		 * "<CUSTOMER><CITY>Fremont</CITY><FIRSTNAME>John</FIRSTNAME><ID>1</ID><LASTNAME>xyz</LASTNAME><STREET>main st</STREET></CUSTOMER>"
		 * ;
		 * 
		 * StreamSource streamsource = new StreamSource(new StringReader(XML));
		 * JAXBElement<Customer> je = jaxbUnmarshaller.unmarshal(streamsource,
		 * Customer.class);
		 * 
		 * Customer customer = (Customer) je.getValue();
		 * System.out.println("First name : " + customer.getFirstname());
		 * System.out.println("Last name : " + customer.getLastname());
		 * System.out.println("Street name : " + customer.getStreet());
		 * System.out.println("ID : " + customer.getId());
		 * System.out.println("City : " + customer.getCity()); } catch
		 * (JAXBException e) { e.printStackTrace(); }
		 */

	}
	
	private static void unmarshalling(String XML) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new StringReader(XML));
		//StringWriter file = new StringWriter();
		//jaxbUnmarshaller.unmarshal(customer, file);
		//System.out.println(file.toString());
		System.out.println("Unmarshalled Customer Details \n" + customer.getId() + "\n" + customer.getFirstname() + "\n"
				+ customer.getLastname() + "\n" + customer.getStreet() + "\n" + customer.getCity());
	}
}
