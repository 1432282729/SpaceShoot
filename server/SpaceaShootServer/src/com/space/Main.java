package com.space;

import org.apache.log4j.Logger;

import com.space.util.LogUtil;

public class Main {
	
	
	private static Logger logger  =  Logger.getLogger(Main. class );
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogUtil.loadLogConfig();
        logger.debug("debug");
        logger.error("error");
		
		
	}

}
