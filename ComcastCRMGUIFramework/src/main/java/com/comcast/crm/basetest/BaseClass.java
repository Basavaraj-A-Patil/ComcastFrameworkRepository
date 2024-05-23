package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	// object creation
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		Reporter.log("Connect to DB", true);
		dbLib.getDbConnection();
	}

	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		// Launch Browser
		Reporter.log("Launch Browser", true);
		String browser = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		// Login to Application
		Reporter.log("Login to App", true);
		String url = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String username = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String password = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
		LoginPage lp = new LoginPage(UtilityClassObject.getDriver());
		lp.loginToApp(url, username, password);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		// Logout
		Reporter.log("Logout from app", true);
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.logout();
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		// Close Browser
		Reporter.log("Close Browser", true);
		UtilityClassObject.getDriver().quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		// Close DB connection
		Reporter.log("Close DB connection", true);
		dbLib.closeConnection();
	}

}
