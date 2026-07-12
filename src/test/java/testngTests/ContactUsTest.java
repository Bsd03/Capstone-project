package testngTests;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import pages.ContactusPage;
import utilities.ExcelReader;
import utilities.Extentreport;

public class ContactUsTest extends BaseClass {

    private ContactusPage contactUs;

public static ExtentReports extent;
public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        extent = Extentreport.getReportInstance();

    }


    @BeforeMethod(alwaysRun = true)
    public void initializeContactPage() {

        contactUs =
                new ContactusPage(driver);

        contactUs.clickContactUs();
    }
    
    
    @Test(priority = 1)
    public void verifyContactUsPage() {

    	test = extent.createTest("Verify Contact Us Page");

        test.info("Navigating to Contact Us page");


        Assert.assertTrue(
                contactUs.isContactPageDisplayed(),
                "Contact page not displayed");
        test.info("Contact page displayed");

        Assert.assertTrue(
                contactUs.isGetInTouchVisible(),
                "Get In Touch not visible");
        test.pass("Contact Us page verification completed");
    }

    @Test(priority = 2)
    public void verifyFeedbackSection() {

test = extent.createTest("Verify Feedback Section");

        test.info("Checking Feedback section");


        Assert.assertTrue(
                contactUs.isFeedbackisDisplayed(),
                "Feedback section not displayed");

        Assert.assertTrue(
                contactUs.isFeedbackEmailDisplayed(),
                "Feedback email not displayed");
        test.pass("Feedback section verified successfully");
    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}

