package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class SeleniumHelpers
{
	WebDriver driver;

	public SeleniumHelpers(WebDriver driver)
	{
		this.driver = driver;
	}

	//Navigation
	public void navigateToPage(String url)
	{
		driver.get(url);
	}

	/**
	 * Click on Element
	 * @param e WebElement object
	 */
	public void click(WebElement e) throws InterruptedException
	{
		e.click();
	}

	/**
	 * Enter text to input field
	 * @param element WebElement object
	 * @param text input text
	 * @param clear set true if want to clear field else set false
	 */
	public void enterText (WebElement element, String text, boolean clear) {
		element = waitUntilElementToBeClickable(element);
		if(clear)
		{
			element.clear();
		}
		element.sendKeys(text);
	};


	/**
	 * Waiting before performing next action
	 * @param seconds convert millisecond to seconds
	 * @throws InterruptedException
	 */
	public void hardWait(int seconds) throws InterruptedException
	{
		Thread.sleep(seconds * 1000);
	}

	/**
	 * Click on Element with JS
	 * @param e WebElement object
	 */
	public void javascriptClickOn(WebElement e)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
	}

	/**
	 * Method to handle switch window
	 */
	public Set<String> getWindowHandles()
	{
		return driver.getWindowHandles();
	}

	/**
	 * @param tabNumber position tab
	 */
	public void switchToWindow(int tabNumber)
	{
		int i = 1;
		for (String winHandle : getWindowHandles())
		{
			driver.switchTo().window(winHandle);
			if (i == tabNumber)
				break;
			i++;
		}
	}

	//Page scrolls
	public WebElement pageScrollInView(WebElement e)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",e);
		return e;
	}

	/**
	 * Verify element is displayed
	 * @param element WebElement object
	 * @return boolean
	 */
	public Boolean isElementDisplayed(WebElement element)
	{
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	/**
	 * Get Text from field
	 * @param e WebElement object
	 * @return text from field
	 */
	public String getText(WebElement e)
	{
		return e.getText().trim();
	}

	public WebElement waitUntilElementToBeClickable (WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}






}






