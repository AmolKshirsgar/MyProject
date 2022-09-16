package com.mystore.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderUse;
import com.mystore.pageobjects.AccountCrearionPage;
import com.mystore.pageobjects.IndexPage1;
import com.mystore.pageobjects.LoginPage2;

import junit.framework.Assert;

public class AccountCreationPageTest extends BaseClass
{
	IndexPage1 indexPage;
	LoginPage2 loginPage;
	AccountCrearionPage accountCreationPage;
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		 launchApp(browser);
	}
	
	@Parameters("browser")  //use this to call from xml instead of config file
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().close();
	}
	
	@Test(dataProvider="CredentialsCreateAccount",dataProviderClass=DataProviderUse.class,groups="Sanity")
	public void verifyCreateAccountPageTest(HashMap<String,String>input)
	{
		indexPage=new IndexPage1();
		loginPage=indexPage.clickOnSignIn();
		//accountCreationPage=loginPage.createNewAccount("ak1819@gmail.com");  by confige method
		accountCreationPage=loginPage.createNewAccount(input.get("username"));    //by DataProvider json
		boolean result=accountCreationPage.validateACcountCreatePage();
		Assert.assertTrue(result);
		
	}

}
