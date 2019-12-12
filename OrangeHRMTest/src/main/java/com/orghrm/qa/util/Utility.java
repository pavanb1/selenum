package com.orghrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	WebDriver driver; 
	
	public static String TESTDATA_SHEET_PATH="E:/Automation Lab/Selenium pro/OrangeHRMTest/src/main/java/com/orghrm/qa/testdata/OrangeHRM.xlsx";
	static Workbook book;
	static Sheet sheet; 
	
	
	public  void TakeScreenshots() throws IOException{
		
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(srcFile, new File(currentDir + "/target/" + System.currentTimeMillis()+ ".png"));
		
		
		
	}
	
    public  void HandleDropDown(WebElement element,String Value)  {
	
		Select sel = new Select(element);
		
		sel.selectByVisibleText(Value);
	 
	}
    
    public Object[][] getTestData(){
    	FileInputStream file = null;
    	
    	try{
    		file = new FileInputStream(TESTDATA_SHEET_PATH);
    		
    		
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    		
    	}
    	try{
    		 book = WorkbookFactory.create(file);
    		
    	}catch(InvalidFormatException e){
    		e.printStackTrace();
    		
    	}catch(IOException e){
    		e.printStackTrace();
    		
    	}
    	
    	sheet = book.getSheet("systemUser");
    	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	  
    }

	
	
	
	
	
	
	
	
}
