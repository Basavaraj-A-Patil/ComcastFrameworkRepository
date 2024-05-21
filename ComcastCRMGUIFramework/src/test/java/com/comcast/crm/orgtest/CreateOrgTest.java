package com.comcast.crm.orgtest;

/**
 * @author Basavaraj
 */
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListnerImpClass.class)
public class CreateOrgTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrg() throws Throwable {
		/* Fetch orgName from TestData File */
		String orgName = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();

		/* Navigate to Organizations Page */
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Organizations Page");

		/* Navigate to Create New Organizations Page */
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Create New Organizations Page");

		/* Create organization */
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		/* Verify orgName */
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgHdrtxt = oip.getHeaderMsg().getText();
		boolean orgValue = actOrgHdrtxt.contains(orgName);
		Assert.assertTrue(orgValue);
		String actOrgName = oip.getOrgNameText().getText();
		Assert.assertEquals(actOrgName, "FF");
		UtilityClassObject.getTest().log(Status.PASS, "Successfully Created " + orgName + " Organization");
	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustryAndType() throws Throwable {
		String orgName = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcelFile("org", 4, 4);
		String type = eLib.getDataFromExcelFile("org", 4, 5);

		// Create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Organizations Page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Create New Organizations Page");

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		wLib.selectValueFromDropdown(cnop.getIndustryDD(), industry);
		wLib.selectValueFromDropdown(cnop.getTypeDD(), type);
		cnop.getSaveBtn().click();

		// Verify orgName
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgHdrtxt = oip.getHeaderMsg().getText();
		boolean orgValue = actOrgHdrtxt.contains(orgName);
		Assert.assertTrue(orgValue);
		String actOrgName = oip.getOrgNameText().getText();
		Assert.assertEquals(actOrgName, orgName);

		// Verify Industry
		String actIndustry = oip.getIndustryText().getText();
		Assert.assertEquals(actIndustry, industry);
		// Verify Type
		String actType = oip.getTypeText().getText();
		Assert.assertEquals(actType, type);
		UtilityClassObject.getTest().log(Status.PASS, "Successfully Created " + orgName + " Organization with "
				+ industry + " industry and " + type + " type");
	}

	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumber() throws Throwable {
		String orgName = eLib.getDataFromExcelFile("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcelFile("org", 7, 4);

		// Create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Organizations Page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to Create New Organizations Page");

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getPhoneEdt().sendKeys(phoneNumber);
		cnop.getSaveBtn().click();

		// Verify orgName
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgHdrtxt = oip.getHeaderMsg().getText();
		boolean orgValue = actOrgHdrtxt.contains(orgName);
		Assert.assertTrue(orgValue);
		String actOrgName = oip.getOrgNameText().getText();
		Assert.assertEquals(actOrgName, orgName);
		// Verify phoneNumber
		String actPhoneNumber = oip.getPhoneText().getText();
		Assert.assertEquals(actPhoneNumber, phoneNumber);
		UtilityClassObject.getTest().log(Status.PASS,
				"Successfully Created " + orgName + " Organization with " + phoneNumber + " Phone Number ");
	}
}
