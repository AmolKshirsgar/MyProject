package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage5 extends BaseClass
{
	public OrderPage5()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="(//span[@class='price'])[2]")
	WebElement unitPrice;
	
	@FindBy(css="#total_price")
	WebElement totalPrice;
	
	@FindBy(css=".button-medium:first-child")
	WebElement proceedToCheckOut;
	
	public double getUnitPrice()
	{
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");  //this regexp will remove all special charectors from string
		double finalUnitPrice=Double.parseDouble(unit); //this will conver string to double
		return finalUnitPrice/100;  //as all special charectors removed so to get final value we devide by 100
	}
	
	public double getTotalPrice()
	{
		String totalPrice1=totalPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");  //this regexp will remove all special charectors from string
		double finalTotalPrice=Double.parseDouble(total); //this will conver string to double
		return finalTotalPrice/100;  //as all special charectors removed so to get final value we devide by 100
	}
	
	public LoginPage2 clickOnCheckOut()
	{
		proceedToCheckOut.click();
		return new LoginPage2();
	}
	
	

}
