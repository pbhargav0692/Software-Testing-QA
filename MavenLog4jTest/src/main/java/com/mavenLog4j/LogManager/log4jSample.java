package com.mavenLog4j.LogManager;

import java.util.Enumeration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class log4jSample {

	public static void main(String[] args) {
		
		Logger logger1 = LogManager.getLogger("logger1");
		Logger logger2 = LogManager.getLogger("logger2");
		Logger logger3 = LogManager.getLogger("logger3");
		BasicConfigurator.configure();
		logger1.info("This is logger 1");
		logger2.info("This is logger 2");
		logger3.info("This is logger 3");
		
		// retrieve all the logger object inside LogManager at a perticular instance by using getCurrentLoggers() method 
		Enumeration loggers = LogManager.getCurrentLoggers();
		while(loggers.hasMoreElements()){
			logger3.info("Logger name is "+ loggers.nextElement().getClass().getName());
		}
		
	}
}
