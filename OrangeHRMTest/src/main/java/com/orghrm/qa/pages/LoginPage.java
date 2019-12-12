package com.orghrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orghrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	//Page Factroy
	
	@FindBy(id="txtUsername")
	WebElement Username;
	
	@FindBy(id="txtPassword")
	WebElement Password;
	
	@FindBy(id="btnLogin")
	WebElement Loginbtn;
	
	@FindBy(xpath="//*[@id='forgotPasswordLink']/a")
	WebElement ForgotPaswd;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd){
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Loginbtn.click();
		
		return new HomePage();
		
		
	}
	public void ClickOnForgotPaswd(){
		ForgotPaswd.click();
		
		
		
	}
	
	
	
	
	
	
	

}
