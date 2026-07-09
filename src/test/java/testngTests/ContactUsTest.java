package testngTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClassTestng;
import pages.ContactusPage;
import utilities.ExcelReader;

public class ContactUsTest extends BaseClassTestng {

    private ContactusPage contactUs;

    @BeforeMethod(alwaysRun = true)
    public void initializeContactPage() {

        contactUs =
                new ContactusPage(driver);

        contactUs.clickContactUs();
    }
    
    
    @Test(priority = 1)
    public void verifyContactUsPage() {

        Assert.assertTrue(
                contactUs.isContactPageDisplayed(),
                "Contact page not displayed");

        Assert.assertTrue(
                contactUs.isGetInTouchVisible(),
                "Get In Touch not visible");
    }

    @Test(priority = 2)
    public void verifyFeedbackSection() {

        Assert.assertTrue(
                contactUs.isFeedbackisDisplayed(),
                "Feedback section not displayed");

        Assert.assertTrue(
                contactUs.isFeedbackEmailDisplayed(),
                "Feedback email not displayed");
    }
}

