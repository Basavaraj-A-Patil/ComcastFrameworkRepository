package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void setImplicitWait(WebDriver driver, int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}

	public WebDriverWait webDriverWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait;
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		webDriverWait(driver).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		webDriverWait(driver).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitTillElementInvisible(WebDriver driver, WebElement element) {
		webDriverWait(driver).until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementContainsExpectedText(WebDriver driver, WebElement element, String text) {
		webDriverWait(driver).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitUntilTitleContains(WebDriver driver, String title) {
		webDriverWait(driver).until(ExpectedConditions.titleContains(title));
	}
	
	public void waitUntilURLContains(WebDriver driver, String URL) {
		webDriverWait(driver).until(ExpectedConditions.urlContains(URL));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public Select handleDD(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}

	public void selectValueFromDropdown(WebElement element, String text) {
		handleDD(element).selectByVisibleText(text);
	}

	public void selectValueFromDropdown(WebElement element, int index) {
		handleDD(element).selectByIndex(index);
	}

	public void selectValueFromDropdownByValue(WebElement element, String value) {
		handleDD(element).selectByValue(value);
	}

	public boolean verifyDDIsMultiSelectDD(WebElement element) {
		boolean isMultiple = handleDD(element).isMultiple();
		return isMultiple;
	}

	public void deSelectValueFromDropdownByValue(WebElement element, String value) {
		handleDD(element).deselectByValue(value);
	}

	public void deSelectValueFromDropdownByVisibleText(WebElement element, String text) {
		handleDD(element).deselectByVisibleText(text);
	}

	public void deSelectValueFromDropdownByIndex(WebElement element, int index) {
		handleDD(element).deselectByIndex(index);
	}

	public void deSelectAllValueFromDropdown(WebElement element) {
		handleDD(element).deselectAll();
	}

	public WebElement getFirstSelectedOptionFromDropdown(WebElement element) {
		WebElement firstSelectedOption = handleDD(element).getFirstSelectedOption();
		return firstSelectedOption;
	}

	public List<WebElement> getAllOptionsFromDropdown(WebElement element) {
		List<WebElement> allOptions = handleDD(element).getOptions();
		return allOptions;
	}

	public List<WebElement> getAllSelectedOptionsFromDropdown(WebElement element) {
		List<WebElement> allSelectedOptions = handleDD(element).getAllSelectedOptions();
		return allSelectedOptions;
	}

	public Actions handleMousehoverActions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		handleMousehoverActions(driver).moveToElement(element).perform();
	}

	public void clickOnElement(WebDriver driver, WebElement element) {
		handleMousehoverActions(driver).click(element).perform();
	}

	public void doubleClickonElement(WebDriver driver, WebElement element) {
		handleMousehoverActions(driver).doubleClick(element).perform();
	}

	public void rightClickonElement(WebDriver driver, WebElement element) {
		handleMousehoverActions(driver).contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement targetElement) {
		handleMousehoverActions(driver).dragAndDrop(srcElement, targetElement);
	}

	public JavascriptExecutor javaScriptExecutorActions(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public void scrollUntilElementIsVisible(WebDriver driver, WebElement element) {
		javaScriptExecutorActions(driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollUntilElementIsMiddleOfPage(WebDriver driver, WebElement element) {
		javaScriptExecutorActions(driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", element);
	}
	
	public void scrollByValue(WebDriver driver, int scrollValue) {
		javaScriptExecutorActions(driver).executeScript("window.scrollBy(0," + scrollValue + ")");
	}

	public void scrollTo(WebDriver driver, int scrollValue) {
		javaScriptExecutorActions(driver).executeScript("window.scrollTo(0," + scrollValue + ")");
	}

	public void clickOnElementByUsingJS(WebDriver driver, WebElement element) {
		javaScriptExecutorActions(driver).executeScript("arguments[0].click();", element);
	}
	
	public void enterInputToElementUsingJS(WebDriver driver, WebElement element, Object value) {
		javaScriptExecutorActions(driver).executeScript("arguments[0].value = arguments[1];", element, value);
	}
	
	public boolean verifyTextOfElementEqualsExpectedText(WebElement element, String expectedText) {
		String actText = element.getText();
		if (actText.equalsIgnoreCase(expectedText)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTextOfElementContainsExpectedText(WebElement element, String expectedText) {
		String actText = element.getText();
		if (actText.contains(expectedText)) {
			return true;
		} else {
			return false;
		}
	}
}
