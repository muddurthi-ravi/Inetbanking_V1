package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void logintest() throws Throwable 
	{
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(uname);
		logger.info("Entered the Username");
		
		lp.setPassword(pwds);
		logger.info("Entered the password");
		
		lp.login();
		logger.info("Login successfull");
		Thread.sleep(2000);
		
//		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Homepage opened");
		}
		else
		{
			takescreenshot(driver, "TC_LoginTest_001");
			Assert.assertTrue(false);
			logger.info("Homepage not opened");
		}

	}



}
