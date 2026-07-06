package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExplicitWaitUtil;

import java.time.Duration;

public class CategoryPage {
	
	//Declare WebDriver object
		WebDriver driver;

		//Constructor to initialize PageFactory elements
		public CategoryPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//WebElements - Categories
		
		//Women category
		@FindBy(xpath=
				"(//span[contains(@class,'badge') and contains(@class,'pull-right')])[1]")
		WebElement womenCategory;
		
		//Dress sub-category
		@FindBy(xpath=
				"//div[@id='Women']//a[normalize-space()='Dress']") WebElement dress;
		//Tops sub-category
		@FindBy(xpath="//*[@id=\"Women\"]/div/ul/li[2]/a") WebElement Tops;
		//Saree sub-category
		@FindBy(xpath="//*[@id=\"Women\"]/div/ul/li[3]/a") WebElement Saree;
		
		//Men category
		@FindBy(xpath=
				"(//span[contains(@class,'badge') and contains(@class,'pull-right')])[2]") 
		WebElement MenCategory;
		//Tshirt subcategory
		@FindBy(xpath="//*[@id=\"Men\"]/div/ul/li[1]/a") WebElement tshirt;
		//Jeans subcategory
		@FindBy(xpath="//*[@id=\"Men\"]/div/ul/li[2]/a") WebElement Jeans;
		
		//Kids category
		@FindBy(xpath=
				"(//span[contains(@class,'badge') and contains(@class,'pull-right')])[3]") 
		WebElement KidsCategory;
		//Dress sub-category (Kids)
		@FindBy(xpath=
				"//*[@id=\"Kids\"]/div/ul/li[1]/a") WebElement KidsDress;
		//Tops&Shirts sub-category
		@FindBy(xpath="//*[@id=\"Kids\"]/div/ul/li[2]/a") WebElement TopsForKids;
		
		//Brand page title
		@FindBy(xpath="/html/body/section/div/div[2]/div[2]/div/h2") WebElement brandTitle;
//google add
public void handleGoogleVignette() {

	System.out.println("Current URL Before Back: "
			+ driver.getCurrentUrl());

	if (driver.getCurrentUrl().contains("google_vignette")) {

		System.out.println("Google vignette detected");

		driver.navigate().back();

		System.out.println("Current URL After Back: "
				+ driver.getCurrentUrl());

		driver.switchTo().defaultContent();
	}
}
	//Action Methods
		
		//Click on Women Category
		public void click_Women_Category() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", womenCategory);



		}
		//Click on Dress sub-category
		public void click_Dress_Category() {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(dress)).click();

		}
		//Click on Tops sub-category
		public void click_Tops_Category() {

			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Tops)).click();
		}
		//Click on Saree sub-category

		public void click_Saree_Category() {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Saree)).click();

		}
		
		//Click on Men Category
		public void click_Men_Category() {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", MenCategory);

		}
		//Click on Tshirt-subcategory
		public void click_Tshirt_Category() {
			tshirt.click();
		}
		//Click on Jeans subCategory
		public void click_Jeans_Category() {
			Jeans.click();
		}
		
		//Click On Kids Category
		public void click_Kids_Category() {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", KidsCategory);

		}
		//Click on Dress sub_Category
		public void click_KidsDress_Category() {
			KidsDress.click();
		}
		//Click on Tops & shirts
		public void click_TopsAndShirts_Category() {
			TopsForKids.click();
		}
		
		//Return brand page title
		public String getBrandTitle() {

        WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(brandTitle));

			return brandTitle.getText();
		}

}
