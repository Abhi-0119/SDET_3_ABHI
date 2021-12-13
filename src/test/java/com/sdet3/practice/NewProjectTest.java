package com.sdet3.practice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.POMClasses.LoginPage;
import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class NewProjectTest {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException
	{
	String bname = FileUtil.objforFileUtil().readPropData("browser");
	if(bname.equals("chrome")) {
		driver = new ChromeDriver();
	}
	else if(bname.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	else {
		driver = new ChromeDriver();
	}
	
	WebDriverUtil wutil = new WebDriverUtil(driver);
	LoginPage lp = new LoginPage(driver);
	
	wutil.maxmizeWindow();
	wutil.pageLoadWait();
	
	driver.get(FileUtil.objforFileUtil().readPropData("url"));
	
	lp.loginToApp();
		driver.findElement(By.id("qccombo")).click();
	 List<WebElement> allList = driver.findElements(By.xpath("//select[@id='qccombo']//option"));
		 
	 
	 for(WebElement option :allList)
	 {
		 if(option.getText().contains("New Project"))
		 {
			 option.click();
			 break;
		 }
	 }
//	 for(int i=0;i<=allList.size();i++)
//	 {
//		 Object value = allList.get(i).getText();
//		 if(value.equals("New Project"))
//		 {
//			 allList.get(i).click();
//			 break;
//		 }
	 }
	
	}


