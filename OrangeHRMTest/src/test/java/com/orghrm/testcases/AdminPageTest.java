package com.orghrm.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orghrm.qa.base.TestBase;
import com.orghrm.qa.pages.AdminPage;
import com.orghrm.qa.pages.HomePage;
import com.orghrm.qa.pages.LoginPage;
import com.orghrm.qa.util.Utility;

public class AdminPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	Utility utile;
	String sheetName="systemUser";
	 
	
	public AdminPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		utile= new Utility();
		adminpage=new AdminPage();
		 
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		adminpage.ClickOnAdminBtn1();

		
	}
	 
	 
	@DataProvider
	public Object [][] getHRMTestData(){
		Object data[][]=utile.getTestData();
		return data;
		
	}
	@Test(priority=1,dataProvider="getHRMTestData")
	public void validateAddTestDataFromExcel(String username,String userroll,String empname,String status) throws InterruptedException {
		
		adminpage.AddTesDataFromExcel(username, userroll, empname, status);
		Thread.sleep(5000);
		 
	
	}
	
	
	@Test(priority=2)
	public void validateAddDataTest() throws InterruptedException {
		 
		adminpage.validateAddData();
		Thread.sleep(5000);
		 
	
	}
	
	@Test(priority=3)
	public void validateClickAddBtnTest() {
		
		 
		adminpage.ClickOnAddBtn();
		
		 
		 
	
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	
	
}
