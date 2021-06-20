package com.MiniBank.Utilities;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerClass {
	
	static Logger log = Logger.getLogger(LoggerClass.class.getName()); 
	@Test
	public void logger() {
		log.debug("Hello this is a debug message");
	}
}
