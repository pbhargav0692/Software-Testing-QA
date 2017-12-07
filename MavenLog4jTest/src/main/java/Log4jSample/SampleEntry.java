package Log4jSample;

import org.apache.log4j.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

public class SampleEntry {

	static Logger MainLogger = LogManager.getLogger(SampleEntry.class.getName());

	public static void main(String[] args) {

		BasicConfigurator.configure();
		MainLogger.info("This is just a Logger");

	}
}
