package com.mavenLog4j.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogLevelParentChild {
	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger loggerParent = LogManager.getLogger("Parent");
		Logger loggerChild = LogManager.getLogger("Parent.Child");

		loggerParent.setLevel(Level.WARN);

		loggerParent.trace("This is trace log - Parent");
		loggerParent.debug("This is debug log - Parent");
		loggerParent.info("This is trace log - Parent");
		loggerParent.warn("This is trace log - Parent");
		loggerParent.error("This is trace log - Parent");
		loggerParent.fatal("This is trace log - Parent");

		loggerChild.trace("This is trace log - Child");
		loggerChild.debug("This is debug log - Child");
		loggerChild.info("This is trace log - Child");
		loggerChild.warn("This is trace log - Child");
		loggerChild.error("This is trace log - Child");
		loggerChild.fatal("This is trace log - Child");

	}
}
