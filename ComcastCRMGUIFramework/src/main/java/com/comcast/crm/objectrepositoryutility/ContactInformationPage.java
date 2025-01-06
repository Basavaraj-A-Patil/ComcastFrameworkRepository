<<<<<<< HEAD
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerTxt;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastnameTxt;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDateTxt;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDateTxt;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement orgNamelnk;
	
	public WebElement getHeaderTxt() {
		return headerTxt;
	}

	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getSupportStartDateTxt() {
		return supportStartDateTxt;
	}

	public WebElement getSupportEndDateTxt() {
		return supportEndDateTxt;
	}

	public WebElement getOrgNamelnk() {
		return orgNamelnk;
	}

}
=======
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerTxt;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastnameTxt;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDateTxt;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDateTxt;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement orgNamelnk;
	
	public WebElement getHeaderTxt() {
		return headerTxt;
	}

	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getSupportStartDateTxt() {
		return supportStartDateTxt;
	}

	public WebElement getSupportEndDateTxt() {
		return supportEndDateTxt;
	}

	public WebElement getOrgNamelnk() {
		return orgNamelnk;
	}

}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
