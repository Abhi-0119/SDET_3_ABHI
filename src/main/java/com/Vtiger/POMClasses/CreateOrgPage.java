package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage
    {
     WebDriver driver;
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement createOrgimg;
	@FindBy(name="accountname") private WebElement accountName;
	@FindBy(id="phone") private WebElement phneNumTxtBox;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	@FindBy(xpath="//a[@title='Organizations']") private WebElement searchResults;
	@FindBy(xpath="//*[@id='row_19']/td[6]") private WebElement phoneNumResults;
	@FindBy(name="submit") private WebElement orgSubmitBtn;
	
	public WebElement getPhneNumTxtBox()
	{
		return phneNumTxtBox;
	}
	public WebElement getPhoneNumResults()
	{
		return phoneNumResults;
	}
	public WebElement getorgSubmitBtn() 
	{
		return orgSubmitBtn;
	}
	public WebElement getCreateOrgimg() 
	{
		return createOrgimg;
	}
	public WebElement getAccountName() 
	{
		return accountName;
	}
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	public WebElement getSearchResults() 
	{
		return searchResults;
	}
	public CreateOrgPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createOrg(String orgname) 
	{
		createOrgimg.click();
		accountName.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void createOrgWithPhoneNum(String orgname,String phoneNum) 
	{
		createOrgimg.click();
		accountName.sendKeys(orgname);
		phneNumTxtBox.sendKeys(phoneNum);
		saveBtn.click();
	}



}
