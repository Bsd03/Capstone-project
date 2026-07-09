package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SignUPPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ******************** Locators ********************

    By loginLink = By.xpath("//a[@href='/login']");
    By signupHeading = By.xpath("//h2[text()='New User Signup!']");

    By nameField = By.xpath("//input[@data-qa='signup-name']");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    By mrTitle = By.id("id_gender1");
    By mrsTitle = By.id("id_gender2");

    By passwordField = By.id("password");

    By dayDropdown = By.id("days");
    By monthDropdown = By.id("months");
    By yearDropdown = By.id("years");

    By firstNameField = By.xpath("//input[@data-qa='first_name']");
    By lastNameField = By.xpath("//input[@data-qa='last_name']");
    By companyField = By.xpath("//input[@data-qa='company']");
    By addressField = By.xpath("//input[@data-qa='address']");

    By countryDropdown = By.id("country");

    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");

    By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    By homepageverify=By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h1");


    By continueButton=By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    By deleteAccount=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By accountDeletedMessage=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By emailExistsMessage = By.xpath("//p[text()='Email Address already exist!']");

public String getCurrentUrl(){
    return driver.getCurrentUrl();
}
    // Click Signup/Login menu
    public void ClickLogin() {
        driver.findElement(loginLink).click();
    }

    // Enter user name
    public void enterUsername(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    // Enter random email
    public void enterEmailRandom() {

        String email = "rohini" + System.currentTimeMillis() + "@gmail.com";

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);



    }


    // Enter email
    public void EnterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }



 // Scroll the Signup section upward
 // Scroll Signup button into view

    public void scrollSignupSection() {

        WebElement signupBtn = driver.findElement(signUpButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the Signup button to the center of the screen
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                signupBtn);

        // Wait for scrolling to complete
        wait.until(ExpectedConditions.visibilityOf(signupBtn));
    }




 // Click Signup button

    public void clickSignupButton() {

        WebElement signupBtn = driver.findElement(signUpButton);

        wait.until(ExpectedConditions.visibilityOf(signupBtn));

        try {

            // Normal Selenium click
            wait.until(ExpectedConditions.elementToBeClickable(signupBtn));
            signupBtn.click();

        } catch (Exception e) {

            // Fallback if the click is intercepted
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", signupBtn);
        }
    }
    // Complete Signup
    public void Signup(String name) {

        ClickLogin();

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));

        enterUsername(name);
        enterEmailRandom();

        clickSignupButton();
    }



    // Select title
    public void titleSelect(String title) {

        if (title.equalsIgnoreCase("Mr")) {
            driver.findElement(mrTitle).click();
        }

        else if (title.equalsIgnoreCase("Mrs")) {
            driver.findElement(mrsTitle).click();
        }

        else {
            System.out.println("Enter a valid Title");
        }
    }

    // Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Select Date of Birth
    public void enterDOB(String date, String month, String year) {

        Select day = new Select(driver.findElement(dayDropdown));
        Select monthSelect = new Select(driver.findElement(monthDropdown));
        Select yearSelect = new Select(driver.findElement(yearDropdown));

        day.selectByValue(date);
        monthSelect.selectByVisibleText(month);
        yearSelect.selectByValue(year);
    }

    // Fill Account Information
    public void AccountInfo(String title, String password,
                            String date, String month, String year) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        titleSelect(title);
        enterPassword(password);
        enterDOB(date, month, year);
    }


    // Enter First Name
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    // Enter Last Name
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // Enter Company
    public void enterCompany(String company) {
        driver.findElement(companyField).clear();
        driver.findElement(companyField).sendKeys(company);
    }

    // Enter Address
    public void enterAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    // Select Country
    public void selectCountry(String country) {

        Select select = new Select(driver.findElement(countryDropdown));

        // Select country using visible text
        select.selectByVisibleText(country);
    }

    // Enter State
    public void enterState(String state) {
        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(state);
    }

    // Enter City
    public void enterCity(String city) {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
    }

    // Enter Zipcode
    public void enterZipcode(String zipcode) {
        driver.findElement(zipcodeField).clear();
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }

    // Enter Mobile Number
    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).clear();
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }



    // Fill complete Address Information
    public void AddressInfo(String firstName,
                            String lastName,
                            String company,
                            String address,
                            String country,
                            String state,
                            String city,
                            String zipcode,
                            String mobileNumber) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress(address);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobileNumber(mobileNumber);


    }

    // Scroll Create Account button into view
    public void scrollCreateAccountSection() {

        WebElement signupBtn = driver.findElement(createAccountButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the Signup button to the center of the screen
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                signupBtn);

        // Wait for scrolling to complete
        wait.until(ExpectedConditions.visibilityOf(signupBtn));
    }
    // Click Create Account button
    public void clickAccountButton() {
        WebElement signupBtn = driver.findElement(createAccountButton);

        wait.until(ExpectedConditions.visibilityOf(signupBtn));

        try {

            // Normal Selenium click
            wait.until(ExpectedConditions.elementToBeClickable(signupBtn));
            signupBtn.click();

        } catch (Exception e) {

            // Fallback if the click is intercepted
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", signupBtn);
        }

    }

    //click on Continue Button
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
public String  VerifyHomePage(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(homepageverify));

       return driver.findElement(homepageverify).getText();

}
public void ClickonDeleteAccount(){
      driver.findElement(deleteAccount).click();

}
    public String AccountDeletedMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage));

        return msg.getText().trim();
    } // Verify Signup section is displayed
    public boolean isSignupSectionDisplayed() {
        return driver.findElement(signupHeading).isDisplayed();
    }

    // Verify Name field is displayed
    public boolean isNameFieldDisplayed() {
        return driver.findElement(nameField).isDisplayed();
    }

    // Verify Signup button is enabled
    public boolean isSignupButtonEnabled() {
        return driver.findElement(signUpButton).isEnabled();
    }

    // Get Account Created message
    public String getCreatedMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage));
        return driver.findElement(accountCreatedMessage).getText();
    }

    // Get Existing Email error message
    public String getEmailExistsMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailExistsMessage));
        return driver.findElement(emailExistsMessage).getText();
    }
    public void handleGoogleVignette(Runnable retryAction) {

        System.out.println("Current URL : " + driver.getCurrentUrl());

        if (driver.getCurrentUrl().contains("google_vignette")) {

            System.out.println("======================================");
            System.out.println("Google Vignette Advertisement Detected");
            System.out.println("Refreshing the current page...");

            driver.navigate().refresh();

            System.out.println("Page Refreshed Successfully");
            System.out.println("Re-clicking Category and Subcategory...");

            retryAction.run();

            System.out.println("Category and Subcategory Re-clicked Successfully");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            System.out.println("Google Advertisement Handled Successfully");
            System.out.println("======================================");

        } else {

            System.out.println("No Google Advertisement Detected");
        }
    }
}