package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage3;
import com.mystore.pageobjects.IndexPage1;
import com.mystore.pageobjects.LoginPage2;

public class HomePageTest extends BaseClass 
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
	
	@Test(groups="Smoke")
	public void wishListTest()
	{
		indexPage=new IndexPage1();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void orderHistoryAndDetailsTest()
	{
		indexPage=new IndexPage1();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result1=homePage.validateOrderHistory();
		Assert.assertTrue(result1);
	}

}
