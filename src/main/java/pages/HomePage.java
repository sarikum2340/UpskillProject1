package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import utils.Utils;

public class HomePage extends TestBase {
	Utils utils;
	public static By composeMail=By.xpath("//a[contains(text(),'Compose')]");
	public static By sendTo=By.xpath("//input[@class='select2-search__field']");
	public static By sendToMail=By.xpath("//ul//li[contains(text(),'naveen1 naveen1 (naveen100)')]");
	public static By subject=By.id("compose_message_title");
	public static By mailBody=By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p[1]");
	public static By sendButton=By.id("compose_message_compose");
	public static By alertbox=By.xpath("//div[@class='alert alert-success']");
	public static By listOfDynamicDropdown=By.xpath("//ul//li[@role='treeitem']");
	public HomePage(WebDriver driver)
	{
		super();
		utils=new Utils(driver);
		PageFactory.initElements(driver, this);
	}
	
}
