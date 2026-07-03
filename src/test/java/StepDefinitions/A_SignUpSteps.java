package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Hooks.Hooks;
import pages.SignUPPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class A_SignUpSteps {
	private static final Logger logger = LogManager.getLogger(A_SignUpSteps.class);
    WebDriver driver = Hooks.driver;
    SignUPPage signUpPage = new SignUPPage(driver);

    // Launches the browser (browser is opened in Hooks)
    @Given("the user launches the browser")
    public void the_user_launches_the_browser() {
    	logger.info("Launching browser");
    }

    // Opens the Automation Exercise website
    @Given("the user navigates to Automation Exercise Website")
    public void the_user_navigates_to_automation_exercise_website() {
    	 logger.info("Navigated to Automation Exercise Website");
    }

    // Verifies that the home page is displayed
    @Then("the Home page should be displayed successfully")
    public void the_home_page_should_be_displayed_successfully() {
    	 logger.info("Verifying Home Page");
    	Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
    }

    // Clicks on Signup/Login menu
    @When("the user clicks on the Signup \\/ Login menu")
    public void the_user_clicks_on_the_signup_login_menu() {
    	logger.info("Clicking Signup/Login menu");
    	signUpPage.ClickLogin();
    }

    // Verifies New User Signup section is displayed
    @Then("the New User Signup! section should be displayed")
    public void the_new_user_signup_section_should_be_displayed() {
    	logger.info("Verifying New User Signup section");
    	Assert.assertTrue(signUpPage.isSignupSectionDisplayed());
    }

    // Verifies Name field is displayed
    @Then("the Name field should be displayed")
    public void the_name_field_should_be_displayed() {
    	   logger.info("Verifying Name field");
        Assert.assertTrue(signUpPage.isNameFieldDisplayed());
    }

    // Verifies Signup button is enabled
    @Then("the Signup button should be enabled")
    public void the_signup_button_should_be_enabled() {
    	  logger.info("Verifying Signup button");
        Assert.assertTrue(signUpPage.isSignupButtonEnabled());
    }

    // Enters user name
    @When("the user enters Name {string}")
    public void the_user_enters_name(String name) {
    	 logger.info("Entering Name : " + name);
        signUpPage.enterUsername(name);
    }

    // Enters a random email address
    @And("the user enters a random Email Address")
    public void the_user_enters_a_random_email_address() {
    	 logger.info("Entering Random Email");
    	signUpPage.enterEmailRandom();
    }

    // Enters email address
    @And("the user enters Email Address {string}")
    public void the_user_enters_email_address(String email) {
    		logger.info("Entering Email : " + email);

    		signUpPage.EnterEmail(email);
    }

    // Clicks Signup button
    @And("the user clicks the Signup button")
    public void the_user_clicks_the_signup_button() {
    	 logger.info("Clicking Signup button");
    	 signUpPage.scrollSignupSection();
    	 signUpPage.clickSignupButton();
    }

    // Enters account information from DataTable
    @And("the user enters Account Information")
    public void the_user_enters_account_information(DataTable table) {
    	 logger.info("Entering Account Information");

        List<List<String>> data = table.asLists();

        signUpPage.AccountInfo(
                data.get(0).get(1),
                data.get(1).get(1),
                data.get(2).get(1),
                data.get(3).get(1),
                data.get(4).get(1));
    }

    // Enters address information from DataTable
    @And("the user enters Address Information")
    public void the_user_enters_address_information(DataTable table) {
    	logger.info("Entering Address Information");
        List<List<String>> data = table.asLists();

        signUpPage.enterFirstName(data.get(0).get(1));
        signUpPage.enterLastName(data.get(1).get(1));
        signUpPage.enterCompany(data.get(2).get(1));
        signUpPage.enterAddress(data.get(3).get(1));
        signUpPage.selectCountry(data.get(4).get(1));
        signUpPage.enterState(data.get(5).get(1));
        signUpPage.enterCity(data.get(6).get(1));
        signUpPage.enterZipcode(data.get(7).get(1));
        signUpPage.enterMobileNumber(data.get(8).get(1));
    }

    // Clicks Create Account button
    @And("the user clicks the Create Account button")
    public void the_user_clicks_the_create_account_button() {
    	logger.info("Clicking Create Account button");
    	
    	signUpPage.clickAccountButton();
    }

    // Verifies account is created
    @Then("the account should be created successfully")
    public void the_account_should_be_created_successfully() {
    	 logger.info("Verifying Account Creation");
    	Assert.assertTrue(driver.getCurrentUrl().contains("account_created"));
    }

    // Verifies ACCOUNT CREATED message
    @Then("the {string} message should be displayed")
    public void the_message_should_be_displayed(String message) {
    	 logger.info("Verifying Message : " + message);
    	Assert.assertEquals(signUpPage.getCreatedMessage(), message);
    }

    // Verifies email already exists error
    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String msg) {
        logger.info("Verifying Existing Email Error Message");
    	Assert.assertEquals(signUpPage.getEmailExistsMessage(), msg);
    }

    // Verifies browser validation for invalid email
    @Then("the appropriate email validation message should be displayed")
    public void the_appropriate_email_validation_message_should_be_displayed() {

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        logger.info("Verifying Email Validation Message");
        String validation = email.getAttribute("validationMessage");

        Assert.assertFalse(validation.isEmpty());

        System.out.println(validation);
    }

    // Clicks Signup button without entering Name and Email
    @When("the user clicks the Signup button without entering Name and Email")
    public void the_user_clicks_the_signup_button_without_entering_name_and_email() {
    	  logger.info("Clicking Signup without entering mandatory fields");
    	  signUpPage.scrollSignupSection();
    	  signUpPage.clickSignupButton();
    }

    // Verifies required field validation message
    @Then("the required field validation messages should displayed.")
    public void the_required_field_validation_messages_should_displayed() {

        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        logger.info("Verifying Mandatory Field Validation");
        String validation = name.getAttribute("validationMessage");

        Assert.assertFalse(validation.isEmpty());

        System.out.println(validation);
    }

}