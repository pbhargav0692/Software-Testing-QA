package com.mavenLog4j.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingRuntimeException {
	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger logger1 = LogManager.getLogger("Logger1");
		try {
			int x = 200 / 0;
		} catch (Exception e) {
			logger1.warn("Following exception was raised" + e);
		}
	}
}
