package com.orghrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orghrm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factroy
	
		@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']/b")
		WebElement LeaveBtn;
		
		@FindBy(xpath="//div[@id='branding']/a[1]/img")
		WebElement Logo;
		
		@FindBy(xpath="//a[@id='menu_leave_viewLeaveList']")
		WebElement LeaveList;
		
		@FindBy(xpath="//a[@id='menu_leave_Entitlements']")
		WebElement Entitlements;
		
		@FindBy(xpath="//a[@id='menu_leave_viewLeaveEntitlements']")
		WebElement EmployeeEntitlements;
		
		@FindBy(xpath="//a[@id='menu_leave_addLeaveEntitlement']")
		WebElement AddEntitlements;
		
		@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']/b")
		WebElement AdminBtn1;
		
		
		public HomePage(){
			PageFactory.initElements(driver, this);
			
		}
		
		
		public String validateHomePageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateHomePageLogo(){
			return Logo.isDisplayed();
		}
		
		public LeavePage ClickOnLeaveBtn(){
			LeaveBtn.click();
			return new LeavePage();
		}
		
		public LeavePage ClickOnLeaveListBtn() throws InterruptedException{
			Actions action = new Actions(driver);
			action.moveToElement(LeaveBtn).build().perform();
			Thread.sleep(3000);
			LeaveList.click();
			
			 
			return new LeavePage();
			
		}
		public LeavePage ClickOnAddEntitlementsBtn() throws InterruptedException{
			Actions action = new Actions(driver);
			action.moveToElement(LeaveBtn).build().perform();
			Thread.sleep(2000);
			action.moveToElement(Entitlements).build().perform();
			Thread.sleep(3000);
			AddEntitlements.click();
			
			 
			return new LeavePage();
			
		}
		
		public AdminPage VerifyClickOnAdminBtn(){
			AdminBtn1.click();
			return new AdminPage();
		}


		 

	
	
	
}
