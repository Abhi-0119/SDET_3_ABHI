package com.sdet3.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTest
{
	public static WebDriver driver;
	@Test
	public void orgPresent() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.loginToApp();
		hp.getOrgTab().click();
		Thread.sleep(2000);
		String orgName = "Octavio598";
		List<WebElement> org = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[3]"));
		for(int i =3;i< org.size();i++)
		{
		WebElement tab = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[3]"));
		String name = tab.getText();
		if(orgName.equals(name))
		{
		System.out.println(name+" is present");
		break;
		}
		
		}

	}
	
	@Test
	public void deleteOrg() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.loginToApp();
		hp.getOrgTab().click();
		Thread.sleep(2000);
		String orgName = "Oren953";
		List<WebElement> org = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[3]"));
		for(int i =3;i< org.size();i++)
		{
		WebElement tab = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[3]"));
		String name = tab.getText();
		if(orgName.equals(name))
		{
		System.out.println(name+" is present");
		driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[3]/..//td[1]")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		
		try {	
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			WebElement tab1 = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[3]"));
			String name1 = tab1.getText();
			System.out.println("The organisation"+name1+" is not deleted");
			
		} catch (Exception e) {
			System.out.println("The Organisation deleted Sucessfully");
		}
		break;
		}
		
		}
	}
    
	@Test
	public void clickAllCheckBox() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.loginToApp();
		hp.getOrgTab().click();
		Thread.sleep(2000);
		List<WebElement> org = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[3]"));
		for(int i = 3;i<org.size();i++)
		{
			driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[3]/..//td[1]")).click();
		}
	}
	
}




