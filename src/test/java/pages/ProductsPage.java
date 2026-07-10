package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExplicitWaitUtil;

public class ProductsPage {

    WebDriver driver;
    Actions actions;
    ExplicitWaitUtil util;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        util=new ExplicitWaitUtil(driver);
    }

    // Locators
    By products = By.xpath("//a[@href='/products']");
    By search = By.id("search_product");
    By searchButton = By.id("submit_search");
    By quantity = By.id("quantity");
    By viewCart = By.xpath("//a[@href='/view_cart']");
    
    By addtoCart = By.xpath("//button[contains(@class,'cart')]");
    By continueshopping=By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    

    @FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2") WebElement BlueTopTitle;



//Get CurrentUrl
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    // Click Products Menu
    public void clickProducts() {

        WebElement productMenu = driver.findElement(products);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", productMenu);
    }
  
    public void clickBluetop() {

        WebElement blueTop = driver.findElement(
                By.xpath("//a[@href='/product_details/1']")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", blueTop);
    }

	public void clickMenTshirt() {
		WebElement MenTshirt=driver.findElement(By.xpath("//a[@href='/product_details/2']"));
		  ((JavascriptExecutor) driver)
          .executeScript("arguments[0].click();",MenTshirt);
}

public void clickSleevelessDress() {
	WebElement SleevelessDress=driver.findElement(By.xpath("//a[@href='/product_details/3']"));
	  ((JavascriptExecutor) driver)
    .executeScript("arguments[0].click();",SleevelessDress);
}
    // Search Product
    public void searchProduct(String product) {

        driver.findElement(search).clear();
        driver.findElement(search).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    // View Product
    public void viewProduct(String id) {

        WebElement product = driver.findElement(
                By.xpath("//a[@href='/product_details/" + id + "']"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", product);

        product.click();
    }

    // Add To Cart
    public void addToCart() {

        WebElement addToCartButton = driver.findElement(addtoCart);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", addToCartButton);

        System.out.println("Add To Cart Button Clicked");

    }
    public void continueShopping() {

    	 WebDriverWait wait =
    	            new WebDriverWait(driver, Duration.ofSeconds(10));

    	    WebElement continueBtn = wait.until(
    	            ExpectedConditions.elementToBeClickable(
    	                    continueshopping));

    	    continueBtn.click();

    }
    //open cart()
    public void viewCartFromPopup() {
        WebElement cart=util.waitForClickable(driver.findElement( By.xpath("//u[text()='View Cart']")));
        cart.click();

    }
    // Increase Quantity
    public void increaseQuantity(String qty) {

        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(qty);
    }

	public void addToCart(String string) {
		String cart=
				"//a[@data-product-id='PRODUCT_ID']"
                .replace("PRODUCT_ID", string);

		  WebElement addToCartButton = driver.findElement(By.xpath(cart));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", addToCartButton);
		// TODO Auto-generated method stub
		
		
	}
	
	


  
}