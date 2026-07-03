package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import utilities.ExplicitWaitUtil;

public class LoginPage {

    WebDriver driver;
    private ExplicitWaitUtil waitUtil;

 // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new ExplicitWaitUtil(driver);
    }

    // Locators
    By signupLoginMenu = By.xpath("//a[contains(text(),'Signup / Login')]");//menu
    By emailField = By.xpath("//input[@data-qa='login-email']");//email field
    By passwordField = By.xpath("//input[@data-qa='login-password']");//passwordfield
    By loginButton = By.xpath("//button[@data-qa='login-button']");//login button
    By logoutButton = By.xpath("//a[contains(text(),'Logout')]");//logout button
    By loggedInUser = By.xpath("//a[contains(.,'Logged in as')]");//validating 
    By loginError = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");//validation
    By loginSection = By.xpath("//h2[text()='Login to your account']");//validation 

    // Click Signup/Login Menu
    public void clickSignupLogin() {
        waitUtil.waitForClickable(driver.findElement(signupLoginMenu)).click();
    }

    // Enter Login Email Address
    public void enterEmail(String email) {
        WebElement emailTxt =
                waitUtil.waitForVisibility(driver.findElement(emailField));

        emailTxt.clear();
        emailTxt.sendKeys(email);
    }

    // Enter Login Password
    public void enterPassword(String password) {
        WebElement passwordTxt =
                waitUtil.waitForVisibility(driver.findElement(passwordField));

        passwordTxt.clear();
        passwordTxt.sendKeys(password);
    }

    // Click Login Button
    public void clickLogin() {
        WebElement loginBtn =
                waitUtil.waitForClickable(
                        driver.findElement(loginButton));
        JavascriptExecutor js =
                (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                loginBtn);
        js.executeScript(
                "arguments[0].click();",
                loginBtn);
    }

    // Common Login Method
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    // Click Logout Button
    public void clickLogout() {
        waitUtil.waitForClickable(
                driver.findElement(logoutButton))
                .click();
    }

    // Verify Email Field Displayed
    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField)
                     .isDisplayed();
    }

    // Verify Password Field Displayed
    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField)
                     .isDisplayed();
    }

    // Verify Login Button Enabled
    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton)
                     .isEnabled();
    }

    // Verify Login Section Displayed
    public boolean isLoginSectionDisplayed() {
        return waitUtil
                .waitForVisibility(
                        driver.findElement(loginSection))
                .isDisplayed();
    }

    // Get Invalid Login Error Message
    public String getLoginErrorMessage() {
        try {
            WebElement error =
                    waitUtil.waitForVisibility(
                            driver.findElement(loginError));
            return error.getText();
        } 
        catch (Exception e) {
            return "";
        }
    }

    // Verify User Logged In Successfully
    public boolean isLoggedIn() {
        try {

            return waitUtil
                    .waitForVisibility(
                            driver.findElement(loggedInUser))
                    .isDisplayed();
        } 
        catch (Exception e) {
            return false;
        }
    }

    // Get Logged In User Text
    public String getLoggedInUserText() {
        return waitUtil
                .waitForVisibility(
                        driver.findElement(loggedInUser))
                .getText();
    }

    // Verify Logged In User Message
    public boolean verifyLoggedInUser(String expectedMessage) {
        String actualMessage =
                waitUtil.waitForVisibility(
                        driver.findElement(loggedInUser))
                        .getText();
        return actualMessage.equalsIgnoreCase(
                expectedMessage);
    }

}