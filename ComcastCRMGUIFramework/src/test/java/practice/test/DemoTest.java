package practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DemoTest {
	WebDriverUtility wLib = new WebDriverUtility();

	@Test
	public void scrolltest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.setImplicitWait(driver, 10);
		driver.get("https://www.fireflink.com/");

		wLib.waitUntilTitleContains(driver, "AI");
		WebElement ele = driver
				.findElement(By.xpath("//h3[text()=\"Begin Your Scriptless Automation Testing Journey Now!\"]"));

		wLib.scrollUntilElementIsMiddleOfPage(driver, ele);
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void TestDB() throws Throwable {
		DataBaseUtility db = new DataBaseUtility();
		db.getDbConnection();
		db.closeConnection();
	}
}
