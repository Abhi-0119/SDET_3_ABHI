package com.sdet3.practice;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtil.WebDriverUtil;

public class WindowHandling {
	
	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.naukri.com/");
	
	WebDriverUtil dutil = new WebDriverUtil(driver);
	dutil.switchToWindow("Tech Mahindra");
	dutil.maxmizeWindow();
	

}

}