package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage1;

public class IndexPageTest extends BaseClass
{
	IndexPage1 indexPage;
	
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
	
	@Test(groups="Smoke")
	public void verifyLogo()
	{
		indexPage= new IndexPage1();  //create method to access in pagetest level
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);  //validate logo
	}
	
	@Test(groups="Smoke")
	public void verifyTitle()
	{
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	

}
