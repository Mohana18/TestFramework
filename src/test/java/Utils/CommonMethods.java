package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	public WebDriver driver;
	public void getScreenShot(){
		File Src = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File Des= new File("./Screenshots");
		try {
			FileHandler.copy(Src,Des);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void selectFromDrodownByIndex(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);

	}
	

	public void selectFromDrodownByValue(WebElement ele,String value)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);

	}
	public void selectFromDrodownByVisibleText(WebElement ele,String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);

	}
	public void moveToElement(WebElement ele){
		Actions action= new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	
	public static String GetPropertyValue(String v) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("./src/test/java/com/testdata/Testdata.properties");
		p.load(fis);
		String s=p.getProperty(v);
		return s;
		
		
	}
	



}
