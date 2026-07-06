package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;


public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By logout=By.xpath("//a[@href='/logout']"); // logout button
	By delteAccount=By.xpath("//a[@href='/delete_account']"); //delete button
	By subscribe=By.id("susbscribe_email"); //subscribe section
	By subscribeButton=By.xpath("//*[@id=\"subscribe\"]/i");//subscribe button
	By logo=By.xpath("//img[@alt='Website for automation practice']"); //The website logo
	By Home=By.xpath("//a[@href='/']"); //home section 
	By products=By.xpath("//a[@href='/products']"); //products section
	By cart=By.xpath("//a[@href='/view_cart']"); //cart 
	By SignUp=By.xpath("//a[@href='/login']"); //SignUp button
	By contactUs=By.xpath("//a[@href='/contact_us']"); //Contact us button
	By homePageSlider=By.xpath("//a[@href='#slider-carousel']"); //slider present in home page
	By rightSlider = By.xpath("//a[@href='#slider-carousel' and @data-slide='next']"); 
	By category=By.id("accordian");
	By Mens=By.xpath("//a[@href='#Men']");
	By Women=By.xpath("//a[@href='#Women']");
	By Kids=By.xpath("//a[@href='#Kids']");
	By expandSection=By.className("fa-plus");
	By womenCategory = By.xpath("(//i[contains(@class,'fa-plus')])[1]");
	By womenSubCategory=By.xpath("//a[@href='/category_products/1']");
	By menCategory = By.xpath("(//i[contains(@class,'fa-plus')])[2]");
	By MenSubCategory=By.xpath("//a[@href='/category_products/3']");
	By kidsCategory = By.xpath("(//i[contains(@class,'fa-plus')])[3]");
	By kidsSubCategory=By.xpath("//a[@href='/category_products/4']");
	By secondBanner=By.xpath("//img[@src='/static/images/home/girl1.jpg']");
	By featureItems=By.xpath("//a[@data-product-id='1']");
	By viewProduct= By.xpath("//a[contains(@href,'/product_details/')]");
	By viewFirstProduct=By.xpath("//a[contains(@href,'/product_details/1')]");
	By cartButton=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");
	By addedMessage = By.xpath("//h4[text()='Added!']");
	By brandsSection=By.xpath ("//div[@class='brands_products']");

	By brandNames = By.xpath("//div[@class='brands_products']//a");
	By scrollUpButton = By.id("scrollUp");
	By homePageText = By.xpath("//div[@class='col-sm-6']//h2");
	By footer =By.className("footer-bottom");
	By subscriptionEmail = By.id("susbscribe_email");

	By successMessage =
	        By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");
	
	public void enterSubscriptionEmail(String email) {
	    driver.findElement(subscriptionEmail).sendKeys(email);
	}
	public void clickSubscribeButton() {
	    driver.findElement(subscribeButton).click();
	}

	public boolean isSubscriptionSuccessMessageDisplayed() {
	    return driver.findElement(successMessage).isDisplayed();
	}
	
	public WebElement Footer() {
		return driver.findElement(footer);
	}
	public void scrollToBottom() {

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public WebElement getScrollUpButton() {
	    return driver.findElement(scrollUpButton);
	}

	public void clickScrollUpButton() {
	    driver.findElement(scrollUpButton).click();
	}

	public WebElement HomePageText() {
	    return driver.findElement(homePageText);
	}

	public void clickFirstBrand() {
		WebElement firstBrand =
		        driver.findElements(brandNames).get(0);

		JavascriptExecutor js =
		        (JavascriptExecutor) driver;

		js.executeScript(
		        "arguments[0].click();",
		        firstBrand);
	}

	public WebElement BrandsSection() {
	    return driver.findElement(brandsSection);
	}

	public List<WebElement> getBrandNames() {
		  return driver.findElements(brandNames);
	}
			
	public WebElement AddedMessage() {
		return driver.findElement(addedMessage);
	}
	
	
	
	public List<WebElement> Products() {
		return driver.findElements(viewProduct);
	}
	public WebElement CartButton() {
		return driver.findElement(cartButton);
	}
	//
	public WebElement FeatureItems() {
		return driver.findElement(featureItems);
	}
	public WebElement KidsSubCategory() {
		return driver.findElement(kidsSubCategory);
	}
	public WebElement MenSubCategory() {
		return driver.findElement(MenSubCategory);
	}
	
	public WebElement WomenSubCategory() {
		return driver.findElement(womenSubCategory);
	}
	
	public WebElement SecondBanner() {
		return driver.findElement(secondBanner);
	}
	public WebElement ViewFirstProduct() {
		return driver.findElement(viewFirstProduct);
	}
	
	//returns Mens section
		public WebElement Mensection() {
			return driver.findElement(menCategory);
		}
		
		//returns Women section
		public WebElement WomenSection() {
			return driver.findElement(womenCategory);
		}
		
		//returns Kids section
		public WebElement KidsSection() {
			return driver.findElement(kidsCategory);
		}
		
		public void clickKidsSection() {
			JavascriptExecutor js =
		            (JavascriptExecutor) driver;

		    js.executeScript(
		            "arguments[0].click();",
		            KidsSection());
		}
		
		public void clickWomensSection() {
			JavascriptExecutor js =
		            (JavascriptExecutor) driver;

		    js.executeScript(
		            "arguments[0].click();",
		            WomenSection());
		}
		public void clickMensSection() {
			JavascriptExecutor js =
		            (JavascriptExecutor) driver;

		    js.executeScript(
		            "arguments[0].click();",
		            Mensection());
		}
		public void clickViewProduct() {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", ViewFirstProduct());
		}
		public void clickAddtoCart() {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", CartButton());
		}
	
	//returns Category section
	public WebElement CategorySection() {
		return driver.findElement(category);
	}
	
	//return Slider next element
	public WebElement RightSlider() {
		return driver.findElement(rightSlider);
	}
	//return slider element
	public WebElement HomePageSlider() {
		return driver.findElement(homePageSlider);
	}

	//return contact Us element
		public WebElement ContactUs() {
			return driver.findElement(contactUs);
		}
	
	//return signUp element
	public WebElement SignUp() {
		return driver.findElement(SignUp);
	}
	
	//returns cart element
	public WebElement cart() {
		return driver.findElement(cart);
	}

	//return product element
	public WebElement products() {
		return driver.findElement(products);
	}
	//returns Home WebElement
	public WebElement Home() {
		return driver.findElement(Home);
	}
	
	//Check if logo is visible or not
	public boolean checkLogo() {
		return driver.findElement(logo).isDisplayed();
	}
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

