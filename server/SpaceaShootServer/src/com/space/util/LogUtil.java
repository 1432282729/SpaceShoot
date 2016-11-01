package com.space.util;

import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
	
	public static void loadLogConfig(){
		
		String path = System.getProperty("user.dir");
		PropertyConfigurator.configure(path+"/config/log4j.properties");
		
	}
	
	
	
}
