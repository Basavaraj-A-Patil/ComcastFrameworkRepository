<<<<<<< HEAD
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDateEdt;
	
	@FindBy(xpath="//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orgNameSelectImg;

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public WebElement getOrgNameSelectImg() {
		return orgNameSelectImg;
	}
	
	public void createContact(String lastName) {
		lastnameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
}
=======
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDateEdt;
	
	@FindBy(xpath="//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orgNameSelectImg;

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public WebElement getOrgNameSelectImg() {
		return orgNameSelectImg;
	}
	
	public void createContact(String lastName) {
		lastnameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
