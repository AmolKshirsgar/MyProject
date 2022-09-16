package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage1;
import com.mystore.pageobjects.SearchResultPage4;

import junit.framework.Assert;

public class SearchResultPageTest extends BaseClass 
{
	IndexPage1 indexPage;
	SearchResultPage4 searchResultPage;
	
	
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
	public void productAvailibilityTest()
	{
		indexPage= new IndexPage1();
		searchResultPage=indexPage.searchProduct("T-shirt");
		boolean result=searchResultPage.isProductAvail();
		Assert.assertTrue(result);
	}

}
