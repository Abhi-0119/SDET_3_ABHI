package com.sdet3.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueStoneTest 
{
	public static WebDriver driver;
	@Test
	public void priceTest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("RINGS");
		driver.findElement(By.xpath("//input[@name='submit_search']")).click();
		WebElement mhover = driver.findElement(By.id("Price-form"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mhover).perform();
		driver.findElement(By.xpath("//span[@data-displayname='below rs 10000']")).click();
		List<WebElement> add = driver.findElements(By.xpath("//div[@id='grid-view-result']//span[@class='p-wrap']"));
		System.out.println("The count of Rings less than 10000 are "+add.size());
		driver.close();
		
	}
	
	@Test
	public void deliveryTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("RINGS");
		driver.findElement(By.xpath("//input[@name='submit_search']")).click();
		WebElement mhover = driver.findElement(By.id("Price-form"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mhover).perform();
		driver.findElement(By.xpath("//span[@data-displayname='below rs 10000']")).click();
		try {
			WebElement hover = driver.findElement(By.id("Delivery Time-form"));
			Actions act = new Actions(driver);
			act.moveToElement(hover).perform();
			driver.findElement(By.xpath("//span[@data-displayname='next day delivery'][@data-tagcategory='Delivery Time']")).click();
			WebElement exp = driver.findElement(By.xpath("//span[text()='(266)']"));
			String expected = exp.getText();
			System.out.println(expected);
		}
		
		catch (Exception e) {
			driver.findElement(By.xpath("//label[@for='filter_ndd']")).click();
		}
		String delRes = driver.findElement(By.xpath("//span[text()='4 Designs']")).getText();
		String[] arr = delRes.split(" ");
		String cc = arr[0];
		int c = Integer.parseInt(cc);
		System.out.println(c);
		
		 List<WebElement> add = driver.findElements(By.xpath("//div[@id='grid-view-result']//span[@class='p-wrap']"));
		 int count = 0;
		 
		for(WebElement s:add)
		 {
			String res = s.getText();
			int i = Integer.parseInt(res);
			
			if(i<10000)
			{
				System.out.println(i);
				count++;
			}
		 }
		
		 System.out.println(count);
		
		System.out.println("The count of Rings for next day delivery are ");
	}

}
