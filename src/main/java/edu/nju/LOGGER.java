package edu.nju;

import org.apache.log4j.Logger;

public class LOGGER {

	private static Logger defaultLogger = Logger.getRootLogger();

	private LOGGER() {
	}

	public static void log(Exception ex) {
		defaultLogger.error("Exception: ", ex);
	}

	public static void log(String message) {
		defaultLogger.debug(message);
	}

	public static void log(Object obj) {
		defaultLogger.debug(obj);
	}
}
