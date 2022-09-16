package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage10 extends BaseClass
{
	public OrderConfirmationPage10()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css=".cheque-indent")
	WebElement confirmMessage;
	
	public String validateConfirmMessage()
	{
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
	}

}
