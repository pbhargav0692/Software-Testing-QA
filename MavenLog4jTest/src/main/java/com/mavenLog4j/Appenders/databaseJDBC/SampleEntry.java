package com.mavenLog4j.Appenders.databaseJDBC;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.jdbc.JDBCAppender;

public class SampleEntry {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");

		// made JDBCAppender class instance 
		// make JDBC connection 
		JDBCAppender DatabaseAppender = new JDBCAppender();
		DatabaseAppender.setURL("jdbc:mysql://localhost/test");
		DatabaseAppender.setUser("User1");
		DatabaseAppender.setPassword("pwd1");
		DatabaseAppender.setDriver("com.mysql.jdbc.Driver");
		
		//set the sql insert statement that you want to use
		DatabaseAppender.setSql("INSERT INTO LOGS VALUES ('%x', now() ,'%C','%p','%m'");
		
		OurLogger.addAppender(DatabaseAppender);
		DatabaseAppender.activateOptions();

		int x = 0;
		while (x < 11) {
			OurLogger.debug("This is just a log that i want to print" + x);
			x++;
		}
	}
}
