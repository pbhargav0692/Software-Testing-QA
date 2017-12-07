package com.mavenLog4j.Logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SampleEntry {
	public static void main(String[] args) {

		// Logger chance = LogManager.getLogger(SampleEntry.class.getName());
		Logger logger1 = LogManager.getLogger("Child1");
		Logger loggerchild = logger1.getLogger("Child1.childoflogger1");
		Logger loggergrandChild = LogManager.getLogger("Child1.childoflogger1.grandchild");

		System.out.println("logger1's full name is " + logger1.getParent().getName());
		System.out.println("logger1's child's full name is " + loggerchild.getParent().getName());
		System.out.println("logger1's grand children's full name is " + loggergrandChild.getParent().getName());

	}
}
