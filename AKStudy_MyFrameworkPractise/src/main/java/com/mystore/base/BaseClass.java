package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.mystore.utility.WaitStatements;

public class BaseClass 
{
	//public static WebDriver driver;  we can keep driver reference for normal run
	public static Properties prop;
	
	//declare threadLocal driver: to run Tests in parallel withoiut issue we have to use this
	public static ThreadLocal<RemoteWebDriver>driver= new ThreadLocal<>();
	
	//get driver from localThread
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() throws IOException
	{
		DOMConfigurator.configure("log4j.xml");		//write method for Log4J
		
		prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		prop.load(fis);
		
	}
	
	public static void launchApp(String browserName)
	{
		//String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Java Selenium\\chromedriver.exe\\");
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());  //set driver to threadLocal
			getDriver().manage().window().maximize();
		}	
		
		getDriver().manage().timeouts().implicitlyWait(WaitStatements.IMPLICIT_WAIT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(WaitStatements.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
		getDriver().get(prop.getProperty("url"));
	}

	
	//take Screenshot method
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"//Screenshots//"+testCaseName+".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"//Screenshots//"+testCaseName+".png";
	}
	

}
