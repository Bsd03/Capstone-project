
package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public BrandsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===========================
    // Locators
    // ===========================

    // Brands Section
    By brandsSection = By.xpath("//div[@class='brands_products']");

    // All Brand Names
    By allBrands = By.xpath("//div[@class='brands_products']//a");

    // Individual Brands
    By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
    By hmBrand = By.xpath("//a[contains(@href,'H%26M') or contains(@href,'H&M') or contains(@href,'H&amp;M')]");
    By madameBrand = By.xpath("//a[contains(@href,'Madame')]");
    By mastHarbourBrand = By.xpath("//a[contains(@href,'Mast')]");
    By babyhugBrand = By.xpath("//a[contains(@href,'Babyhug')]");
    By allenBrand = By.xpath("//a[contains(@href,'Allen')]");
    By kookieBrand = By.xpath("//a[contains(@href,'Kookie')]");
    By bibaBrand = By.xpath("//a[contains(@href,'Biba')]");

    // Brand Page Heading
    By brandHeading = By.xpath("//h2[@class='title text-center']");

    // Product List
    By products = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

    // First Product
    By firstViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");

    // Product Details
    By productName = By.xpath("//div[@class='product-information']/h2");
    By category = By.xpath("//div[@class='product-information']/p[1]");
    By price = By.xpath("//div[@class='product-information']//span/span");
    By availability = By.xpath("//b[contains(text(),'Availability')]");
    By condition = By.xpath("//b[contains(text(),'Condition')]");
    By brand = By.xpath("//b[contains(text(),'Brand')]");

    // Add to Cart
    By firstAddToCart = By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");

    // Continue Shopping
    By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");

    // View Cart
    By viewCart = By.xpath("//u[contains(text(),'View Cart')]");

    // Cart Product
    By cartProduct = By.xpath("//td[@class='cart_description']");

    // ===========================
    // Methods
    // ===========================
    // Click Any Brand
    // NOTE: We deliberately do NOT use By.linkText(brandName) here.
    // The site renders brand links with a trailing product count,
    // e.g. "Polo (2)", "H&M (4)" — so an exact linkText("Polo") match
    // never finds the element and times out. Instead we reuse the
    // href-based locators already defined above, which match regardless
    // of the count suffix.
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public boolean isAllProductsPageDisplayed() {
        return driver.getCurrentUrl().contains("/products");
    }
    public void clickBrand(String brandName) {

        By locator;

        switch (brandName.trim().toUpperCase()) {

        case "POLO":
            locator = poloBrand;
            break;

        case "H&M":
            locator = hmBrand;
            break;

        case "MADAME":
            locator = madameBrand;
            break;

        case "MAST & HARBOUR":
            locator = mastHarbourBrand;
            break;

        case "BABYHUG":
            locator = babyhugBrand;
            break;

        case "ALLEN SOLLY JUNIOR":
            locator = allenBrand;
            break;

        case "KOOKIE KIDS":
            locator = kookieBrand;
            break;

        case "BIBA":
            locator = bibaBrand;
            break;

        default:
            throw new IllegalArgumentException("Unknown brand: " + brandName);
        }

        WebElement brand = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", brand);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brand);
    }
    


   

    // Verify all brands are displayed
    public void verifyBrandNames() {

        List<WebElement> brands = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(allBrands));

        Assert.assertTrue(brands.size() > 0);

        for (WebElement brand : brands) {
            System.out.println(brand.getText());
        }
    }

    // Click Polo Brand
    public void clickPoloBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(poloBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click H&M Brand
    public void clickHMBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(hmBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Madame Brand
    public void clickMadameBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(madameBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Mast & Harbour Brand
    public void clickMastHarbourBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(mastHarbourBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Babyhug Brand
    public void clickBabyhugBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(babyhugBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Allen Solly Junior Brand
    public void clickAllenBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(allenBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Kookie Kids Brand
    public void clickKookieBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(kookieBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Biba Brand
    public void clickBibaBrand() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(bibaBrand));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
 // Verify Brand Page
    public void verifyBrandPage(String brandName) {

        WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(brandHeading));

        Assert.assertTrue(heading.isDisplayed());

        System.out.println("Heading : " + heading.getText());

        Assert.assertTrue(heading.getText().toUpperCase().contains(brandName.toUpperCase()));
    }
 // Verify Brands Section
    public void verifyBrandsSection() {

        WebElement section = wait.until(
                ExpectedConditions.visibilityOfElementLocated(brandsSection));

        Assert.assertTrue(section.isDisplayed());
    }

    // Verify Products are displayed
    public void verifyProductsDisplayed() {

        List<WebElement> list = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(products));

        Assert.assertTrue(list.size() > 0);

        System.out.println("Products Found : " + list.size());
    }

    // Open First Product
    public void openFirstProduct() {

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(firstViewProduct));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
    }

    // Verify Product Name
    public void verifyProductName() {

        Assert.assertTrue(wait.until(
                ExpectedConditions.visibilityOfElementLocated(productName))
                .isDisplayed());

        System.out.println(driver.findElement(productName).getText());
    }

    // Verify Category
    public void verifyCategory() {

        Assert.assertTrue(wait.until(
                ExpectedConditions.visibilityOfElementLocated(category))
                .isDisplayed());

        System.out.println(driver.findElement(category).getText());
    }

    // Verify Price
    public void verifyPrice() {

        Assert.assertTrue(wait.until(
                ExpectedConditions.visibilityOfElementLocated(price))
                .isDisplayed());

        System.out.println(driver.findElement(price).getText());
    }

    // Verify Availability
    public void verifyAvailability() {

        Assert.assertTrue(wait.until(
                ExpectedConditions.visibilityOfElementLocated(availability))
                .isDisplayed());
    }

    // Verify Condition
    public void verifyCondition() {

        Assert.assertTrue(wait.until(
                ExpectedConditions.visibilityOfElementLocated(condition))
                .isDisplayed());
    }

 // Verify Product Brand
    public void verifyBrand(String brandName) {

        WebElement productBrand = wait.until(
                ExpectedConditions.visibilityOfElementLocated(brand));

        Assert.assertTrue(productBrand.isDisplayed());

        String pageText = driver.findElement(By.className("product-information")).getText();

        Assert.assertTrue(pageText.toUpperCase().contains(brandName.toUpperCase()));
    }

    // Add Product to Cart
    public void addFirstProductToCart() {

        WebElement add = wait.until(
                ExpectedConditions.elementToBeClickable(firstAddToCart));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);
    }

    // Continue Shopping
    public void clickContinueShopping() {

        wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
    }

    // Open Cart
    public void openCart() {

        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }

    // Verify Product in Cart
    public void verifyCartProduct() {

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartProduct));

        Assert.assertTrue(product.isDisplayed());

        System.out.println(product.getText());
    }

    // Get Current URL
    public String getCurrentPageURL() {

        return driver.getCurrentUrl();
    }

    // Navigate Back
    public void navigateBack() {

        driver.navigate().back();
    }

}