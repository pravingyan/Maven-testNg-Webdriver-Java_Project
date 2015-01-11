package org.testng.waits;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.utilities.Logg;

public class WebDriverWaits {

	private int timeOut = 30;
	private Logger log=Logg.createLogger();
	
	public WebElement waitForElementVisibility(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			WebElement element=null;
			log.info("Waiting for the visibility of the element:"+locator);
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			element= wait.until(ExpectedConditions
					.visibilityOfElementLocated(locator));
			log.info("WebElement Visible. Proceedign further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the visibility of the element:"+locator+"\n");
		}
	}

	public WebElement waitForElementClickability(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			WebElement element=null;
			log.info("Waiting for the clickability of the element:"+locator);
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			element=wait.until(ExpectedConditions.elementToBeClickable(locator));
			log.info("WebElement Visible. Proceedign further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the clickability of the element:"+locator+"\n");
		}
	}
	
	public void waitForTimePeriod(int timeOut){
		try {
			log.info("Thread.sleep activated for "+timeOut/1000+" seconds");
			Thread.sleep(timeOut);
			log.info("Ended after waiting for "+timeOut/1000+" seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
