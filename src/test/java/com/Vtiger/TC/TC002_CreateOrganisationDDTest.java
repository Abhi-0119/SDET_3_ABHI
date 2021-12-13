package com.Vtiger.TC;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.CreateContactPage;
import com.Vtiger.POMClasses.CreateOrgPage;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.OrgInfoPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC002_CreateOrganisationDDTest extends BaseClass {

	@Test(groups = "Regression Testing")
	public void createOrgWithDD() throws Throwable {

		WebDriverUtil wutil = new WebDriverUtil(driver);
		ExcelUtil eutil = new ExcelUtil();
		HomePage hp = new HomePage(driver);
		OrgInfoPage op = new OrgInfoPage(driver);
		CreateOrgPage cp = new CreateOrgPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		String Orgname = JavaUtil.objForJavaUtil().genrateFirstName()+JavaUtil.objForJavaUtil().generateRandomNumber(1000);
		hp.getOrgTab().click();
		cp.createOrg(Orgname);
		String txt0 = eutil.readExcelData("TC002", JavaUtil.objForJavaUtil().generateRandomNumber(33), 1);
		wutil.selectValueFrmDD(txt0,ccp.getIndustryTypeDD() );
		String txt1 = eutil.readExcelData("TC002", JavaUtil.objForJavaUtil().generateRandomNumber(12), 2);
		wutil.selectValueFrmDD(txt1, ccp.getAccountTypeDD());
		String txt2 = eutil.readExcelData("TC002", JavaUtil.objForJavaUtil().generateRandomNumber(7), 3);
		wutil.selectValueFrmDD(txt2, ccp.getRatingTypeDD());
		cp.getSaveBtn().click();
		wutil.refresh();
		String txt = eutil.readExcelData("TC002", 2, 4);
		op.searchForOrg(Orgname, txt);
		WebElement result = cp.getSearchResults();
		System.out.println(result.isDisplayed());
		String actual = result.getText();
		Assert.assertEquals(Orgname, actual);


	}

}
