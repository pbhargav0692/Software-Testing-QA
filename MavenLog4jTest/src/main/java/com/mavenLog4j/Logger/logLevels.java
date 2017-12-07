package com.mavenLog4j.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class logLevels {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger MyLogger = LogManager.getLogger("DebugLogger");

		// Setting up the log level of both loggers
		MyLogger.setLevel(Level.DEBUG);

		MyLogger.trace("This is the trace log - DEBUG"); // trace logs in order to find an error in a code 
		MyLogger.debug("This is the debug log - DEBUG"); // logging of that info that helps programmer to debug application in case of failure 
		MyLogger.info("This is the info log - DEBUG"); // just see the logs of what is happening 
		MyLogger.warn("This is the warn log - DEBUG"); // log to see the warning 
		MyLogger.error("This is the error log - DEBUG"); // log all the errors 
		MyLogger.fatal("This is the fatal log - DEBUG"); // 

		MyLogger.setLevel(Level.WARN);

		MyLogger.trace("This is the trace log - WARN");
		MyLogger.debug("This is the debug log - WARN");
		MyLogger.info("This is the info log - WARN");
		MyLogger.warn("This is the warn log - WARN");
		MyLogger.error("This is the error log - WARN");
		MyLogger.fatal("This is the fatal log - WARN");

	}
}
