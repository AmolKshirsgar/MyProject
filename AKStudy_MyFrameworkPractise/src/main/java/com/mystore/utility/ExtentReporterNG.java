package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	
	public static ExtentReports getReportObject()  //by making static we dont need to create object we can direct use same class name with method in other class(Listener class)
	{
		String path=System.getProperty("user.dir")+"//extentReports//myReports.html";  //create html file in reports folder of project
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "AmolK");
		extent.setSystemInfo("ProjectName", "MyStoreProject");
		extent.createTest(path);
		
		return extent;  //make it static object to use in Listeners class
	}
	


}
