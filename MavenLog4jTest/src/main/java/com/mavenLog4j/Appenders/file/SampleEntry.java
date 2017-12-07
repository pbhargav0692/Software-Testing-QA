package com.mavenLog4j.Appenders.file;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SampleEntry {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");

		FileAppender appender = new FileAppender();
		appender.setFile("logfile.txt");
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
