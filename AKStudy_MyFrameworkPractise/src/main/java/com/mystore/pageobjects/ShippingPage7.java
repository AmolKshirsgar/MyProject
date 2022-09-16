package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage7 extends BaseClass
{
	
	public ShippingPage7()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public void checkTheTerms()
	{
		terms.click();
	}
	
	public PaymentPage8 clickOnProceedToCheckOut()
	{
		proceedToCheckOutBtn.click();
		return new PaymentPage8();
	}

}
