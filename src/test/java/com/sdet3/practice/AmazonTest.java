package com.sdet3.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtil.WebDriverUtil;

public class AmazonTest {
	
	public static void main(String[]args)
	{
		WebDriver driver = new ChromeDriver();
		WebDriverUtil wutil = new WebDriverUtil(driver);
		driver.get("https://www.amazon.in/");
		wutil.maxmizeWindow();
		wutil.pageLoadWait();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles under 15000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		// WebElement checkbox =;
				 driver.findElement(By.xpath("//*[@aria-labelledby=\"p_89-title\"]/li/span")).click();
		//wutil.moveToEle(checkbox);
	}

}
