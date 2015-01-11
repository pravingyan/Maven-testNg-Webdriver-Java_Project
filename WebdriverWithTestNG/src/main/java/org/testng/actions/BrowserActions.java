package org.testng.actions;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.driverinit.DriverInitialization;
import org.testng.propertymgr.PropertyManager;
import org.testng.utilities.Logg;
import org.testng.waits.WebDriverWaits;

public class BrowserActions {

	private WebDriver driver;
	private final Logger log = Logg.createLogger();
	private final Properties applicationProperty = new PropertyManager()
			.loadPropertyFile("application.properties");
	private final WebDriverWaits wait=new WebDriverWaits();
	
	protected void openURL() {
		try {
			driver=DriverInitialization.getDriver();
			driver.manage().window().setPosition(new Point(-10, 0));
			driver.manage().window().setSize(new Dimension(1400,570));
			
			
			log.info("Navigating to Application URL:"
					+ applicationProperty.getProperty("applicationURL"));
			driver.get(applicationProperty.getProperty("applicationURL"));
			driver.manage().window().maximize();
			log.info("Successfully navigated to the Application URL");
		} catch (Exception ex) {
			log.fatal("Error in navigating the URL:"
					+ applicationProperty.getProperty("applicationURL"));
			ex.printStackTrace();
			closeBrowser();
		}
	}

	protected void closeBrowser() {
		log.info("Closing the browser");
		driver.quit();
		DriverInitialization.resetDriver();
		log.info("Sucessfully closed the browser"+"\n");
	}

	protected void enterText(By element, String value) throws TimeoutException{
		wait.waitForElementVisibility(driver,element).sendKeys(value);
		log.info("Entered text:"+value+" in text box with locator:"+element);
	}

	protected void click(By element) throws TimeoutException{
		wait.waitForElementClickability(driver, element).click();
		log.info("Clicked on element with locator:"+element);
	}
	
	protected void submitForm(By element) throws TimeoutException{
		wait.waitForElementVisibility(driver,element).submit();
		log.info("Clicked on form submit button:"+element);
	}
	
	protected void selectFromDropDown(By element,String value){
		Select select=new Select(wait.waitForElementVisibility(driver,element));
		select.selectByVisibleText(value);
		log.info("Selected:"+value+" from drop-down with locator:"+element);
	}
	
	protected String getText(By element){
		log.info("Actual Value:"+wait.waitForElementVisibility(driver,element).getText());
		return wait.waitForElementVisibility(driver,element).getText();
		
	}
	
	protected String getTitle(){
		log.info("Title of the page:"+driver.getTitle());
		return driver.getTitle();
	}
	
	protected boolean compareExactText(String actual,String expected){
		log.info("Result of exact comparison is "+actual.equals(expected));
		return actual.equals(expected);
	}
	
	protected boolean comparePartialText(String actual,String expected){
		log.info("Result of partial comparison is "+actual.contains(expected));
		return actual.contains(expected);
	}
}
