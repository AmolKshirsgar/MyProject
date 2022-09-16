package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage4 extends BaseClass
{
	public SearchResultPage4()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css="img[title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public boolean isProductAvail()
	{
		boolean flag=productResult.isDisplayed();
		return flag;
	}
	
	public AddToCartPage clickOnProduct()
	{
		productResult.click();
		return new AddToCartPage();
	}

}
