package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);;
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnlogin;
	
	//@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	@FindBy(linkText="Log out")
	WebElement lnkLogout;
	
	
	public void SetUserName(String uName)
	{
		txtUserName.sendKeys(uName);
	}
	
	public void SetPassword(String uPassword)
	{
		txtPassword.sendKeys(uPassword);
	}
	
	public void ClickSubmit()
	{
		btnlogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
