package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage1;
import com.mystore.pageobjects.SearchResultPage4;



public class AddtoCartPageTest extends BaseClass
{
	IndexPage1 indexPage;
	SearchResultPage4 searchResultPage;
	AddToCartPage addToCartPage;

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
	
	@Test(groups= {"Regression","Sanity"})
	public void addToCartTest() throws InterruptedException
	{
		indexPage= new IndexPage1();
		searchResultPage=indexPage.searchProduct("T-Shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selecteDD("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateOnAddToCart();
		Assert.assertTrue(result);
		
	}

}
