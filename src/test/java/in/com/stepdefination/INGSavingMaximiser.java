package in.com.stepdefination;

import java.io.IOException;

import ing.com.baseclass.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;

//import cucumber.table.Datatable;
public class INGSavingMaximiser extends TestBase {

	@Given("Launch the given URL")
	public void launch_the_given_URL() throws IOException {
		startApp();
		System.out.println("url launch suceessfully");

	}

	@When("Navigate to new Customer form in Savings Maximiser")
	public void navigate_to_new_Customer_form_in_Savings_Maximiser(DataTable dt) throws InterruptedException {
		/*
		 * WebElement bankAndSave =
		 * driver.findElement(By.xpath("(//div[@class='title-container'])[1]"));
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(bankAndSave));
		 * bankAndSave.click(); driver.findElement(By.
		 * xpath("//*[contains(text(), 'Personal Savings')]")).click();
		 * driver.findElement(By.xpath(
		 * "//*[@id='menu-personal-savings']/ul/li[2]/a/div/p")).click();
		 * driver.findElement(By.xpath("//*[contains(text(), 'Open now')]")).
		 * click(); driver.findElement(By.linkText("New customer")).click();
		 */
		System.out.println("Navigate to new customer page");

	}

	@When("Fill the form")
	public void fill_the_form() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickSingle();
		home.selectcounty("India");
		home.SelectTitle();
		home.EnterName("name");
		home.middleName("middle name");
		home.surName("sur name");
		home.dob("02/05/1980");
		home.placeofbirth();
		home.countyofbirth("India");
		home.OtherPhoneNumer();
		home.email();
		home.EnterAddress();
		home.ContinueButton();
		System.out.println("aaaaaaaaaa");
	}

	@Then("Form should be submitted successfully.")
	public void form_should_be_submitted_successfully() {
		HomePage home = new HomePage(driver);
		home.testIfProceedDisplayed();
		//quitBrowser();
	}

	@Given("Launch the Customer add page URL")
	public void launch_the_Customer_add_page_URL() throws IOException {
		startApp();
		System.out.println("url launched");

	}

	@When("Without filling any data click on continue")
	public void without_filling_any_data_click_on_continue() {
		HomePage home = new HomePage(driver);
		home.ContinueButton();
	}

	@Then("Form should not  be submitted and show the validation messages")
	public void form_should_not_be_submitted_and_show_the_validation_messages() {
		HomePage home = new HomePage(driver);

		String errorMessage = home.validateAccountType();
		System.out.println("Error message: " + errorMessage);

		Assert.assertEquals("Please select", errorMessage);
	}

	@Given("Launch the browser with given URL")
	public void launch_the_browser_with_given_URL() throws IOException {
      startApp();
	}

	@When("Give the invalid mobile number")
	public void give_the_invalid_mobile_number() {

	}

	@Then("Form should not  get submitted and throw the error message")
	public void form_should_not_get_submitted_and_throw_the_error_message() {

	}

}
