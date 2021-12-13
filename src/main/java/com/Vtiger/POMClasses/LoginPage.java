package com.Vtiger.POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.FileUtil;

public class LoginPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']") private WebElement usrnmetxtfield;
	@FindBy(xpath="//input[@type='password']") private WebElement pwdtxtfield;
	@FindBy(id="submitButton") private WebElement loginBtn;
	public WebElement getUsrnmetxtfield() {
		return usrnmetxtfield;
	}
	public WebElement getPwdtxtfield() {
		return pwdtxtfield;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);;
	}
	
	public void loginToApp() throws IOException
	{
		usrnmetxtfield.sendKeys(FileUtil.objforFileUtil().readPropData("username"));
		pwdtxtfield.sendKeys(FileUtil.objforFileUtil().readPropData("password"));
		loginBtn.click();
	}
	
	

}
