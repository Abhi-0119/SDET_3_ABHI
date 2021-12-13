package com.sdet3.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommandLineTest 
{
	@Test
	public void commandLineParameter()
	{
		WebDriver driver;
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		System.out.println(browser);
		System.out.println(url);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie")) 
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(url);
	}

}
