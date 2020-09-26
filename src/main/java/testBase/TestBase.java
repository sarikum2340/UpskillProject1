package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	protected static final String PROPERTIES_FILE_PATH = "./SDETProjectUpkil.properties";
	protected static final String PROPERTIES_FILE_URL = "URL";
	protected static final String CHROME_PATH = "chrome";
	protected static final String GECKO_PATH = "firefox";
	protected static final String Screenshots_path	="screenshot";

	public TestBase() {
		
		try {
			InputStream file = new FileInputStream(new File(PROPERTIES_FILE_PATH));
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

	public void initialisation(String browser) {
		if(browser.trim().equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", prop.getProperty(CHROME_PATH));
		driver = new ChromeDriver();
		System.out.println("Launching Chorme browser");
		driver.manage().window().maximize();
		driver.get(prop.getProperty(PROPERTIES_FILE_URL));
		driver.navigate().refresh();
		}else if(browser.trim().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty(GECKO_PATH));
			driver = new FirefoxDriver();
			System.out.println("Launching Firefox browser");
			driver.manage().window().maximize();
			//driver.navigate().to(prop.getProperty(PROPERTIES_FILE_URL));
			
			driver.get(prop.getProperty(PROPERTIES_FILE_URL));
			driver.navigate().refresh();
		}else {
			System.out.println("Specify Valid browser name");
		}
	}


	public void pausePage(int durationInMillis) {
		try {
			Thread.sleep(durationInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void takeScreenShot(WebDriver driver) {

		try{
			File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			String Path=prop.getProperty(Screenshots_path)+"ScreenShot"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(screenshotAs,new File(Path));
		}
		catch(IOException e)
		{
			System.out.println("Error in taking screenshot");
		}

	}
		
	}

