package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage {

    WebDriver driver;
    Actions actions;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    // Locators
    By products = By.xpath("//a[@href='/products']");
    By search = By.id("search_product");
    By searchButton = By.id("submit_search");
    By quantity = By.id("quantity");
    By viewCart = By.xpath("//a[@href='/view_cart']");

    // Click Products Menu
    public void clickProducts() {

        WebElement productMenu = driver.findElement(products);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", productMenu);
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
    public void addToCart(String id) {

        WebElement product = driver.findElement(
                By.xpath("//a[@data-product-id='" + id + "']"));

        actions.moveToElement(product).perform();

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", product);
    }

    // Increase Quantity
    public void increaseQuantity(String qty) {

        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(qty);
    }

    // Open Cart
    public void openCart() {

        driver.findElement(viewCart).click();
    }
}