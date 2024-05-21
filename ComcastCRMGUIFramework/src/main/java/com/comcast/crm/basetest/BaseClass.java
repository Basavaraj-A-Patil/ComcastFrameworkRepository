package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

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

	public WebDriver driver = null;

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		System.out.println("Connect to DB");
		dbLib.getDbConnection();
	}

	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		// Launch Browser
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
		String url = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String username = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String password = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		// Logout
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(alwaysRun = true)
	public void congigAC() {
		// Close Browser
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void congigAS() throws Throwable {
		// Close DB connection
		dbLib.closeConnection();
	}

}
