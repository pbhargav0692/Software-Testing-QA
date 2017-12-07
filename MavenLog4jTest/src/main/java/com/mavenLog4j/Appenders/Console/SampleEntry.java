package com.mavenLog4j.Appenders.Console;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SampleEntry {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");

		ConsoleAppender appender = new ConsoleAppender();
		appender.setLayout(new SimpleLayout());

		OurLogger.addAppender(appender);
		appender.activateOptions();

		int x = 0;
		while (x < 11) {
			OurLogger.debug("This is just a log that i want to print" + x);
			x++;
		}
	}
}
