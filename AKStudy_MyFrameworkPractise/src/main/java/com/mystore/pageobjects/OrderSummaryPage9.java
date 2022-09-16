package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage9 extends BaseClass
{
	public OrderSummaryPage9()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//button/span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderConfirmationPage10 confirmOrderBtn()
	{
		confirmOrderBtn.click();
		return new OrderConfirmationPage10();
	}

}
