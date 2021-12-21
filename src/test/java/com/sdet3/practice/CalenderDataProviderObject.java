package com.sdet3.practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderDataProviderObject 
{
	public static WebDriver driver;
	@Test
	public void CalwithDataProviderObject()
	{
		Date d = new Date();
		//Date todayDate = Calendar.getInstance().getTime();
		String todayDate = d.toString();
		String[] arr = todayDate.split(" ");
		String day = arr[0];
		String month = arr[1];
		String date = arr[2];
		String year = arr[5];
		String cDate = day+" "+month+" "+date+" "+year;
		System.out.println(cDate);
						
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		
		
		driver.findElement(By.id("fromCity")).sendKeys("HYD");
		
		driver.findElement(By.xpath("//div[.='HYD']")).click();
		
		
		driver.findElement(By.id("toCity")).sendKeys("GOI");
		
		driver.findElement(By.xpath("//div[.='GOI']")).click();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='"+cDate+"']")).click();
	}
	
	@DataProvider
	public void getValues()
	{
		Object arr[] []= new Object[4] [2];
		
		arr[0][1] = "HYD";
		arr[1][1] = "GOI";
		
		arr[0][1] = "HYD";
		arr[1][1] = "B";
		
		arr[0][1] = "HYD";
		arr[1][1] = "GOI";
		
		arr[0][1] = "HYD";
		arr[1][1] = "GOI";
	}
	
}
