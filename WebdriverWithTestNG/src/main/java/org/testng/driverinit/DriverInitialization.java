package org.testng.driverinit;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.propertymgr.PropertyManager;
import org.testng.utilities.Logg;

public class DriverInitialization {

	private static WebDriver driver = null;
	private static Logger log = Logg.createLogger();
	private static final Properties browserName = new PropertyManager()
			.loadPropertyFile("application.properties");

	public static WebDriver getDriver() {

		if (driver == null) {

			if ("IE".equals(browserName.getProperty("browser"))) {
				log.info("**Internet Explorer Browser**");
				System.setProperty("webdriver.ie.driver",
						"./Resources/Drivers/IEDriverServer.exe");
				log.info("Intantiating/Launching the Internet Explorer Browser");
				driver = new InternetExplorerDriver();
			} else if ("FF".equals(browserName.getProperty("browser"))) {
				log.info("**FireFox Browser**");
				log.info("Intantiating/Launching the FireFox Browser");
				driver = new FirefoxDriver();
			} else if ("CH".equals(browserName.getProperty("browser"))) {
				log.info("**Chrome Browser**");
				System.setProperty("webdriver.chrome.driver",
						"./Resources/Drivers/chromedriver.exe");
				log.info("Intantiating/Launching the Chrome Browser");
				driver = new ChromeDriver();
			}
		}
		log.info("Returning the instance of:" + driver.toString());
		return driver;
	}

	public static void resetDriver() {
		log.info("Resetting the instance of:" + driver.toString() + " to null");
		driver = null;
	}

}
