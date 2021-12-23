package com.sdet3.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableICCTest 
{
	public static WebDriver driver;
	@Test
	public void pointsTeamName()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String point ="2,787";
		List<WebElement> poi = driver.findElements(By.xpath("//table//tbody//tr[*]/td[4]"));
		for(int i =0;i<poi.size();++i)			
		{
			String txt = poi.get(i).getText();
			if(txt.equalsIgnoreCase(point))
			{
				String teamname = driver.findElement(By.xpath("//table//tbody//tr["+i+"]/td[4]/../td[2]")).getText();
				System.out.println(teamname);
				break;
			}
			
			
		}
	}
	
	
	public void ratingPointsTeamName()
	{
		
	}

}
