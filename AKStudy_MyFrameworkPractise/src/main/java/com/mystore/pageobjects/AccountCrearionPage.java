package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCrearionPage extends BaseClass
{
	
	public AccountCrearionPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css=".page-heading")
	WebElement formTitle;
	
	public boolean validateACcountCreatePage()
	{
		boolean flag=formTitle.isDisplayed();
		return flag;
	}

}
