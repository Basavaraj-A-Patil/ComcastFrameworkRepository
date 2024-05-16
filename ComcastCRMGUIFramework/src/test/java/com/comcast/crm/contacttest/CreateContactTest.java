package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Throwable {
		String lastName = eLib.getDataFromExcelFile("contact", 1, 2);

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactImg().click();

		// Create Contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName);

		// Verify Contact Name
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actHeaderText = cip.getHeaderTxt().getText();

		boolean headerValue = actHeaderText.contains(lastName);
		Assert.assertTrue(headerValue);
		String actLastName = cip.getLastnameTxt().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithDate() throws Throwable {
		String lastName = eLib.getDataFromExcelFile("contact", 1, 2);
		String startDate = jLib.getSystemDateInSpecifiedFormat("yyyy-MM-dd");
		String endDate = jLib.getRequiredDateInSpecifiedFormat("yyyy-MM-dd", 30);

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactImg().click();

		// create contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnameEdt().sendKeys(lastName);
		cncp.getSupportStartDateEdt().clear();
		cncp.getSupportStartDateEdt().sendKeys(startDate);
		cncp.getSupportEndDateEdt().clear();
		cncp.getSupportEndDateEdt().sendKeys(endDate);
		cncp.getSaveBtn().click();

		// Verify Contact Name
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actHeaderText = cip.getHeaderTxt().getText();
		boolean headerValue = actHeaderText.contains(lastName);
		Assert.assertTrue(headerValue);
		String actLastName = cip.getLastnameTxt().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		// Verify Support Start Date
		String actStartDate = cip.getSupportStartDateTxt().getText();
		Assert.assertEquals(actStartDate, startDate);
		// Verify Support End Date
		String actEndDate = cip.getSupportEndDateTxt().getText();
		Assert.assertEquals(actEndDate, endDate);

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable {
		String lastName = eLib.getDataFromExcelFile("contact", 1, 2);
		String orgName = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();

		// Create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		Thread.sleep(2000);
		wLib.waitForElementClickable(driver, hp.getContactLink());
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactImg().click();

		// create contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnameEdt().sendKeys(lastName);
		wLib.waitForElementClickable(driver, cncp.getOrgNameSelectImg());
		cncp.getOrgNameSelectImg().click();

		wLib.switchToTabOnURL(driver, "module=Accounts");
		op.getSerchEdt().sendKeys(orgName);
		wLib.waitForElementClickable(driver, op.getSearchNowBtn());
		op.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wLib.switchToTabOnURL(driver, "module=Contacts");
		cncp.getSaveBtn().click();

		// Verify Contact Name
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actHeaderText = cip.getHeaderTxt().getText();
		boolean headerValue = actHeaderText.contains(lastName);
		Assert.assertTrue(headerValue);
		String actLastName = cip.getLastnameTxt().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);

		// Verify orgName
		String actOrgName = cip.getOrgNamelnk().getText();
		Assert.assertEquals(actOrgName, orgName);
	}
}
