package com.orghrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orghrm.qa.base.TestBase;
import com.orghrm.qa.util.Utility;

public class AdminPage extends TestBase {
	Utility util= new Utility();
	
	//Page Factroy
	
			@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']/b")
			WebElement AdminBtn;
			
			@FindBy(xpath="//input[@id='searchSystemUser_userName']")
			WebElement userName;
			
			@FindBy(xpath="//select[@id='searchSystemUser_userType']")
			WebElement userRoll;
			
			@FindBy(xpath="//input[@id='searchSystemUser_employeeName_empName']")
			WebElement empName;
			
			@FindBy(xpath="//select[@id='searchSystemUser_status']")
			WebElement status;
			
			@FindBy(xpath="//input[@id='searchBtn']")
			WebElement searchBtn;
			
			@FindBy(xpath="//input[@id='btnAdd']")
			WebElement AddBtn;
			
			public AdminPage(){
				PageFactory.initElements(driver, this);
				
			}
			
			
			public AdminPage ClickOnAdminBtn1(){
				AdminBtn.click();
				return new AdminPage();
			}
			
			public void validateAddData(){
				userName.sendKeys("Pavan");
				empName.sendKeys("Raj");
				util.HandleDropDown(userRoll, "ESS");
				util.HandleDropDown(status, "Disabled");
				searchBtn.click();

				//Select select = new Select(userRoll);
				//select.selectByVisibleText("ESS");
			 
			}
			public void  AddTesDataFromExcel(String UserName,String UserRoll,String EmpName,String Status){
				userName.sendKeys(UserName);
				util.HandleDropDown(userRoll, UserRoll);
				empName.sendKeys(EmpName);
				
				util.HandleDropDown(status, Status);
				searchBtn.click();

				//Select select = new Select(userRoll);
				//select.selectByVisibleText("ESS");
			 
			}
			
			public void ClickOnAddBtn(){
				AddBtn.click();
				 
			}
			
			
			

}
