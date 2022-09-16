package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage6 extends HomePage3 
{
	public AddressPage6()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement proceedToCheckOut;
	
	public ShippingPage7 clickOnCheckOut()
	{
		proceedToCheckOut.click();
		return new ShippingPage7();
	}

}
