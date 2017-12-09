package com.service.customer.test;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.service.customer.entity.Customer;

public class CustomerServiceClientMarshal {
	public static void main(String[] args) throws JAXBException {
		// Marshalling
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Customer customer = new Customer(1, "John", "xyz", "main st", "Fremont");
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringWriter file = new StringWriter();
		jaxbMarshaller.marshal(customer, file);
		System.out.println(file.toString());
	}
}
