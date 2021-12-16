package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	@FindBy(xpath="//select[@name='salutationtype']") private WebElement salutedd;
	@FindBy(name="firstname") private WebElement frstNameTxtBox;
	@FindBy(name="lastname") private WebElement  lastNameTxtBox;
	@FindBy(xpath="//img[@alt='Select']") private WebElement selectOrgforContactimg;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveContactBtn;
	
	@FindBy(xpath="//select[@name='industry']") private WebElement industryTypeDD;
	@FindBy(xpath="//select[@name='accounttype']") private WebElement accountTypeDD;
	@FindBy(xpath="//select[@name='rating']") private WebElement ratingTypeDD;
	
	
	public WebElement getIndustryTypeDD() {
		return industryTypeDD;
	}
	public WebElement getAccountTypeDD() {
		return accountTypeDD;
	}
	public WebElement getRatingTypeDD() {
		return ratingTypeDD;
	}
	public WebElement getSaveContactBtn() {
		return saveContactBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSalutedd() {
		return salutedd;
	}
	public WebElement getFrstNameTxtBox() {
		return frstNameTxtBox;
	}
	public WebElement getLastNameTxtBox() {
		return lastNameTxtBox;
	}
	public WebElement getSelectOrgforContactimg() {
		return selectOrgforContactimg;
	}
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
