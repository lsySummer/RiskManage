package edu.nju;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class Log {

	private static Logger logger = Logger.getRootLogger();

	public static void log(Exception ex) {
		StringWriter stackTrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(stackTrace));
		logger.error("Exception: " + stackTrace.toString());
	}

	public static void log(String message) {
		logger.debug(message);
	}
}
