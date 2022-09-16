package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage2 extends BaseClass
{
	public LoginPage2()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id="email_create")
	WebElement createNewAccountBtn;
	
	
	
	public AccountCrearionPage createNewAccount(String newEmail)
	{
		emailForNewAccount.sendKeys(newEmail);
		createNewAccountBtn.click();
		return new AccountCrearionPage();
	}
	
	public HomePage3 login(String uName, String pwd)
	{
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		signInBtn.click();
		
		return new HomePage3();
	}
	
	public AddressPage6 login1(String uName, String pwd)
	{
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		signInBtn.click();
		
		return new AddressPage6();
	}

}
