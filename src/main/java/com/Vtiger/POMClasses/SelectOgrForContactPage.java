package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOgrForContactPage {
	WebDriver driver;
	@FindBy(id="search_txt") private WebElement OrgnameTxtBox;
	@FindBy(name="search") private WebElement searchNowBtn;
	@FindBy(xpath="//a[text()='SDET3']") private WebElement resultsField;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgnameTxtBox() {
		return OrgnameTxtBox;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	public WebElement getResultsField() {
		return resultsField;
	}
	public SelectOgrForContactPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectOrgforContact(String orgNameToSearch)
	{
		OrgnameTxtBox.sendKeys(orgNameToSearch);
		searchNowBtn.click();
		resultsField.click();
	}
	

}
