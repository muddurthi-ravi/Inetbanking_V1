package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.Xlutils;

public class TC_LoginTest_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void logintest(String user, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username Entered..");
		lp.setPassword(pwd);
		logger.info("Password Entered..");
		lp.login();
		logger.info("login done");
		if(isAlertDisplayed()==true)
		{
			driver.switchTo().alert().accept();
			logger.info("Invalid Alert is accepted");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else
		{
			lp.logOut();
			driver.switchTo().alert().accept();
			logger.info("Valid Alert is accepted");
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}

	}

	public boolean isAlertDisplayed()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) 
		{
			return false;

		}
	}



	@DataProvider(name ="LoginData")
	public String[][] getData() throws IOException
	{ 
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rcount = Xlutils.getRowCount(path, "Data");	
		int ccount = Xlutils.getCellCount(path, "Data", 1);
		String data[][] = new String[rcount][ccount];
		for(int i=1;i<=rcount;i++)
		{
			for(int j=0;j<ccount;j++)
			{
				data[i-1][j]= Xlutils.getCellData(path, "Data", i, j);
			}
		}
		return data;
	}


}
