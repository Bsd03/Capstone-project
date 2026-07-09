package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactusPage;

public class H_ContactUsSteps {
	private static final Logger logger = LogManager.getLogger(H_ContactUsSteps.class);
	WebDriver driver=Hooks.driver;
    ContactusPage contactUs = new ContactusPage(driver);
    
    @Given("User launches browser")
    public void User_launches_browser(){
    		
    		logger.info("User launches browser");
    }

    @Given("User navigates to the Automation Exercise website")
    public void user_navigates_to_the_automation_exercise_website() {
    	
    		logger.info("User navigates to Automation Exercise website");
    }

    @When("User clicks Contact Us menu")
    public void user_clicks_contact_us_menu() {
    		logger.info("Clicking Contact Us menu");
        contactUs.clickContactUs();
        logger.info("Contact Us menu clicked successfully");
    }

    @Then("Contact Us page should be displayed")
    public void contact_us_page_should_be_displayed() {
    		logger.info("Verifying Contact Us page");
        Assert.assertTrue(contactUs.isContactPageDisplayed(),
                "Contact Us page is not displayed");
        logger.info("Contact Us page verified successfully");
    }

    @Then("Get In Touch section should be visible")
    public void get_in_touch_section_should_be_visible() {
    		logger.info("Verifying Get In Touch section");
        Assert.assertTrue(contactUs.isGetInTouchVisible(),
                "Get In Touch section is not visible");
        logger.info("Get In Touch section verified successfully");
    }

    @When("User enters name {string}")
    public void user_enters_name(String name) {
    		logger.info("Entering Name : {}", name);
        contactUs.enterName(name);
        logger.info("Name entered successfully");
    }

    @When("User enters email {string}")
    public void user_enters_email(String email) {
    		logger.info("Entering Email : {}", email);
        contactUs.enterEmail(email);
        logger.info("Email entered successfully");
    }

    @When("User enters subject {string}")
    public void user_enters_subject(String subject) {
    		logger.info("Entering Subject : {}", subject);
        contactUs.enterSubject(subject);
        logger.info("Subject entered successfully");
    }

    @When("User enters message {string}")
    public void user_enters_message(String message) {
    		logger.info("Entering Message");
        contactUs.enterMessage(message);
        logger.info("Message entered successfully");
    }

    @When("User uploads file")
    public void user_uploads_file() {

        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\sample.txt";
        logger.info("Uploading File : {}", filePath);
        contactUs.uploadFile(filePath);
        logger.info("File uploaded successfully");
    }

    @When("User clicks Submit button")
    public void user_clicks_submit_button() {
    		logger.info("Clicking Submit button");
        contactUs.clickSubmit();
        logger.info("Handling confirmation alert");
        // Handle confirmation alert
        contactUs.acceptAlert();
    }

    @Then("Success message should be displayed")
    public void success_message_should_be_displayed() {
    		logger.info("Verifying Success Message");
        Assert.assertTrue(contactUs.isSuccessMessageDisplayed(),
                "Success message is not displayed");
        logger.info("Success message verified successfully");
    }

    @Then("Feedback For Us section should be displayed")
    public void feedback_for_us_section_should_be_displayed() {
    		logger.info("Verifying Feedback For Us section");
        Assert.assertTrue(contactUs.isFeedbackisDisplayed(),
                "Feedback For Us section is not displayed");
        logger.info("Feedback For Us section verified successfully");
    }

    @Then("Feedback email should be visible")
    public void feedback_email_should_be_visible() {
    		logger.info("Verifying Feedback email");
        Assert.assertTrue(contactUs.isFeedbackEmailDisplayed(),
                "Feedback email is not displayed");
        logger.info("Feedback email verified successfully");
    }
}