package Log4jAppendersLayOuts;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class SampleEntry {

	static Logger mainlogger = LogManager.getLogger(SampleEntry.class.getName());

	public static void main(String[] args) {

		BasicConfigurator.configure();

		// creating a new console
		ConsoleAppender appender = new ConsoleAppender();
		appender.activateOptions();

		// Making a Layout
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("%-5p [%t]: %m%n");
		layout.activateOptions();
		appender.setLayout(layout);

		// simple explanation
		mainlogger.addAppender(appender);
		mainlogger.info("This is just a logger");

		// displaying the brief explanation
		layout.setConversionPattern("%C %m%n");
		mainlogger.info("This is just a logger");

	}

}
