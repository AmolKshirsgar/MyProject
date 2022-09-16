package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage3 extends BaseClass
{
	public HomePage3()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css=".icon-heart")
	WebElement myWishList;
	
	@FindBy(css=".icon-list-ol")
	WebElement orderHistory;
	
	public boolean validateMyWishList()
	{
		boolean flag=myWishList.isDisplayed();
		return flag;
	}

	public boolean validateOrderHistory()
	{
		boolean flag=orderHistory.isDisplayed();
		return flag;
	}
	

	public String getCurrentURL()
	{
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
