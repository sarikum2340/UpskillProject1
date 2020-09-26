package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import utils.Utils;

public class LoginPage extends TestBase {
	
	Utils utils;
	By signUP = By.xpath("//a[contains(text(),' Sign up! ')]");
	public LoginPage(WebDriver driver)
	{
    super();
	PageFactory.initElements(driver, this);
	utils = new Utils(driver);
	}
	
	public RegistrationPage clickOnSignUP()
	{
		utils.clickAndWait(signUP);
		return new RegistrationPage(driver);
		
	}


}
