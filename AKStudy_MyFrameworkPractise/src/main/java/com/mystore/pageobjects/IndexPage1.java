package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage1 extends BaseClass
{
	//Create constructor to initilize PageFactory driver
	public IndexPage1()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	//PageFactory: OR
	
	@FindBy(css=".login")
	WebElement signInBtn;
	
	@FindBy(css=".logo.img-responsive")
	WebElement myStoreLogo;
	
	@FindBy(css="#search_query_top")
	WebElement searchProductBox;
	
	@FindBy(css=".button-search")
	WebElement searchButton;
	
	//Actions: create methods to use pagefactory elements which will be called in test classes
	public LoginPage2 clickOnSignIn()
	{
		signInBtn.click();
		return new LoginPage2();
	}
	
	public boolean validateLogo()
	{
		boolean flag=myStoreLogo.isDisplayed();
		return flag;
	}
	
	public String getMyStoreTitle()
	{
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage4 searchProduct(String productName)
	{
		searchProductBox.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage4();
	}


}
