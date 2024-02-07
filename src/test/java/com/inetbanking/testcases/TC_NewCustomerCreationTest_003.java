package com.inetbanking.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.pageObject.UserCeartionPage;


public class TC_NewCustomerCreationTest_003 extends BaseClass
{
	@Test
	public void customerCreate() throws InterruptedException
	{ 
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(uname);
		logger.info("Username Entered..");
		lp.setPassword(pwds);
		logger.info("Password Entered..");
		lp.login();
		logger.info("login Done..");
		
		UserCeartionPage user = new UserCeartionPage(driver);
		user.BtnNewCustomer();
		logger.info("New customer page Opened");
		logger.info("Customer Details entering...");
		user.setCustomerName("RaviMudduru");
		user.setMateRadioBtn();
		user.setDob("09", "09", "2002");
		user.setAdd("vizag");
		user.setCity("hyderabad");
		user.setState("telangana");
		user.setPin("500013");
		user.setPhone("5524530021");
		String datas = randomString();
		user.setMail(datas+"@gamil.com");
		user.setCustomerPassword("Ravi@123");
		user.clickSubmit();
		Thread.sleep(2000); 
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		logger.info("Customer Registered Successfully!!!");

		if(res)
		{
			Assert.assertTrue(true);
			logger.info("Customer Registered Successfully!!!");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Customer Not Registered");
		}
		
//		lp.logOut();
		
	}
	public String randomString()
	{
		String data = RandomStringUtils.randomAlphabetic(8);
		return data;
	}
}
