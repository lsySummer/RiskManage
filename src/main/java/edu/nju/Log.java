package edu.nju;

import org.apache.log4j.Logger;

public class Log {

	private static Logger logger = Logger.getRootLogger();

	private Log() {
	}

	public static void log(Exception ex) {
		logger.error("Exception: ", ex);
	}

	public static void log(String message) {
		logger.debug(message);
	}
}
