<<<<<<< HEAD
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\'Create Contact...\']")
	private WebElement createContactImg;

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

}
=======
package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\'Create Contact...\']")
	private WebElement createContactImg;

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
