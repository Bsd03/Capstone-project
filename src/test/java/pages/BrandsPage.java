package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandsPage {
	
	//Declare WebDriver object
		WebDriver driver;
		
		//Constructor to initialize PageFactory elements
		public BrandsPage(WebDriver driver ) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//Web Elements - Brands
		
		//Polo brand
		@FindBy(xpath="//a[@href='/brand_products/Polo']") WebElement poloBrand;
		
		//H&M brand
		@FindBy(xpath="//a[@href='/brand_products/H&M']") WebElement hmBrand;
		
		//Madame brand
		@FindBy(xpath="//a[@href='/brand_products/Madame']") WebElement madameBrand;
		
		//Mast&Harbour
		@FindBy(xpath="//a[@href='/brand_products/Mast & Harbour']") WebElement Mast_Harbour;
		
		//BabyHug
		@FindBy(xpath="//a[@href='/brand_product/Babyhug']") WebElement BabyHug;
		
		//Allen solly junior
		@FindBy(xpath="//a[@href='/brand_product/Allen Solly Junior']") WebElement Allen_Solley_Junior;
		
		//Kookie kids
		@FindBy(xpath="//a[@href='/brand_product/Kookie Kids']") WebElement Kookie_Kids;
		
		//Biba
		@FindBy(xpath="//a[@href='/brand_product/Biba']") WebElement Biba;
		
		//Brand page title
		@FindBy(xpath="//h2[@class='title text-center']") WebElement brandTitle;
		
		//Action Methods
		
		//Click on Polo Brand
		public void clickPoloBrand() {
			poloBrand.click();
		}
		
		//Click on H&M brand
		public void clickHMBrand() {
			hmBrand.click();
		}
		
		//Click on Madame brand
		public void clickMadameBrand() {
			madameBrand.click();
		}
		
		//Click on Babyhug brand
		public void clickBabyHug() {
			BabyHug.click();
		}
		
		//Click on Allen_Solley_Junior
		public void clickAllenSolleyJunior() {
			Allen_Solley_Junior.click();
		}
		
		//Click on Kookie_Kids
		public void clickKookieKids() {
			Kookie_Kids.click();
		}
		
		//Click on Biba
		public void clickBiba() {
			Biba.click();
		}
		
		//Return brand page title
		public String getBrandTitle() {
			return brandTitle.getText();
		}

}
