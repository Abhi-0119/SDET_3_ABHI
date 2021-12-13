package com.Vtiger.genericUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public  WebDriver driver;
	public  LoginPage lp;
	public  WebDriverUtil wutil;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"Smoke Testing","Regression Testing"})
	public void setUp()
	{
		System.out.println("Connect to DB");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke Testing","Regression Testing"})
	public void launcBrowser_URL() throws IOException {
	
	String bname = FileUtil.objforFileUtil().readPropData("browser");
	if(bname.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		sdriver = new ChromeDriver();
	}
	else if(bname.equals("firefox")) 
	{
		WebDriverManager.firefoxdriver().setup();
		sdriver = new FirefoxDriver();
	}
	else if(bname.equals("ie")) 
	{
		WebDriverManager.iedriver().setup();
		sdriver = new InternetExplorerDriver();
	}
	else 
	{
		WebDriverManager.chromedriver().setup();
		sdriver = new ChromeDriver();
	}
	driver=sdriver;
	driver.get(FileUtil.objforFileUtil().readPropData("url"));

	wutil = new WebDriverUtil(driver);
	wutil.maxmizeWindow();
	wutil.pageLoadWait();
	lp = new LoginPage(driver);
	sdriver=driver;
	
	}
	
	@BeforeMethod(groups = {"Smoke Testing","Regression Testing"})
	public void loginToApp() throws IOException
	{
		lp.loginToApp();
	}
	
	@AfterMethod(groups = {"Smoke Testing","Regression Testing"})
	public void logoutFromApp()
	{
		HomePage hp = new HomePage(driver);
		
		wutil.refresh();
		hp.signOutFromApp();
	}
	
	@AfterClass(groups = {"Smoke Testing","Regression Testing"})
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterSuite(groups = {"Smoke Testing","Regression Testing"})
	public void disconnectFromDB()
	{
		System.out.println("Disconnected from DB");
	}
	
	public static void takeScreenshot(String name) throws IOException
	{
		File srcfile = ((TakesScreenshot)sdriver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/screenshots/"+name+".png");
		FileUtils.copyFile(srcfile, dest); 
		
	}
}
