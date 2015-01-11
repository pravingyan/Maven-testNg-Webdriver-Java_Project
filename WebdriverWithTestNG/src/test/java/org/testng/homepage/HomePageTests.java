package org.testng.homepage;


import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.actions.BrowserActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.utilities.ExcelRead;
import org.testng.utilities.Logg;
import org.testng.utilities.Reporter;
import static  org.testng.homepage.HomePageLocators.*;

public class HomePageTests extends BrowserActions {

	private final Logger log = Logg.createLogger();
	private Reporter report = null;

	@DataProvider(name = "ReadExcel")
	public String[][] readDataFromExcel() {
		String[][] str = ExcelRead.readTestData();
		return str;
	}

	@Test(dataProvider = "ReadExcel")
	public void verifySuccessfullRegistration(String lastNameValue,
			String firstName, String address1, String address2, String city,
			String state, String zipCode, String underGradProgOfInterest,
			String underGradCertOfInterest, String gradProgOfInterest,
			String gradCertOfInterest, String phoneNumber, String email,
			String verifyEmail, String verificationMessagePhoneNumber) {

		try {
			enterText(lastNameLocator, lastNameValue);
			enterText(firstNameLocator, firstName);
			enterText(address1Locator, address1);
			enterText(address2Locator, address2);
			enterText(cityLocator, address2);
			enterText(stateLocator, address2);
			enterText(zipcodeLocator, zipCode);

			selectFromDropDown(dropDown1Locator, underGradProgOfInterest);

			selectFromDropDown(dropDown2Locator, underGradCertOfInterest);
			selectFromDropDown(dropDown3Locator, gradCertOfInterest);
			selectFromDropDown(dropDown4Locator, gradProgOfInterest);

			enterText(phoneAreaCodeLocator, phoneNumber.substring(0, 3));
			enterText(phoneFirstThreeDigitsLocator, phoneNumber.substring(3, 6));
			enterText(phoneLastFourDigitsLocator, phoneNumber.substring(6));

			enterText(emailLocator, email);
			enterText(verifyEmailLocator, verifyEmail);

			submitForm(lastNameLocator);

			String actualText = getText(verificationMessageLocator);
			Assert.assertTrue(comparePartialText(actualText,
					verificationMessagePhoneNumber));
			report.sendStatusToReport(1, "Registration Page", "TC2",
					"Verify Successfull Registration", "Pass", "NA");	
		
		} catch (TimeoutException tm) {
			report.sendStatusToReport(1, "Registration Page", "TC2",
					"Verify Successfull Registration", "Fail",
					tm.getLocalizedMessage());
			log.fatal("Time Out Exception in the test case" + "\n"
					+ tm.getLocalizedMessage());
			tm.printStackTrace();
		} catch (AssertionError as) {
			report.sendStatusToReport(1, "Registration Page", "TC2",
					"Verify Successfull Registration", "Fail", as.getMessage());
			Assert.fail(as.getMessage());
		}
	}

	@Test
	@Parameters("homePageTitle")
	public void verifyPageTitle(String pageTitle) {
		try {
			System.out.println("from parameter---"+pageTitle);
			Assert.assertEquals(getTitle(), pageTitle);
			report.sendStatusToReport(1, "Registration Page", "TC1",
					"Verify Page Title", "Pass", "NA");
		} catch (AssertionError as) {
			report.sendStatusToReport(1, "Registration Page", "TC1",
					"Verify Page Title", "Fail", as.getMessage());
			Assert.fail(as.getMessage());
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		openURL();
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}

	@BeforeTest
	public void beforeTest() {
		report = new Reporter();
		report.generateReport();
	}
}
