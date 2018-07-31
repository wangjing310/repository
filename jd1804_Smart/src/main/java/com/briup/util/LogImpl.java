package com.briup.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;

import com.briup.inject.ConfigurationImpl;
import com.briup.inject.WossModual;
import com.sun.org.apache.xml.internal.security.Init;

public class LogImpl implements Log,WossModual{
	
	private static Logger logger;
	
	static {		
		logger=logger.getRootLogger();
		PropertyConfigurator.configure("/jd1804_Smart/src/main/resources/log4j.properties");
	}
	

	public void debug(String message) {
		logger.debug(message);
		// TODO Auto-generated method stub
		
	}

	public void info(String message) {
		logger.info(message);
		// TODO Auto-generated method stub
		
	}

	public void warn(String message) {
		logger.warn(message);
		// TODO Auto-generated method stub
		
	}

	public void error(String message) {
		
		logger.error(message);
		// TODO Auto-generated method stub
		
	}

	public void fatal(String message) {
		logger.fatal(message);
		// TODO Auto-generated method stub
		
	}

	public void init(Properties p) {
		// TODO Auto-generated method stub	
	}
}
