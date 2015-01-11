package org.testng.homepage;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class HomePageLocators {

	private final static Properties homePageProperties = new PropertyManager()
			.loadPropertyFile("homepage.properties");

	static By lastNameLocator = By.id(homePageProperties
			.getProperty("lastNameLocator"));
	static By firstNameLocator = By.id(homePageProperties
			.getProperty("firstNameLocator"));
	static By address1Locator = By.id(homePageProperties
			.getProperty("address1Locator"));
	static By address2Locator = By.id(homePageProperties
			.getProperty("address2Locator"));
	static By cityLocator = By
			.id(homePageProperties.getProperty("cityLocator"));
	static By stateLocator = By.id(homePageProperties
			.getProperty("stateLocator"));
	static By zipcodeLocator = By.id(homePageProperties
			.getProperty("zipcodeLocator"));
	static By dropDown1Locator = By.id(homePageProperties
			.getProperty("dropDown1Locator"));
	static By dropDown2Locator = By.id(homePageProperties
			.getProperty("dropDown2Locator"));
	static By dropDown3Locator = By.id(homePageProperties
			.getProperty("dropDown3Locator"));
	static By dropDown4Locator = By.id(homePageProperties
			.getProperty("dropDown4Locator"));
	static By phoneAreaCodeLocator = By.id(homePageProperties
			.getProperty("phoneAreaCodeLocator"));
	static By phoneFirstThreeDigitsLocator = By.id(homePageProperties
			.getProperty("phoneFirstThreeDigitsLocator"));
	static By phoneLastFourDigitsLocator = By.id(homePageProperties
			.getProperty("phoneLastFourDigitsLocator"));
	static By emailLocator = By.id(homePageProperties
			.getProperty("emailLocator"));
	static By verifyEmailLocator = By.id(homePageProperties
			.getProperty("verifyEmailLocator"));
	static By submitButtonLocator = By.id(homePageProperties
			.getProperty("submitButtonLocator"));
	static By verificationMessageLocator = By.cssSelector(homePageProperties
			.getProperty("verificationMessageLocator"));
}
