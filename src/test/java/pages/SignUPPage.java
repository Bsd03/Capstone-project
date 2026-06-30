package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPPage {
	WebDriver driver;
	
	public SignUPPage(WebDriver driver) {
		this.driver=driver;
	}
	By loginLink = By.xpath("//a[@href='/login']");
	By nameField=By.xpath("//input[@data-qa='signup-name']");
	By emailField=By.xpath("//input[@data-qa='signup-email']");
    By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    By MrTitle=By.id("id_gender1");
    By MrsTitle=By.id("uniform-id_gender2");
    By passwordField=By.id("password");
    By dayDropdown=By.id("days");
    By monthDropdown=By.id("months");
    By yearDropdown=By.id("years");
	By firstNameField=By.xpath("//input[@data-qa='first_name']");
	By lastNameField=By.xpath("//input[@data-qa='last_name']");
	By companyField=By.xpath("//input[@data-qa='company']");
	By addressField=By.xpath("//input[@data-qa='address']");
	By countryDropdown=By.id("country");
	By stateField=By.id("state");
	By cityField=By.id("city");
	By zipcodeField=By.id("zipcode");
	By mobileNumberField=By.id("mobile_number");
	By CreateAccountButton=By.xpath("//button[@data-qa='create-account']");
	
	public void Signup(String name, String email) {
		driver.findElement(loginLink).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(signUpButton).click();
	}
	
	public void AccountInfo(String Title,String password, String date, String month,String year) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		
		if(Title=="Mr") {
			driver.findElement(MrTitle).click();
		}
		else if(Title=="Mrs"){
			driver.findElement(MrsTitle).click();
		}
		else {
			System.out.println("Enter a valid Title");
		}
		driver.findElement(passwordField).sendKeys("12345678");
		
		Select dateSelect=new Select(driver.findElement(dayDropdown));
    	Select monthSelect=new Select(driver.findElement(monthDropdown));
    	Select yearSelect=new Select(driver.findElement(yearDropdown));
    	dateSelect.selectByValue(date);
    	monthSelect.selectByValue(month);
    	yearSelect.selectByValue(year);
		
	}
	public void AddressInfo(String FirstName, String LastName, String Company, String Address, String Country, String State, String City, String ZipCode, String MobileNumber) {
		driver.findElement(firstNameField).sendKeys(FirstName);
		driver.findElement(lastNameField).sendKeys(LastName);
		driver.findElement(companyField).sendKeys(Company);
		driver.findElement(addressField).sendKeys(Address);
		Select select=new Select(driver.findElement(countryDropdown));
		select.selectByValue(Country);
		driver.findElement(stateField).sendKeys(State);
		driver.findElement(cityField).sendKeys(City);
		driver.findElement(zipcodeField).sendKeys(ZipCode);
		driver.findElement(mobileNumberField).sendKeys(MobileNumber);
		driver.findElement(CreateAccountButton).click();
	}


}
