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
	@Test(dataProvider="getValues")
	public void CalwithDataProviderObject(String from,String to)
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
		
		
		driver.findElement(By.id("fromCity")).sendKeys(from);
		
		driver.findElement(By.xpath("//div[.='"+from+"']")).click();
		
		
		driver.findElement(By.id("toCity")).sendKeys(to);
		
		driver.findElement(By.xpath("//div[.='"+to+"']")).click();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='"+cDate+"']")).click();
	}
	
	@DataProvider
	public Object[][] getValues()
	{
		Object arr[] []= new Object[4] [2];
		
		arr[0][0] = "HYD";
		arr[0][1] = "GOI";
		
		arr[1][0] = "HYD";
		arr[1][1] = "BOM";
		
		arr[2][0] = "HYD";
		arr[2][1] = "DEL";
		
		arr[3][0] = "HYD";
		arr[3][1] = "MAA";
		
		return arr;
	}
	
}
