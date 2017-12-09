package com.service.customer.core;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.service.customer.entity.Customer;

public class XMLParserUtil {
	public Customer convertXmltoObject(String XMLmessage) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Unmarshaller jaxbunMarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbunMarshaller.unmarshal(new StringReader(XMLmessage));
		return customer;
	}

	public String convertObjecttoXml(Customer customer) throws JAXBException {
		// Marshalling
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		StringWriter file = new StringWriter();
		jaxbMarshaller.marshal(customer, file);
		return file.toString();
	}

}
