package com.sdet3.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathForDiffSituations 
{
	public static WebDriver driver;
	@Test
	public void pauseTheScriptForDD()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@type='text']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
		for(WebElement s:list)
		{
			System.out.println(s.getText());
		}
		
		driver.close();
	}
	
	@Test
	public void mouseHoverText()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String text = driver.findElement(By.xpath("//div[@class='logo']/a/img")).getAttribute("title");
		System.out.println(text);
		
		driver.close();
	}
	
	
	@Test
	public void svgTag() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.learnatnoon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(2000);
		String txt = driver.findElement(By.xpath("//div[@class='main']//*[@class='icon icon-noon ']")).getText();
		System.out.println(txt);
		
		driver.close();
	}
	
	@Test
	public void lastField()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> allTeams = driver.findElements(By.xpath("//table//tbody//tr[*]/td[2]"));
		for(WebElement team :allTeams)
		{
			System.out.println(team.getText());
		}
		String txt = driver.findElement(By.xpath("(//table//tbody//tr[*]/td[2])[last()]")).getText();
		System.out.println("The last Team is "+txt);
		
	}
	
	@Test
	public void valueWithSpaces()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//div[normalize-space()='Rankings']")).click();
		List<WebElement> val = driver.findElements(By.xpath("//div[@class='global-navigation__drop-down-column']/ul/li"));
	    for(WebElement sv :val)
	    {
	    	System.out.println(sv.getText());
	    }
	    
	    driver.close();
	}

}
