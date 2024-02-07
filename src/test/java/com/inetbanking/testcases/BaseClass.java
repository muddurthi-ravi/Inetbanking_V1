package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;


public class BaseClass {
	Readconfig readconfig = new Readconfig();

	String Url= readconfig.getApplicationUrl();
	String uname=readconfig.getUserName();
	String pwds=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters({"Browser"})
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		driver.get(Url);
		logger.info("open the url");

	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
		logger.info("Closed browser");
	}
	
	public void takescreenshot(WebDriver driver, String temp) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"//ScreenShots//"+temp+".png");
		FileUtils.copyFile(src, des);
		
		
	}




}
