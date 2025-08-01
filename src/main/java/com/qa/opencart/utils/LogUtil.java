package com.qa.opencart.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.opencart.factory.DriverFactory;

public class LogUtil {
	public static Logger log=LogManager.getLogger(DriverFactory.class);//use from apache log4j
	public static void info(String mesg) {
		log.info(mesg);
	}
	public static void warn(String mesg) {
		log.warn(mesg);
	}
	public static void error(String mesg) {
		log.error(mesg);
	}
	public static void fatal(String mesg) {
		log.fatal(mesg);
	}
	

}
