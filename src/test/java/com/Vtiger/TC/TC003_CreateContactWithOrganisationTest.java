package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.ContactInfoPage;
import com.Vtiger.POMClasses.CreateContactPage;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.SelectOgrForContactPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC003_CreateContactWithOrganisationTest extends BaseClass
    {
      
	@Test(groups = "Regression Testing")
	public void CreateOrgWithCntact() throws Throwable 
	{
	
		WebDriverUtil wutil = new WebDriverUtil(driver);
		ExcelUtil eutil = new ExcelUtil();
		HomePage hp = new HomePage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		SelectOgrForContactPage socp = new SelectOgrForContactPage(driver);
		//click on contacts tab
		hp.getContactTab().click();
		//click on create contact
		cip.getCreateContactimg().click();
        //select salutation from dropdown using excel
		String txt = eutil.readExcelData("TC003", JavaUtil.objForJavaUtil().generateRandomNumber(7), 1);
		wutil.selectValueFrmDD(txt, ccp.getSalutedd());
		//first name
		String Fname = JavaUtil.objForJavaUtil().genrateFirstName()+JavaUtil.objForJavaUtil().generateRandomNumber(100);
		ccp.getFrstNameTxtBox().sendKeys(Fname);
		//last name
		String Lname = JavaUtil.objForJavaUtil().genrateFirstName()+JavaUtil.objForJavaUtil().generateRandomNumber(100);
		ccp.getLastNameTxtBox().sendKeys(Lname);
		// select Organization name 
		ccp.getSelectOrgforContactimg().click();
		String pwin = driver.getWindowHandle();
		wutil.switchToWindow("specific_contact_account_address");
		socp.selectOrgforContact("SDET3");
		wutil.switchTopwindow(pwin);
		//click save button
		ccp.getSaveContactBtn().click();
		//refresh
		wutil.refresh();
		//contacts tab
		hp.getContactTab().click();
		//verify
		cip.searchForContact(Lname,"Last Name");
		WebElement result =driver.findElement(By.xpath("//a[@title='Contacts' and text()='\"+Lname+\"']"));
		System.out.println(result.isDisplayed());
		String actual = result.getText();
		Assert.assertEquals(Lname, actual);
		
	}
	
	@Test(groups ="Smoke Testing")
	public void createContactOnly()
	{
		WebDriverUtil wutil = new WebDriverUtil(driver);
		HomePage hp = new HomePage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		//click on contacts tab
		hp.getContactTab().click();
		//click on create contact
		cip.getCreateContactimg().click();
		String Lname = JavaUtil.objForJavaUtil().genrateFirstName()+JavaUtil.objForJavaUtil().generateRandomNumber(100);
		ccp.getLastNameTxtBox().sendKeys(Lname);
		ccp.getSaveContactBtn().click();
		//refresh
		wutil.refresh();
		//contacts tab
		hp.getContactTab().click();
		//verify
		cip.searchForContact(Lname,"Last Name");
		WebElement result = driver.findElement(By.xpath("//a[@title='Contacts' and text()='"+Lname+"']"));
		System.out.println(result.isDisplayed());
		String actual = result.getText();
		Assert.assertEquals(Lname, actual);
	}
	

}
