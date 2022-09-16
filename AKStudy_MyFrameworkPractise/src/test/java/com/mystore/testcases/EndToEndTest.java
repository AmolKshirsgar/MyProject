package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderUse;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage6;
import com.mystore.pageobjects.IndexPage1;
import com.mystore.pageobjects.LoginPage2;
import com.mystore.pageobjects.OrderConfirmationPage10;
import com.mystore.pageobjects.OrderPage5;
import com.mystore.pageobjects.OrderSummaryPage9;
import com.mystore.pageobjects.PaymentPage8;
import com.mystore.pageobjects.SearchResultPage4;
import com.mystore.pageobjects.ShippingPage7;

public class EndToEndTest extends BaseClass
{
	IndexPage1 indexPage;
	SearchResultPage4 searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage5 orderPage;
	LoginPage2 loginPage;
	AddressPage6 addressPage;
	ShippingPage7 shippingPage;
	PaymentPage8 paymentPage;
	OrderSummaryPage9 orderSummaryPage;
	OrderConfirmationPage10 orderConfirmationPage;
	
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
	
	@Test(dataProvider="CredentialsLoginAddressPage", dataProviderClass=DataProviderUse.class,groups="Regression")
	public void endToEndTest(HashMap<String,String>input) throws InterruptedException
	{
		indexPage= new IndexPage1();
		searchResultPage=indexPage.searchProduct("T-Shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selecteDD("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOncheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(input.get("username"), input.get("password"));
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummaryPage.confirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expextedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expextedMessage);
	}

}
