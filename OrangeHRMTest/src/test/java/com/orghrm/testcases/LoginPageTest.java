package com.orghrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orghrm.qa.base.TestBase;
import com.orghrm.qa.pages.HomePage;
import com.orghrm.qa.pages.LoginPage;
import com.orghrm.qa.util.Utility;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	Utility util;
	
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage= new LoginPage();
		Utility util=new Utility();
		
	}
	
	@Test (priority=1)
	public void loginPageTitleTest(){
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		System.out.println(title);
		
		
	}
	@Test (priority=2)
	public void VerifyLoginPageLogin() throws InterruptedException {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
 		
		Thread.sleep(2000);
		
		
	}
	
	@Test (priority=3)
	public void ClickOnPswdLink() throws InterruptedException, IOException{
		loginpage.ClickOnForgotPaswd();
		Thread.sleep(2000);
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
