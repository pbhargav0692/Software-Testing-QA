package Log4jAppenders;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SampleEntryAWithAppenders {

	// All the loggers that cam be used
	static Logger mainlogger = LogManager.getLogger(SampleEntryAWithAppenders.class.getName());

	public static void main(String[] args) {

		BasicConfigurator.configure();

		// Create a console appender and attach it to our mainlogger

		ConsoleAppender appender = new ConsoleAppender();
		mainlogger.addAppender(appender);
		mainlogger.info("This is just a logger");
	}
}
