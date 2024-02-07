package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{	

	WebDriver driver ;
	public LoginPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	WebElement txtuname;
	@FindBy(name="password")
	WebElement txtpwd;
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	@FindBy(linkText = "Log out")
	WebElement logout;

	public void setUsername(String uname)
	{
		txtuname.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	public void login() 
	{
		loginbtn.click();
	}
	
	public void logOut()
	{
		logout.click();
	}

}
