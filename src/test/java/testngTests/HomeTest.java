package testngTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

import utilities.Extentreport;

public class HomeTest extends BaseClass {

	private ExtentReports extent;
    private ExtentTest test;


    @BeforeSuite
       public void setupReport() {

           extent = Extentreport.getReportInstance();
       }

    @Test
    public void verifyHomePageDisplayed() {
    	test = extent.createTest("Verify Home Page Displayed");

        String title =
                driver.getTitle();

        System.out.println(
                "Actual Page Title: "
                + title);

        Assert.assertTrue(
                title.contains(
                        "Automation Exercise"),
                "Home page is not displayed");
        test.pass("Home page displayed successfully");
    }

    @AfterSuite
       public void flushReport() {

           if (extent != null) {
               extent.flush();
           }
       }

}