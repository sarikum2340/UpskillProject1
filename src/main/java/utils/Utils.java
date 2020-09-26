package utils;

import java.io.File;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;import pages.HomePage;
import testBase.TestBase;

public class Utils extends TestBase {

	WebDriverWait wait;
	public Utils(WebDriver driver){
		super();
		PageFactory.initElements(driver, this);

	}

	public WebElement getElement(By by)

	{
		return driver.findElement(by);
	}

	public void setText(By by, String s)

	{   driver.findElement(by).clear();
	    driver.findElement(by).sendKeys(s);
	}


	public void clickAndWait(By by) {
		WebElement element = driver.findElement(by);
		element.click();
		// Wait for page to render
		wait = new WebDriverWait(driver, 100);

	}
	
	public void waitForPageTOLoad(WebDriver driver) {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("return document.readyState").equals("complete"); 
	
	}
	
	public void waitForElement(By by)
	{
		
		WebDriverWait wait;
		try {
		wait= new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element not present");
		}
	}

}