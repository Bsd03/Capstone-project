package StepDefinitions;
 
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
 
import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class B_LoginSteps {
	
	private static final Logger logger =
	        LogManager.getLogger(B_LoginSteps.class);
    WebDriver driver;
    LoginPage loginPage;
 
    // Browser Launch
    @Given("the login browser is launched successfully")
    public void the_login_browser_is_launched_successfully() {
 
        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
 
        logger.info("Login Browser Launched Successfully");
    }
    // Navigate URL
    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
 
        driver.get(url);
        loginPage = new LoginPage(driver);
 
        logger.info("Navigated To : {}", url);
        
    }
    // Verify Home Page
    @Then("the user should be redirected to the login home page")
    public void the_user_should_be_redirected_to_the_login_home_page() {
 
        Assert.assertTrue(
                driver.getTitle().contains("Automation Exercise"),
                "Home Page is not displayed");
 
        logger.info("Home Page Displayed Successfully");
    }
    // Click Login Menu
    @When("the user clicks on the login menu")
    public void the_user_clicks_on_the_login_menu() {
 
        loginPage.clickSignupLogin();
 
        logger.info("Login Menu Clicked");
    }
    // Verify Login Section
    @Then("the login section should be displayed")
    public void the_login_section_should_be_displayed() {
 
        Assert.assertTrue(
                loginPage.isLoginSectionDisplayed(),
                "Login Section is not displayed");
 
        logger.info("Login Section Displayed");
    }
    // Verify Email Field
    @Then("the login email address field should be displayed")
    public void the_login_email_address_field_should_be_displayed() {
 
        Assert.assertTrue(
                loginPage.isEmailFieldDisplayed(),
                "Login Email Field is not displayed");
 
        logger.info("Login Email Field Displayed");
    }
    // Verify Password Field
    @Then("the login password field should be displayed")
    public void the_login_password_field_should_be_displayed() {
 
        Assert.assertTrue(
                loginPage.isPasswordFieldDisplayed(),
                "Login Password Field is not displayed");
 
        logger.info("Login Password Field Displayed");
    }
    // Verify Login Button
    @Then("the login button should be enabled")
    public void the_login_button_should_be_enabled() {
 
        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login Button is disabled");
 
        logger.info("Login Button Enabled");
    }
    // Enter Login Email
    @When("the user enters login Email Address {string}")
    public void the_user_enters_login_email_address(String email) {
 
        loginPage.enterEmail(email);
 
        logger.info("Login Email : {}", email);
    }
    // Enter Login Password
    @When("the user enters login Password {string}")
    public void the_user_enters_login_password(String password) {
 
        loginPage.enterPassword(password);
 
        logger.info("Login Password Entered");
    }
 
    // Click Login Button
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
 
        loginPage.clickLogin();
 
        logger.info("Login Button Clicked");
    }
    // Verify Login Success
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
 
    	logger.info("Current URL : {}", driver.getCurrentUrl());
 
    	logger.info("Logged User : {}",
    	        loginPage.getLoggedInUserText());
        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "Login Failed");
    }
    // Verify Logged User Message
    @Then("the {string} login message should be displayed")
    public void the_login_message_should_be_displayed(String expectedMessage) {
 
        String actualMessage =
                loginPage.getLoggedInUserText();
 
        logger.info("Actual Message : {}", actualMessage);
 
        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Login Message Mismatch");
    }
    // Invalid Login Error
    @Then("the login error message {string} should be displayed")
    public void the_login_error_message_should_be_displayed(String expectedMessage) {
 
        String actualMessage =
                loginPage.getLoginErrorMessage();
 
        logger.error("Actual Error : {}", actualMessage);
 
        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Login Error Message Mismatch");
    }
    // Invalid Email Validation
    @Then("the appropriate login email validation message should be displayed")
    public void the_appropriate_login_email_validation_message_should_be_displayed() {
 
        String validationMessage =
                driver.switchTo()
                        .activeElement()
                        .getAttribute("validationMessage");
 
        logger.warn("Validation Message : {}",
                validationMessage);
 
        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Validation Message Not Displayed");
    }
    // Blank Login
    @When("the user clicks the login button without entering email address and password")
    public void the_user_clicks_the_login_button_without_entering_email_address_and_password() {
 
        loginPage.clickLogin();
    }
    // Required Field Validation
    @Then("the login required field validation messages should be displayed")
    public void the_login_required_field_validation_messages_should_be_displayed() {
 
        String validationMessage =
                driver.switchTo()
                        .activeElement()
                        .getAttribute("validationMessage");
 
        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Required Field Validation Not Displayed");
    }
    // Required Email Validation
    @Then("the required login email validation message should be displayed")
    public void the_required_login_email_validation_message_should_be_displayed() {
 
        String validationMessage =
                driver.switchTo()
                        .activeElement()
                        .getAttribute("validationMessage");
 
        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Email Validation Not Displayed");
    }
    // Required Password Validation
    @Then("the required login password validation message should be displayed")
    public void the_required_login_password_validation_message_should_be_displayed() {
 
        String validationMessage =
                driver.switchTo()
                        .activeElement()
                        .getAttribute("validationMessage");
 
        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Password Validation Not Displayed");
    }
    // Login For Logout Scenario
    @Given("the user is logged in successfully")
    public void the_user_is_logged_in_successfully() {
 
        loginPage.enterEmail("iut@gmail.com");
        loginPage.enterPassword("Afrin*123");
        loginPage.clickLogin();
 
        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "Login Failed");
    }
    // Logout
    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
 
        loginPage.clickLogout();
 
        logger.info("Logout Clicked");
    }
    // Verify Login Page After Logout
    @Then("the user should be navigated to the login page")
    public void the_user_should_be_navigated_to_the_login_page() {
 
        Assert.assertTrue(
                loginPage.isEmailFieldDisplayed(),
                "Login Page is not displayed");
 
        logger.info("Navigated To Login Page");
    }
}
 