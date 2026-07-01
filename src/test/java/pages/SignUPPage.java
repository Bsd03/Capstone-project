package pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPPage {
	WebDriver driver;
	Random random=new Random();
	//Constructor for WebDriver
	public SignUPPage(WebDriver driver) { 
		this.driver=driver;
	}
	By loginLink = By.xpath("//a[@href='/login']"); //login button
	By nameField=By.xpath("//input[@data-qa='signup-name']"); //username Field
	By emailField=By.xpath("//input[@data-qa='signup-email']"); //Email Field
    By signUpButton = By.xpath("//button[@data-qa='signup-button']"); //SignUp button
    By MrTitle=By.id("id_gender1"); //Title selection of Mr
    By MrsTitle=By.id("uniform-id_gender2"); //Title selction of Mrs
    By passwordField=By.id("password"); //Password field
    By dayDropdown=By.id("days"); //Selection of date
    By monthDropdown=By.id("months"); //Selection of month
    By yearDropdown=By.id("years"); //Selection of year
	By firstNameField=By.xpath("//input[@data-qa='first_name']"); //FirstName field
	By lastNameField=By.xpath("//input[@data-qa='last_name']"); //LastName field
	By companyField=By.xpath("//input[@data-qa='company']"); //Company field
	By addressField=By.xpath("//input[@data-qa='address']"); //Address field
	By countryDropdown=By.id("country"); //Selection of Country
	By stateField=By.id("state"); //State field
	By cityField=By.id("city"); //City field
	By zipcodeField=By.id("zipcode"); //zipcode field
	By mobileNumberField=By.id("mobile_number"); // Mobile number field
	By CreateAccountButton=By.xpath("//button[@data-qa='create-account']"); //Create Account button
	
	 public void clickLogin() {
	        driver.findElement(loginLink).click(); //clicks login button
	    }
	 
	 public void enterUsername(String name) {
			driver.findElement(nameField).sendKeys(name); //Enters name

	 }
	 //
	 public void enterEmailRandom(String email) {
			driver.findElement(emailField).sendKeys(email+random.nextInt(100)+"@gmail.com"); //Enters email with random integers at end

	 }
	 //
	 public void EnterEmail(String email) {
		 driver.findElement(emailField).sendKeys(email); //Enters email
	 }
	 public void signUpClick() {
			driver.findElement(signUpButton).click(); //clicks on signUp button

	 }
	//Method for Signing up of new user
	public void Signup(String name, String email) { 
		clickLogin();
		//Waits until the SignUp page is loaded
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		
		enterUsername(name);
		enterEmailRandom(email);
		
		signUpClick();
		
		
	}
	
	public void titleSelect(String Title) {
		if(Title=="Mr") {
			//If the title selected is Mr then clicks on Mr radio input.
			driver.findElement(MrTitle).click();
		}
		else if(Title=="Mrs"){
			//If the title selected is Mrs then clicks on Mrs radio input.
			driver.findElement(MrsTitle).click();
		}
		else {
			//If none of the valid input is selected then this message shows up in console.
			System.out.println("Enter a valid Title");
		}
		
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password); //Enters password

	}
	public void enterDOB(String date, String month, String year) {
		Select dateSelect=new Select(driver.findElement(dayDropdown)); //Select tag for Selecting the date
    	Select monthSelect=new Select(driver.findElement(monthDropdown)); //Select tag for Selecting the month
    	Select yearSelect=new Select(driver.findElement(yearDropdown)); //Select tag for Selecting the month
    	dateSelect.selectByValue(date); //Selects the desired date
    	monthSelect.selectByValue(month); //Selects the desired month
    	yearSelect.selectByValue(year); //Selects the desired year
		
	}
	
	//Method for filling Account Information
	public void AccountInfo(String Title,String password, String date, String month,String year) {
		//Explicit wait until the Account information page loads
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		titleSelect(Title); //Enters Title information
		enterPassword(password); //Enters password information
		enterDOB(date,month,year); //Enters Date of Birth information
	}
	//
	public void enterFirstName(String FirstName) {
		driver.findElement(firstNameField).sendKeys(FirstName); //Enters firstName

	}
	public void enterLastName(String LastName) {
		driver.findElement(lastNameField).sendKeys(LastName); //Enters lastName

	}
	public void enterCompany(String Company) {
		driver.findElement(companyField).sendKeys(Company); //Enters Company details

	}
	public void enterAddress(String Address) {
		driver.findElement(addressField).sendKeys(Address); //Enters address for billing and delivery

	}
	public void selectCountry(String Country) {
		Select select=new Select(driver.findElement(countryDropdown)); //Select tag for Country
		select.selectByValue(Country); //Selects the desired Country
	}
	public void enterState(String State) {
		driver.findElement(stateField).sendKeys(State); //Enters the state

	}
	public void enterCity(String City) {
		driver.findElement(cityField).sendKeys(City); //Enters the city

	}
	public void enterZipcode(String ZipCode) {
		driver.findElement(zipcodeField).sendKeys(ZipCode); //Enters the Zipcode

	}
	public void enterMobileNumber(String MobileNumber) {
		driver.findElement(mobileNumberField).sendKeys(MobileNumber); //Enters mobile number

	}
	public void clickAccountButton() {
		driver.findElement(CreateAccountButton).click(); //Clicks on Create Account button

	}
	//Method for filling address information
	public void AddressInfo(String FirstName, String LastName, String Company, String Address, String Country, String State, String City, String ZipCode, String MobileNumber) {
		enterFirstName(FirstName); //Enters FirstName
		enterLastName(LastName); //Enters LastName
		enterCompany(Company); //Enters Company name
		enterAddress(Address);  //Enters Address details
		selectCountry(Country); //Enters Country details
		enterState(State); //Enters State
		enterCity(City); //Enters City
		enterZipcode(ZipCode); //Enters ZipCode
		enterMobileNumber(MobileNumber); //Enters mobileNumber
		clickAccountButton(); //Clicks SignUp button
		
		
	}


}
