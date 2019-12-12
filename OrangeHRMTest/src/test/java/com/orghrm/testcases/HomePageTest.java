package com.orghrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orghrm.qa.base.TestBase;
import com.orghrm.qa.pages.AdminPage;
import com.orghrm.qa.pages.HomePage;
import com.orghrm.qa.pages.LeavePage;
import com.orghrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	LeavePage leavePage;
	AdminPage adminPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest(){
		String homePage = homepage.validateHomePageTitle();
		Assert.assertEquals(homePage, "OrangeHRM");
		
	}
	@Test(priority=2)
	public void validateHomePageLogoTest(){
		
		homepage.validateHomePageLogo();
		
	}
	@Test(priority=3)
	public void validateHClickOnLeaveBtnTest() throws InterruptedException{
		homepage.ClickOnLeaveBtn();
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void validateClickOnLeaveLisBtnTest() throws InterruptedException {
		homepage.ClickOnLeaveListBtn();
		
		
	}
	@Test(priority=5)
	public void validateClickOnAddEntitlementsBtnTest() throws InterruptedException {
		homepage.ClickOnAddEntitlementsBtn();
		
		
	}
	@Test(priority=6)
	public void validateHClickOnAdminBtnTest() throws InterruptedException{
		homepage.VerifyClickOnAdminBtn();
		 
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	
	
	
}
