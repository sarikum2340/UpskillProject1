package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import utils.Utils;

public class RegistrationPage extends TestBase {
	Utils utils;
	public static By frstName= By.id("registration_firstname");
	public static By lastName=By.id("registration_lastname");
	public static By email=By.id("registration_email");
	public static By userName=By.id("username");
	public static By password=By.id("pass1");
	public static By confrmPassword=By.id("pass2");
	public static By phone=By.id("registration_phone");
	public static By language=By.className("filter-option");
	public static By code=By.id("registration_official_code");
	public static By skype=By.id("extra_skype");
	public static By linkdin=By.id("extra_linkedin_url");
	public static By register= By.id("registration_submit");
	public static By verifyRegistration=By.xpath("//div[@class='col-xs-12 col-md-12']//p[contains(text(),'Dear')]");
	public static By userProfile=By.xpath("//a[@class='dropdown-toggle']//img[@class='img-circle']");
	public static By emailVerification=By.xpath("(//div[@class='text-center']//p[1])[2]");
	public static By homePage=By.xpath("//a[contains(text(),'Homepage')]");
	public RegistrationPage(WebDriver driver){
	    super();
		PageFactory.initElements(driver, this);
		utils = new Utils(driver);
		}
	
	public HomePage clickOnHome(WebDriver driver)
	{
		try {
		utils.clickAndWait(homePage);
		return new HomePage(driver);
		
		}catch(NoSuchElementException e)
		{
			System.out.println("Home link npt present at this time");
		}
		return null;
		 
		
	}
	

}
