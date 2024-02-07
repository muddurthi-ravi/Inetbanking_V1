package com.inetbanking.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserCeartionPage 
{
	WebDriver driver;
	public UserCeartionPage(WebDriver sdriver)
	{
		driver = sdriver;
		PageFactory.initElements(sdriver, this);
		
	}
	@FindBy(linkText = "New Customer")
	WebElement NewCustomerBtn;
	
	@FindBy(name = "name")
	WebElement textName;
	
	@FindBy(xpath = "//input[@name='rad1' and @value='m']")
	WebElement radioMale;
	
	@FindBy(xpath = "//input[@name='rad1' and @value='f']")
	WebElement radioFemale;
	
	@FindBy(id = "dob")
	WebElement textdobFiled;
	
	@FindBy(name = "addr")
	WebElement textAdd;
	
	@FindBy(name = "city")
	WebElement textCity;
	
	@FindBy(name = "state")
	WebElement textState;
	
	@FindBy(name = "pinno")
	WebElement textPin;
	
	@FindBy(name = "telephoneno")
	WebElement textPhone;
	
	@FindBy(name = "emailid")
	WebElement textEmailid;
	
	@FindBy(name = "password")
	WebElement textPassword;
	
	@FindBy(name = "sub")
	WebElement btnSubmit;
		
	
	public void BtnNewCustomer()
	{
		NewCustomerBtn.click();
	}
	
	public void setCustomerName(String cname)
	{
		textName.sendKeys(cname);
	}
	
	public void setMateRadioBtn()
	{
	  radioMale.click();
	}
	
	public void setFemateRadioBtn()
	{
		  radioFemale.click();
	}
	
	public void setDob(String dd, String mm, String yyyy )
	{
		textdobFiled.sendKeys(dd);
		textdobFiled.sendKeys(mm);
		textdobFiled.sendKeys(yyyy);		
	}
	
	public void setAdd(String add)
	{
		textAdd.sendKeys(add);
	}
	
	public void setCity(String city)
	{
		textCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		textState.sendKeys(state);
	}
	
	public void setPin(String pin)
	{
		textPin.sendKeys(pin);
	}
	
	public void setPhone(String phone)
	{
		textPhone.sendKeys(phone);
	}
	
	public void setMail(String mail)
	{
		textEmailid.sendKeys(mail);
	}
	
	public void setCustomerPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	//Customer Registered Successfully!!!
	

}
