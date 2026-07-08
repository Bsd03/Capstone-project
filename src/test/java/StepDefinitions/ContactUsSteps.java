package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactusPage;

public class ContactUsSteps {
	WebDriver driver=Hooks.driver;
    ContactusPage contactUs = new ContactusPage(driver);
    
    @Given("User launches browser")
    public void User_launches_browser(){
    	
    }

    @Given("User navigates to the Automation Exercise website")
    public void user_navigates_to_the_automation_exercise_website() {

    }

    @When("User clicks Contact Us menu")
    public void user_clicks_contact_us_menu() {
        contactUs.clickContactUs();
    }

    @Then("Contact Us page should be displayed")
    public void contact_us_page_should_be_displayed() {
        Assert.assertTrue(contactUs.isContactPageDisplayed(),
                "Contact Us page is not displayed");
    }

    @Then("Get In Touch section should be visible")
    public void get_in_touch_section_should_be_visible() {
        Assert.assertTrue(contactUs.isGetInTouchVisible(),
                "Get In Touch section is not visible");
    }

    @When("User enters name {string}")
    public void user_enters_name(String name) {
        contactUs.enterName(name);
    }

    @When("User enters email {string}")
    public void user_enters_email(String email) {
        contactUs.enterEmail(email);
    }

    @When("User enters subject {string}")
    public void user_enters_subject(String subject) {
        contactUs.enterSubject(subject);
    }

    @When("User enters message {string}")
    public void user_enters_message(String message) {
        contactUs.enterMessage(message);
    }

    @When("User uploads file")
    public void user_uploads_file() {

        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\sample.txt";

        contactUs.uploadFile(filePath);
    }

    @When("User clicks Submit button")
    public void user_clicks_submit_button() {

        contactUs.clickSubmit();

        // Handle confirmation alert
        contactUs.acceptAlert();
    }

    @Then("Success message should be displayed")
    public void success_message_should_be_displayed() {

        Assert.assertTrue(contactUs.isSuccessMessageDisplayed(),
                "Success message is not displayed");
    }

    @Then("Feedback For Us section should be displayed")
    public void feedback_for_us_section_should_be_displayed() {

        Assert.assertTrue(contactUs.isFeedbackisDisplayed(),
                "Feedback For Us section is not displayed");
    }

    @Then("Feedback email should be visible")
    public void feedback_email_should_be_visible() {

        Assert.assertTrue(contactUs.isFeedbackEmailDisplayed(),
                "Feedback email is not displayed");
    }
}