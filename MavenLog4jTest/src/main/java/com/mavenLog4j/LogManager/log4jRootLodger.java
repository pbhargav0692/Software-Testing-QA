package com.mavenLog4j.LogManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class log4jRootLodger {

	public static void main(String[] args) {
		Logger logger1 = LogManager.getLogger("Logger1");
		Logger logger2 = LogManager.getLogger("Logger2");
		Logger logger3 = LogManager.getLogger("Logger3");
		BasicConfigurator.configure();
		logger1.info("This is logger 1");
		logger2.info("This is logger 2");
		logger3.info("This is logger 3");
		
		Logger rootLodger = LogManager.getRootLogger();
		Logger rootOf1 = logger1.getRootLogger();
		
		if(rootOf1.equals(rootLodger)){
			rootOf1.info("Both objects are same");
			rootOf1.info("the name of the root logger is "+rootLodger.getName());
		}
		else{
			rootOf1.info("Both are different objects.");
		}
	}
}
