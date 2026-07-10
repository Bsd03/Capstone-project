package testngTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite; 
import org.testng.annotations.BeforeSuite;  
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import base.BaseClassTestng;
import pages.SignUPPage;
import utilities.ExcelReader;
import utilities.Extentreport;

public class SignupTest extends BaseClassTestng {

    private SignUPPage signUpPage;
    private ExtentReports extent;
    private ExtentTest test;


@BeforeSuite
    public void setupReport() {

        extent = Extentreport.getReportInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void initializeSignupPage() {

        System.out.println(
                "Opening Signup/Login page directly");

        driver.get(
                "https://automationexercise.com/login");

        signUpPage =
                new SignUPPage(driver);

        System.out.println(
                "Signup Page initialized successfully");
    }
    
    @DataProvider(name = "signupExcelData")
    public Object[][] signupExcelData() {

        return ExcelReader.getExcelData("SignupData");
    }
    
    @Test(dataProvider = "signupExcelData")
    public void verifySignupUsingExcel(
            String name,
            String email,
            String password,
            String day,
            String month,
            String year,
            String firstName,
            String lastName,
            String company,
            String address,
            String country,
            String state,
            String city,
            String zipcode,
            String mobile) {
    	test = extent.createTest("Verify Signup Using Excel Data");

        System.out.println("Starting Excel Signup Test");

        String actualEmail;

        if (email.equalsIgnoreCase("AUTO")) {
            actualEmail = "rohini"
                    + System.currentTimeMillis()
                    + "@gmail.com";
        } else {
            actualEmail = email;
        }

        System.out.println("Email used: " + actualEmail);
        System.out.println("Day from Excel: " + day);
        System.out.println("Month from Excel: " + month);
        System.out.println("Year from Excel: " + year);

        // Initial signup
        signUpPage.enterUsername(name);
        signUpPage.EnterEmail(actualEmail);
        signUpPage.scrollSignupSection();
        signUpPage.clickSignupButton();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.urlContains("signup"));

        System.out.println("Account Information page displayed");

        // Keep this order only if it matches your working
        // verifyValidRegistration test
        signUpPage.AccountInfo(
                "Mrs",
                password,
                day,
                month,
                year
        );

        System.out.println("Account information entered");

        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterCompany(company);
        signUpPage.enterAddress(address);
        signUpPage.selectCountry(country);
        signUpPage.enterState(state);
        signUpPage.enterCity(city);
        signUpPage.enterZipcode(zipcode);
        signUpPage.enterMobileNumber(mobile);

        System.out.println("All Excel registration details entered");

        signUpPage.scrollCreateAccountSection();
        signUpPage.clickAccountButton();

        wait.until(ExpectedConditions.urlContains("account_created"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("account_created"),
                "Account was not created successfully"
        );

        System.out.println("Excel Signup Test Passed");
    }
    
    
    @Test(priority = 1)
    public void verifySignupSection() {
    	test = extent.createTest("Verify Signup Section");

        Assert.assertTrue(
                signUpPage.isSignupSectionDisplayed(),
                "Signup section is not displayed");

        Assert.assertTrue(
                signUpPage.isNameFieldDisplayed(),
                "Name field is not displayed");

        Assert.assertTrue(
                signUpPage.isSignupButtonEnabled(),
                "Signup button is not enabled");
        test.pass("Signup Section verified successfully");
    }

    @Test(priority = 2)
    public void verifyValidRegistration() {
    	test = extent.createTest("Verify Valid Registration");

        System.out.println(
                "Starting Valid Registration Test");

        signUpPage.enterUsername("Rohini");

        signUpPage.enterEmailRandom();

        signUpPage.clickSignupButton();

        Assert.assertTrue(
                signUpPage.isAccountInformationPageDisplayed(),
                "Account Information page was not displayed");

        System.out.println(
                "Account Information page displayed");

        signUpPage.AccountInfo(
                "Mrs",
                "Test@123",
                "10",
                "May",
                "2002"
        );

        signUpPage.enterFirstName(
                "Rohini");

        signUpPage.enterLastName(
                "Pitta");

        signUpPage.enterCompany(
                "ABC");

        signUpPage.enterAddress(
                "Hyderabad");

        signUpPage.selectCountry(
                "India");

        signUpPage.enterState(
                "Telangana");

        signUpPage.enterCity(
                "Hyderabad");

        signUpPage.enterZipcode(
                "506313");

        signUpPage.enterMobileNumber(
                "9876543210");

        System.out.println(
                "All registration details entered");

        signUpPage.scrollCreateAccountSection();

        signUpPage.clickAccountButton();

        System.out.println(
                "Create Account button clicked");

        System.out.println(
                "URL after Create Account: "
                + driver.getCurrentUrl());

        Assert.assertTrue(
                signUpPage.isAccountCreatedPageDisplayed(),
                "Account Created page was not displayed. Current URL: "
                + driver.getCurrentUrl());

        Assert.assertEquals(
                signUpPage.getCreatedMessage(),
                "ACCOUNT CREATED!",
                "Account created message mismatch");

        System.out.println(
                "Valid Registration Test Passed");
        test.pass("Valid Registration completed successfully");
    }

    @Test(priority = 3)
    public void verifyExistingEmailRegistration() {
    	test = extent.createTest("Verify Existing Email Registration");

        signUpPage.enterUsername(
                "Rohini");

        signUpPage.EnterEmail(
                "rohinipitta@gmail.com");

        signUpPage.clickSignupButton();

        Assert.assertEquals(
                signUpPage.getEmailExistsMessage(),
                "Email Address already exist!",
                "Existing email error message mismatch");
    
    test.pass("Existing Email validation verified successfully");
    }
    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmailData() {

        return new Object[][] {

            {"Rohini", "rohini"},

            {"Rohini", "rohini@"},

            {"Rohini", "abc.com"},

            {"Rohini", "@gmail.com"}
        };
    }

    @Test(
        priority = 4,
        dataProvider = "invalidEmails"
    )
    public void verifyInvalidEmailFormat(
            String name,
            String email) {
    	test = extent.createTest(
                "Verify Invalid Email Format : " + email);


        signUpPage.enterUsername(name);

        signUpPage.EnterEmail(email);

        signUpPage.clickSignupButton();

        WebElement emailField =
                driver.findElement(
                        By.xpath(
                            "//input[@data-qa='signup-email']"
                        )
                );

        String validationMessage =
                emailField.getAttribute(
                        "validationMessage");

        Assert.assertNotNull(
                validationMessage,
                "Validation message is null");

        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Email validation message not displayed");
        test.pass("Invalid email validation verified successfully");
    }

    @Test(priority = 5)
    public void verifyMandatoryFieldsEmpty() {
    	test = extent.createTest("Verify Mandatory Fields Empty");

        signUpPage.clickSignupButton();

        WebElement nameField =
                driver.findElement(
                        By.xpath(
                            "//input[@data-qa='signup-name']"
                        )
                );

        String validationMessage =
                nameField.getAttribute(
                        "validationMessage");

        Assert.assertNotNull(
                validationMessage,
                "Validation message is null");

        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Required validation message not displayed");
        test.pass("Mandatory field validation verified successfully");
    }

@AfterSuite
    public void flushReport() {

        if (extent != null) {
            extent.flush();
        }
    }

}