package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(css="#quantity_wanted")
	WebElement quantity;
	
	@FindBy(css="#group_1")
	WebElement size;
	
	@FindBy(xpath="//button[@class='exclusive']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//i[@class='icon-ok']")
	WebElement addToCartBMessage;
	
	@FindBy(css=".button-medium")
	WebElement proceedToCheckOutBtn;

	
	public void enterQuantity(String productCount)
	{	
		quantity.clear();
		quantity.sendKeys(productCount);
	}
	
	public void selecteDD(String SizeOfProduct)
	{	
		WebElement ddOption=size;
		Select dd= new Select(ddOption);
		dd.selectByVisibleText(SizeOfProduct);
	}
	

	public void clickOnAddToCart()
	{
		addToCartBtn.click();
	}
	

	
	public boolean validateOnAddToCart() throws InterruptedException
	{
		Thread.sleep(3000);  //in running test its taking time to elemet popup so used thread in method
		boolean flag=addToCartBMessage.isDisplayed();
		return flag;
	}
	
	public OrderPage5 clickOncheckOut() throws InterruptedException
	{
		Thread.sleep(3000);
		proceedToCheckOutBtn.click();
		return new OrderPage5();
	}

}
