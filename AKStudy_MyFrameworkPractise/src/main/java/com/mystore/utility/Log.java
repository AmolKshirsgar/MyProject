package com.mystore.utility;

import org.apache.log4j.Logger;

public class Log
{
	//initilize Log4j Log
	public static Logger log=Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName)
	{
		Log.info("========="+ sTestCaseName + "Test Started==============");
	}
	
	
	public static void endTestCase(String sTestCaseName)
	{
		Log.info("========="+ sTestCaseName + "Test Ended============");
	}
	
	public static void info(String message)
	{
		Log.info(message);
	}

	public static void error (String message)
	{
		Log.info(message);
	}

	public static void fatal (String message)
	{
		Log.info(message);
	}

	public static void debug (String message)
	{
		Log.info(message);
	}

}
