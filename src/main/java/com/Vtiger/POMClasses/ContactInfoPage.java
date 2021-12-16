package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class ContactInfoPage {
	
	
	WebDriver driver;
	@FindAll({@FindBy(xpath="//img[@title='Create Contact...']"), @FindBy(id="Submit")}) private WebElement createContactimg;
	@FindBy(name="search_text") private WebElement searchContactField;
	@FindBy(id="bas_searchfield") private WebElement contactDDValue;
	@FindBy(name="submit") private WebElement contactSubmitBtn;
	//@FindBy(xpath="//a[@title='Contacts' and text()='"+Lname+"']") private WebElement contactSearchResults;

	public ContactInfoPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateContactimg() {
		return createContactimg;
	}
	public WebElement getSearchContactField() {
		return searchContactField;
	}
	public WebElement getContactDDValue() {
		return contactDDValue;
	}
	public WebElement getContactSubmitBtn() {
		return contactSubmitBtn;
	}
//	public WebElement getContactSearchResults() {
//		return contactSearchResults;
//	}
	
	public void searchForContact(String contactname, String searchTypeDD)
	{
		WebDriverUtil wutil = new WebDriverUtil(driver);
		searchContactField.sendKeys(contactname);
		wutil.selectValueFrmDD(searchTypeDD,contactDDValue );;
		contactSubmitBtn.click();
	}
	
	

}
