package ing.com.baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.xml.fastinfoset.sax.Properties;

import Utils.CommonMethods;

public class TestBase {
	public static WebDriver driver;
	public void startApp() throws IOException 
	{

		String browser=CommonMethods.GetPropertyValue("Browser");


		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver(); 
		} else if (browser.equalsIgnoreCase("IE")) {
			// code for IE browser
		}
		else 
		{	
			System.out.println("No suitable keyword found");
		} 
		
		String url=CommonMethods.GetPropertyValue("URL");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void quitBrowser()
	{
		driver.quit();
	}
}
