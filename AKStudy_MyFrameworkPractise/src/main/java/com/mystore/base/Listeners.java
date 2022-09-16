package com.mystore.base;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener
{
	ExtentTest test;  //make extenttest test as global to use on differnt method of listners
	ExtentReports extent=com.mystore.utility.ExtentReporterNG.getReportObject();  //use statuc method from extent report
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result)  //this methos will run before test start
	{
		test=extent.createTest(result.getMethod().getMethodName());  //this line used before start of every test, and getMethodName will give method name of tht block
		extentTest.set(test); //it will avoid confusion while creating reports if Test run in parallel mode to override tsetreport result
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Passed..");
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().fail(result.getThrowable()); //it will give error log msg of failure in reports
		//once test fail then attach screenshot in report
		try 
		{
			driver=(ThreadLocal<RemoteWebDriver>) result.getTestClass().getRealClass().getField("getDriver()").get(result.getInstance());
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		} 
			String filePath = null;
		try 
		{
			filePath = getScreenshot(result.getMethod().getMethodName(),getDriver());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
			extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext result) 
	{
		extent.flush();
	}
	


}
