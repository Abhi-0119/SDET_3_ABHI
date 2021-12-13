package com.Vtiger.TC;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.CreateOrgPage;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.OrgInfoPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

@Listeners(com.Vtiger.genericUtil.ListnersClass.class)
public class TC001_CreateOrganisationTest  extends BaseClass {
	
	@Test(groups = "Smoke Testing",retryAnalyzer = com.Vtiger.genericUtil.RetryAnalyzer.class)
	public void createOrg() throws Throwable 
	{
		
		WebDriverUtil wutil = new WebDriverUtil(driver);
		ExcelUtil eutil = new ExcelUtil();
		HomePage hp = new HomePage(driver);
		OrgInfoPage op = new OrgInfoPage(driver);
		CreateOrgPage cp = new CreateOrgPage(driver);
		String Orgname = JavaUtil.objForJavaUtil().genrateFirstName()+JavaUtil.objForJavaUtil().generateRandomNumber(1000);
		hp.getOrgTab().click();
		cp.createOrg(Orgname);
		wutil.refresh();
		hp.getOrgTab().click();
		String txt = eutil.readExcelData("TC002", 2, 4);
		op.searchForOrg(Orgname, txt);
		WebElement result = cp.getSearchResults();
		System.out.println(result.isDisplayed());
		String actual = result.getText();
		Assert.assertEquals(Orgname, actual);
		hp.getOrgTab().click();	
		
	}
	
	@Test(groups = "Regression Testing")
	public void OrgnameWithNum() throws EncryptedDocumentException, IOException
	{
		WebDriverUtil wutil = new WebDriverUtil(driver);
		ExcelUtil eutil = new ExcelUtil();
		HomePage hp = new HomePage(driver);
		OrgInfoPage op = new OrgInfoPage(driver);
		CreateOrgPage cp = new CreateOrgPage(driver);
		String Orgname = JavaUtil.objForJavaUtil().genrateFirstName()+JavaUtil.objForJavaUtil().generateRandomNumber(1000);
		String phoneNum = JavaUtil.objForJavaUtil().phoneNumber();
		hp.getOrgTab().click();
		cp.createOrgWithPhoneNum(Orgname,phoneNum);
		wutil.refresh();
		hp.getOrgTab().click();
		String txt = eutil.selValueForDD("TC002", 4, "Phone");
		op.searchForOrg(phoneNum, txt);
		WebElement result = cp.getPhoneNumResults();
		System.out.println(result.isDisplayed());
		String actual = result.getText();
		Assert.assertEquals(phoneNum, actual);
		
	}

}
