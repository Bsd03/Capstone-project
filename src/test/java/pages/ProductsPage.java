package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage {
	WebDriver driver;
	Actions actions=new Actions(driver);
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By products=By.xpath("//a[@href='/products']"); //products category
	By search=By.id("search_product"); //Search icon
	//
	By addToCart=By.xpath("//a[@data-product-id='1']"); //addToCart button
	//
	By viewCart=By.xpath("//a[@href='/view_cart']"); //viewCart icon
	
	By quantity =By.id("quantity"); //Quantity textbox
	
	
	public void productsPage() {  //takes user to Products page
		driver.findElement(products).click();
	}
	
	
	public void searchProduct(String product) { //Search any product
		driver.findElement(search).sendKeys(product);
		driver.findElement(By.className("fa-search")).click();
	}
	
	
	public void ViewProduct(String product_ID) { //View product by product ID
		driver.findElement(By.xpath("//a[@href='/product_details/" + product_ID + "']")).click();
	}
	
	
	public void addToCart(String id) { //adds item to the cart by item ID
		driver.findElement(By.xpath("//a[@data-product-id='"+id+"']")).click();
	}
	
	//increase product quantity
	public void increaseQuantity(String qty) {
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("qty");
	}
	
	
	
}
