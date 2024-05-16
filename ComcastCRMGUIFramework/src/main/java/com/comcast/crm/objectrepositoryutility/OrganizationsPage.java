package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;

	@FindBy(name = "search_text")
	private WebElement serchEdt;

	@FindBy(name = "search_field")
	private WebElement searchDD;

	@FindAll({@FindBy(name = "search"),@FindBy(name = "submit")})
	private WebElement SearchNowBtn;

	public WebElement getSerchEdt() {
		return serchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

}
