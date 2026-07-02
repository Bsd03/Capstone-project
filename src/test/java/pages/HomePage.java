package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By logout=By.xpath("//a[@href='/logout']"); // logout button
	By delteAccount=By.xpath("//a[@href='/delete_account']"); //delete button
	By subscribe=By.id("susbscribe_email"); //subscribe section
	By subscribeButton=By.xpath("//*[@id=\"subscribe\"]/i");
	//Clicks logout button
	public void clickLogout() {
		driver.findElement(logout).click();
	}
	
	//Clicks delete account button
	public void clickDeleteAccount() {
		driver.findElement(delteAccount).click();
	}
	
	//Subscribes to updates
	public void Subscribe(String email) {
		Actions actions=new Actions(driver);
		actions.scrollToElement(driver.findElement(subscribe)).click();
		driver.findElement(subscribe).sendKeys(email);
		driver.findElement(subscribeButton).click();
	}

}
