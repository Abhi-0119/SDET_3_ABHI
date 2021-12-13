package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy(xpath= "//a[text()='Organizations']") private WebElement orgTab;
	@FindBy(xpath= "//a[text()='Contacts']") private WebElement ContactTab;
	@FindBy(xpath= "//img[@style='padding: 0px;padding-left:5px']") private WebElement userimg;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signoutLink;
	
	public WebElement getOrgTab() {
		return orgTab;
	}
	public WebElement getContactTab() {
		return ContactTab;
	}
	public WebElement getUserimg() {
		return userimg;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signOutFromApp()
	{
		WebDriverUtil wutil = new WebDriverUtil(driver);
		
		wutil.moveToEle(userimg);
		signoutLink.click();
	}
	
}
