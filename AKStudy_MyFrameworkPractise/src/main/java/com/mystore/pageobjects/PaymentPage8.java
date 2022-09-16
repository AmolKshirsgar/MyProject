package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage8 extends BaseClass
{
	
	public PaymentPage8()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css=".bankwire")
	WebElement bankWireMethod;
	
	@FindBy(css=".cheque")
	WebElement payByChequeMethod;
	
	public OrderSummaryPage9 clickOnPaymentMethod()
	{
		bankWireMethod.click();
		return new OrderSummaryPage9();
	}

}
