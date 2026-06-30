package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    //Constructor for Webdriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    By emailField = By.xpath("//input[@data-qa='login-email']"); //For finding Email field
    By passwordField = By.xpath("//input[@data-qa='login-password']"); //for finding password field
    By loginButton = By.xpath("//button[@data-qa='login-button']"); //for finding login button

    //Method for entering Email details
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);//Enters Email detials
    }
    //Method for entering password details
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password); //Enters password detaild
    }
    //Method for clicking login button
    public void clickLogin() {
        driver.findElement(loginButton).click(); //clicks login button
    }
    //Method for entering login details
    public void login(String email, String password) {
        enterEmail(email); //Enters email details
        
        enterPassword(password); //Enters password details
        
        clickLogin(); //Clicks on login button
    }
}