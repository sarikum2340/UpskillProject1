package stepDefinitions;

import java.awt.AWTException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import testBase.TestBase;
import utils.Utils;

public class TestSignUp extends TestBase {

	@Before
	public void setUp() {
		System.out.println("Getting the set UP ready");
	}

	@Given("I navigate to the application in browser {string}")
	public void i_navigate_to_the_application_in_browser(String string) {
		Utils util = new Utils(driver);
		initialisation(string);
		pausePage(100);
		util.takeScreenShot(driver);
	}

	@When("I click on sign UP")
	public void i_click_on_sign_up() {
		LoginPage login = new LoginPage(driver);
		Utils util = new Utils(driver);
		login.clickOnSignUP();
		util.waitForPageTOLoad(driver);
		util.takeScreenShot(driver);

	}

	@When("I Fill the registration form and click on register {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_fill_the_registration_form_and_click_on_register(String string, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10) {
		Utils util = new Utils(driver);
		util.getElement(RegistrationPage.frstName).sendKeys(string);
		util.getElement(RegistrationPage.lastName).sendKeys(string2);
		util.getElement(RegistrationPage.email).sendKeys(string3);
		String userName=string4+1;
		//System.out.println("username:  "+userName);
		util.getElement(RegistrationPage.userName).sendKeys(userName);
		util.getElement(RegistrationPage.password).sendKeys(string5);
		util.getElement(RegistrationPage.confrmPassword).sendKeys(string6);
		util.takeScreenShot(driver);
		util.getElement(RegistrationPage.phone).sendKeys(string7);
		// util.getElement(RegistrationPage.language).sendKeys(string);
		util.getElement(RegistrationPage.code).sendKeys(string8);
		util.getElement(RegistrationPage.skype).sendKeys(string9);
		util.getElement(RegistrationPage.linkdin).sendKeys(string10);
		util.takeScreenShot(driver);

	}

	@Then("I Verify user is registered successully")
	public void i_verify_user_is_registered_successully() {
		Utils util = new Utils(driver);
		// util.getElement(RegistrationPage.register).click();
		util.clickAndWait(RegistrationPage.register);
		// pausePage(60);
		String actualName = util.getElement(RegistrationPage.verifyRegistration).getText();
		Assert.assertTrue("FAIL: Registration Unsuccesful", actualName.contains("registered"));
		util.takeScreenShot(driver);
		System.out.println("PASS: Registration done succesfully");

	}

	@Then("I verify user's mail ID {string}")
	public void i_verify_user_s_mail_id(String string) {
		Utils util = new Utils(driver);

		util.clickAndWait(RegistrationPage.userProfile);
		String actualEmailtext = util.getElement(RegistrationPage.emailVerification).getText().trim();
		util.takeScreenShot(driver);
		Assert.assertEquals("FAIL: Email does not match", string.trim(), actualEmailtext);
		System.out.println("PASS :Mail Verified " + actualEmailtext);

	}

	@Then("I Click on Home page")
	public void i_click_on_home_page() {
		RegistrationPage register = new RegistrationPage(driver);
		register.clickOnHome(driver);
	}

	@Then("I Compose mail and send to one user {string}")
	public void i_compose_mail_and_send_to_one_user(String string) throws AWTException, InterruptedException {
		Actions action= new Actions(driver);
		Utils util = new Utils(driver);
		util.clickAndWait(HomePage.composeMail);
		pausePage(300);
		//util.getElement(HomePage.sendTo).click();
		util.getElement(HomePage.sendTo).sendKeys(string);
		pausePage(4000);
		util.waitForElement(HomePage.listOfDynamicDropdown);
		action.moveToElement(util.getElement(HomePage.sendToMail)).build().perform();
		action.click(util.getElement(HomePage.sendToMail)).build().perform();	
		util.getElement(HomePage.subject).sendKeys("Upskill project submission");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement sendButton=util.getElement( HomePage.sendButton);
		jse.executeScript("arguments[0].scrollIntoView(true);",sendButton);
		util.clickAndWait(HomePage.sendButton);
		pausePage(100);
		util.takeScreenShot(driver);

	}

	@Then("I verify sent message")
	public void i_verify_sent_message() {
		Utils util = new Utils(driver);
		String alertMessage = util.getElement(HomePage.alertbox).getText().trim();
		Assert.assertTrue("FAIL:Mail not sent", alertMessage.contains("The message has been sent to"));
		System.out.println("PASS: Mail Sent Sucessfully");
	}

	@After
	public void tearDown()
	{
		System.out.println("Quiting Driver");
		driver.quit();
	}
}
