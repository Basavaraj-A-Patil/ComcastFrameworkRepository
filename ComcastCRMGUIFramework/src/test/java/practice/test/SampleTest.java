package practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SampleTest {
	@Test
	public void test() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("http://localhost:8888/", "admin", "admin");

		WebDriverUtility wLib = new WebDriverUtility();
		Thread.sleep(2000);
		wLib.scrollTo(driver, 1000);
		Thread.sleep(2000);
		wLib.scrollByValue(driver, -500);
		Thread.sleep(2000);
	

		driver.quit();

	}
}
