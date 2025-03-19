package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	WebDriver driver;
	WebDriverWait wait;
	// Explicit wait
	// element to be clickable -2 by locator,web element
	// visibility of element located
	// presence of element located-total 5
	// alert is present
	// Fluent

	/*
	 * public void waitForElementToBeVisible(WebElement element, int timeout) { wait
	 * = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	 * wait.until(ExpectedConditions.visibilityOf(element)); }
	 */

	/*
	 * // ElementToBeClickable using xpath locator public void
	 * waitForElementToBeClickable(int timeout, String locatorValue) { wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(timeout));
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	 * }
	 */

	public void waitForElementToBeClickableByXpathLocator(String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}

	public void waitForElementToBeClickableByIdLocator(String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}

	public void waitForElementToBeVisibleByElement(WebElement element, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeVisibleByXpathLocator(String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
	}

	public void waitForElementToBeVisibleByIdLocator(String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
	}

	public void waitForPrecenceOfElementByXpathLocator(String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
	}

	public void waitForPrecenceOfElementByIdLocator_Utility(String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
	}

	public void waitForAlert(int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void fluentWaitForElementtoBeClickableByXpathLocator(String locatorValue, int totalTimeOut,
			int pollingTimeOut) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}

	public void fluentWaitForElementtoBeClickableByIdLocator(String locatorValue, int totalTimeOut,
			int pollingTimeOut) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}
}
