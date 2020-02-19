package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath="//label[contains(text(),'Single')]")
	private WebElement cmbutton;
	@FindBy(css="[aria-label='Nationality (Citizenship)']")
	private WebElement nationality; 
	@FindBy(css="[id='titleDropdown_targetInput']")
	private WebElement title; 
	@FindBy(css="#titleDropdown_listboxitem0")
	private WebElement titleSelect; 

	@FindBy(css="[aria-describedby='firstName_validationErrorSpan']")
	private WebElement entername; 
	
	@FindBy(css="[aria-describedby='middleName_validationErrorSpan']")
	private WebElement middleName; 
	
	@FindBy(css="[aria-describedby='surName_validationErrorSpan']")
	private WebElement surname; 
	
	@FindBy(css="[aria-describedby='desktopInput_validationErrorSpan']")
	private WebElement dateofbirth; 
	
	
	@FindBy(css="[aria-describedby='placeOfBirth_validationErrorSpan']")
	private WebElement placeofbirth; 
	
	@FindBy(css="[aria-label='Country of birth']")
	private WebElement countyofbirth; 
	
	@FindBy(css="[aria-describedby='mobilePhoneInput_validationErrorSpan']")
	private WebElement MobileNumer; 
	
	@FindBy(css="[aria-describedby='emailAddress_validationErrorSpan']")
	private WebElement email; 
	
	@FindBy(css="[aria-describedby='mobilePhoneInput_validationErrorSpan']")
	private WebElement mobile;

	@FindBy(css="[aria-describedby='otherPhoneInput_validationErrorSpan']")
	private WebElement OtherPhoneNumer; 
	
	@FindBy(css="[aria-label='Enter address']")
	private WebElement EnterAddress; 

	@FindBy(css="[for='template-checkbox-sameAsResidential_checkbox']")
	private WebElement Residential; 
	
	@FindBy(css="label[for='greaterThanThree']")
	private WebElement GreaterThanThree; 
	
	@FindBy(css="#continueButton")
	private WebElement ContinueButton; 
	
	@FindBy(xpath = "//span[@class = 'error-message style-scope ing-radio-button-group']")
	private WebElement accountTypeErrorMessage;
	
	@FindBy(xpath = "//button[@id='proceedButton']")
	private WebElement proceedButton;
	
/*
	driver.findElement(By.cssSelector("[aria-describedby='otherPhoneInput_validationErrorSpan']")).sendKeys("0431231234");
	driver.findElement(By.cssSelector("[aria-label='Enter address']")).sendKeys("65 martin", Keys.DOWN,Keys.ENTER);
	
	driver.findElement(By.cssSelector("[for='template-checkbox-sameAsResidential_checkbox']")).click();
	
	driver.findElement(By.cssSelector("label[for='greaterThanThree']")).click();
	
	driver.findElement(By.cssSelector("label[for='taxResidencyYes']")).click();
	driver.findElement(By.cssSelector("[aria-describedby='securityQuestion_validationErrorSpan']")).sendKeys("maiden name");
	driver.findElement(By.cssSelector("#continueButton")).click();*/
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickSingle(){

		cmbutton.click();
	}
	public void selectcounty(String x) throws InterruptedException{
		Thread.sleep(3000);
		nationality.sendKeys(x,Keys.DOWN,Keys.ENTER);
	}
	public void SelectTitle(){

		title.click();
		titleSelect.sendKeys("mr",Keys.ENTER);
	}

	public void EnterName(String x)
		{
			entername.sendKeys(x);
		}
		
	public void middleName(String x)
			{
				middleName.sendKeys(x);
				
			}
	public void surName(String x)
				{
					surname.sendKeys(x);
					
				}
	public void dob(String x)
		{
			dateofbirth.sendKeys(x);
						
		}
	public void placeofbirth()
	{
		placeofbirth.sendKeys("Bangalore");
					
	}
	
	public void countyofbirth(String x) throws InterruptedException{
		Thread.sleep(3000);
		countyofbirth.sendKeys(x,Keys.DOWN,Keys.ENTER);
	}
	public void MobileNumer(String number)
	{
		MobileNumer.sendKeys(number);
					
	}
	public void email()
	{
		email.sendKeys("hh@gmail.com");
					
	}
	public void OtherPhoneNumer()
	{
		OtherPhoneNumer.sendKeys("0431231234");
					
	}
	
	public void EnterAddress() throws InterruptedException
	{
		EnterAddress.sendKeys("65 martin");
		Thread.sleep(4000);
		EnterAddress.sendKeys(Keys.DOWN,Keys.ENTER);
					
	}
	public void GreaterThanThree()
	{
		GreaterThanThree.click();;
					
	}
	public void ContinueButton()
	{
		/*JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,600)");*/
		ContinueButton.click();					
	}
	public String validateAccountType()
	{
		String errorMessage = accountTypeErrorMessage.getText();
		return errorMessage;
	}
	
	public boolean testIfProceedDisplayed()
	{
		return proceedButton.isDisplayed();
	}

}