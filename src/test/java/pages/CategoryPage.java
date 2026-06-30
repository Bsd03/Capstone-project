package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		@FindBy(linkText="Tops ") WebElement Tops;
		//Saree sub-category
		@FindBy(linkText="Saree ") WebElement Saree;
		
		//Men category
		@FindBy(xpath=
				"(//span[contains(@class,'badge') and contains(@class,'pull-right')])[2]") 
		WebElement MenCategory;
		//Tshirt subcategory
		@FindBy(linkText="Tshirts ") WebElement tshirt;
		//Jeans subcategory
		@FindBy(linkText="Jeans ") WebElement Jeans;
		
		//Kids category
		@FindBy(xpath=
				"(//span[contains(@class,'badge') and contains(@class,'pull-right')])[2]") 
		WebElement KidsCategory;
		//Dress sub-category (Kids)
		@FindBy(xpath=
				"//div[@id='Kids']//a[normalize-space()='Dress']") WebElement KidsDress;
		//Tops&Shirts sub-category
		@FindBy(linkText="Tops & Shirts ") WebElement TopsForKids;
		
		//Brand page title
		@FindBy(xpath="//h2[@class='title text-center']") WebElement brandTitle;
		
		//Action Methods
		
		//Click on Women Category
		public void click_Women_Category() {
			womenCategory.click();
		}
		//Click on Dress sub-category
		public void click_Dress_Category() {
			dress.click();
		}
		//Click on Tops sub-category
		public void click_Tops_Category() {
			Tops.click();
		}
		//Click on Saree sub-category
		public void click_Saree_Category() {
			Saree.click();
		}
		
		//Click on Men Category
		public void click_Men_Category() {
			MenCategory.click();
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
			KidsCategory.click();
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
			return brandTitle.getText();
		}

}
