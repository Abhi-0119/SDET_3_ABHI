package com.sdet3.practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.genericUtil.ExcelUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderDataProviderFromExcel {

	public static WebDriver driver;
	@Test(dataProvider="getValues")
	public void CalwithDataProviderExcel(String from,String to)
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
	public void getValue() throws Throwable
	{
		ExcelUtil eutil = new ExcelUtil();

		int lastrow = eutil.getLastRowNum(null);

		Object[][] arr = new Object[lastrow+1][3];

		for(int i =0;i<lastrow;i++)
		{
			arr[i][0]=eutil.readExcelData("Sheet3", i, 0);
			arr[i][1]=eutil.readExcelData("Sheet3", i, 1);
		}
	}


}
