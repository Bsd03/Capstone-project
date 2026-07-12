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
import pages.LoginPage;
import utilities.ExcelReader;
import utilities.Extentreport;

public class LoginTest extends BaseClass {

    private LoginPage loginPage;
    public static ExtentReports extent;
    public static ExtentTest test;

        @BeforeSuite
        public void setupReport() {

            extent = Extentreport.getReportInstance();

        }

    @BeforeMethod(alwaysRun = true)
    public void initializeLoginPage() {

    	
        System.out.println(
                "Opening Login Page directly");

        driver.get(
                "https://automationexercise.com/login");

        loginPage =
                new LoginPage(driver);

        System.out.println(
                "Login Page initialized successfully");
    }
    
    @DataProvider(name = "loginExcelData")
    public Object[][] loginExcelData() {

        return ExcelReader.getExcelData("LoginData");
    }
    
    @Test(dataProvider = "loginExcelData")
    public void verifyLoginUsingExcel(
            String email,
            String password,
            String expectedResult) {

    	 test = extent.createTest(
    	            "Verify Login Using Excel - " + email);

    	    test.info("Email: " + email);
    	    test.info("Expected Result: " + expectedResult);


        System.out.println("==========================");

        System.out.println(
                "Email from Excel: " + email);

        System.out.println(
                "Password from Excel: " + password);

        System.out.println(
                "Expected Result: " + expectedResult);

        loginPage.enterEmail(email);

        loginPage.enterPassword(password);

        loginPage.clickLogin();

        if (expectedResult.equalsIgnoreCase("Invalid")) {

            String actualMessage =
                    loginPage.getLoginErrorMessage();

            Assert.assertEquals(
                    actualMessage,
                    "Your email or password is incorrect!",
                    "Invalid login message mismatch");

            System.out.println(
                    "Invalid login verified successfully");
            test.pass("Invalid login verified successfully");

        } else if (
                expectedResult.equalsIgnoreCase("Valid")) {

            Assert.assertTrue(
                    loginPage.isLoggedIn(),
                    "Valid login failed");

            System.out.println(
                    "Valid login verified successfully");
            test.pass("Valid login verified successfully");

        } else {
        	 test.fail("Incorrect ExpectedResult in Excel");
            Assert.fail(
                    "Wrong ExpectedResult in Excel: "
                    + expectedResult);
        }
    }

    @Test(priority = 1)
    public void verifyLoginPageLoadsSuccessfully() {

    	 test = extent.createTest(
    	            "Verify Login Page Loads Successfully");

    	    test.info("Validating Login Page UI");

        Assert.assertTrue(
                loginPage.isLoginSectionDisplayed(),
                "Login section is not displayed");

        Assert.assertTrue(
                loginPage.isEmailFieldDisplayed(),
                "Email field is not displayed");

        Assert.assertTrue(
                loginPage.isPasswordFieldDisplayed(),
                "Password field is not displayed");

        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login button is not enabled");

        test.pass("Login page loaded successfully");

    }

    @Test(priority = 2)
    public void verifyValidLogin() {

test = extent.createTest(
            "Verify Valid Login");

    test.info("Entering valid credentials");


        loginPage.enterEmail(
                "iut@gmail.com");

        loginPage.enterPassword(
                "Afrin*123");

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "User login failed");

        test.pass("User logged in successfully");

    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {

        return new Object[][] {

            {
                "abc@gmail.com",
                "Test123"
            },

            {
                "rohinipitta@gmail.com",
                "Wrong123"
            },

            {
                "invalid@gmail.com",
                "Admin123"
            }
        };
    }
    
   
    @Test(
        priority = 3,
        dataProvider = "invalidLoginData"
    )
    public void verifyInvalidLogin(
            String email,
            String password) {

test = extent.createTest(
            "Verify Invalid Login - " + email);

    test.info("Testing invalid login");


        loginPage.enterEmail(email);

        loginPage.enterPassword(password);

        loginPage.clickLogin();

        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                "Your email or password is incorrect!",
                "Incorrect error message");

        test.pass("Invalid login validation successful");

    }

    @Test(priority = 4)
    public void verifyEmptyFieldsValidation() {

test = extent.createTest(
            "Verify Empty Fields Validation");

    test.info(
            "Clicking login without entering credentials");


        loginPage.clickLogin();

        String validationMessage =
                driver.switchTo()
                      .activeElement()
                      .getAttribute(
                              "validationMessage");

        Assert.assertNotNull(
                validationMessage,
                "Validation message is null");

        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Validation message not displayed");

        test.pass(
                   "Validation message displayed successfully");

    }

    @Test(priority = 5)
    public void verifyLogout() {

test = extent.createTest(
            "Verify Logout");

    test.info("Logging into application");


        loginPage.enterEmail(
                "iut@gmail.com");

        loginPage.enterPassword(
                "Afrin*123");

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "Login failed");

        loginPage.clickLogout();

        Assert.assertTrue(
                loginPage.isLoginSectionDisplayed(),
                "Login page not displayed after logout");

        test.pass(
                   "Logout completed successfully");

    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}