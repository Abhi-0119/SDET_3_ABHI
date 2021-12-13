package com.Vtiger.genericUtil;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	WebDriver driver;
	public WebDriverUtil(WebDriver driver)
	{
		this.driver= driver;
	}

	public void maxmizeWindow()
	{
		driver.manage().window().maximize();
	}

	public void pageLoadWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void refresh()
	{
		driver.navigate().refresh();
	}
	public void selectValueFrmDD(String text,WebElement ele)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}

	public void selectValueFrmDD(WebElement ele,String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}

	public void selectValueFrmDD(WebElement ele,int index)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}

	public void moveToEle(WebElement ele) 
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();
	}

	public void rightClick(WebElement ele) 
	{
		Actions ac = new Actions(driver);
		ac.contextClick(ele).build().perform();
	}

	public void rightClick()
	{
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();
	}

	public void clickByOffset(int xOffset,int yOffset) {
		Actions ac = new Actions(driver);
		ac.moveByOffset(xOffset, yOffset).click();
	}
	
	public void switchToFrames(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	public void switchToFrames(int index)
	{
		driver.switchTo().frame(index);
	}
	

	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}

	public void dissmisAlert()
	{
		driver.switchTo().alert().dismiss();
	}

	public void sendKeys(WebElement ele,String value)
	{
		ele.sendKeys(value);
	}

	public void scrollToEle(WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public void scrollByPosition(int x,int y)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}

	public void switchTopwindow(String parentwindowadd)
	{
		driver.switchTo().window(parentwindowadd);
	}
	public void switchToWindow(String title)
	{
		Set<String> winids = driver.getWindowHandles();
		for(String id :winids)
		{
			String currentTitle = driver.switchTo().window(id).getTitle();
			System.out.println(currentTitle);
			if(currentTitle.contains(title))
			{
				break;
			}
		}
	}


}
