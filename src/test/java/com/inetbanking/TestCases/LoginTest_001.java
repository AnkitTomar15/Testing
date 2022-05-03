package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException 
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp= new LoginPage(driver);
		lp.SetUserName(Username);
		logger.info("Username is Entered");

		lp.SetPassword(password);
		logger.info("Password is Entered");
		
		lp.ClickSubmit();
		//String s =driver.getTitle();
		//System.out.print(s);		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Logging test is passed");
		}
		
		else
		{
			CaptureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("Logging test is failed");
		}
	}

}
