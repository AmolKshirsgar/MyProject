package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderUse;
import com.mystore.pageobjects.HomePage3;
import com.mystore.pageobjects.IndexPage1;
import com.mystore.pageobjects.LoginPage2;
import com.mystore.utility.DataProvider_jsonReader;

public class LoginPageTest extends BaseClass
{
	IndexPage1 indexPage;
	LoginPage2 loginPage;
	HomePage3 homePage;
	
	@Parameters("browser")  //use this to call from xml instead of config file
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		 launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().close();
	}
	
	@Test(dataProvider="CredentialsLogin",dataProviderClass=DataProviderUse.class,groups= {"Smoke","Sanity"}) // ,dataProviderClass=DataProviderUse.class will call data provide from pther class, or create method in Baseclass for same jsonreader and extent base class to avoid this
	public void loginTest(HashMap<String, String>input)
	{
		
	//	Log.startTestCase("loginTest");  //call log4j
		
		indexPage=new IndexPage1();  //use "indexpage" object in "loginpage" as indexpage is having OR of loginpage
	//  Log.info("user is going to click on SIgnIn..");
		loginPage=indexPage.clickOnSignIn(); //indexpage will return LoginPage as new page
		
	//	Log.info("Enter username and password..");
	//	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  by config property
		homePage=loginPage.login(input.get("username"),input.get("password")); //by DataProvider
		String actualURL=homePage.getCurrentURL();
		String exPectedURL="http://automationpractice.com/index.php?controller=my-account";
	//	Log.info("Verify if user is able to login...");
		Assert.assertEquals(actualURL, exPectedURL);
	//	Log.info("Login Successfully...");
		
	//	Log.endTestCase("loginTest");
		
	}


}
