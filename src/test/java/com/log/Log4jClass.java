package com.log;


import org.apache.logging.log4j.*;

public class Log4jClass {
	private static Logger demologger = LogManager.getRootLogger();
	public static Logger log(){
		demologger.info(demologger);
		return demologger;
	}

}
