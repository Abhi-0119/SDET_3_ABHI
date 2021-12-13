package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class OrgInfoPage 
{
	
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Create Organization...']") private WebElement createOrgLink;
	@FindBy(xpath="//input[@name='search_text']") private WebElement searchOrgLink;
	@FindBy(id="bas_searchfield") private WebElement searchOrgddLink;
	@FindBy(name="submit") private WebElement searchNowBtn;
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	public WebElement getSearchOrgLink() {
		return searchOrgLink;
	}
	public WebElement getSearchOrgddLink() {
		return searchOrgddLink;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	public OrgInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchForOrg(String nameForOrgToSearch, String txtFromExcel)
	{
		WebDriverUtil wutil = new WebDriverUtil(driver);
		searchOrgLink.sendKeys(nameForOrgToSearch);
		wutil.selectValueFrmDD(txtFromExcel, searchOrgddLink);
		searchNowBtn.click();
	}

}
