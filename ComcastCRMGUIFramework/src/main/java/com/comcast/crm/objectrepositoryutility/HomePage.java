<<<<<<< HEAD
package com.comcast.crm.objectrepositoryutility;

/**
 * @author Basavaraj
 * This Page contains Home Page Elements and Logout()
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

	@FindBy(xpath = "//img[contains(@src,\"themes/softed/images/user\")]")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutlnk;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutlnk.click();
	}

}
=======
package com.comcast.crm.objectrepositoryutility;

/**
 * @author Basavaraj
 * This Page contains Home Page Elements and Logout()
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

	@FindBy(xpath = "//img[contains(@src,\"themes/softed/images/user\")]")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutlnk;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutlnk.click();
	}

}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
