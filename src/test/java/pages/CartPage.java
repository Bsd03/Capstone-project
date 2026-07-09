package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExplicitWaitUtil;

public class CartPage {

    private WebDriver driver;
    private ExplicitWaitUtil wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new ExplicitWaitUtil(driver);
    }

    //==========================
    // Locators
    //==========================

    private By cartMenu =
            By.xpath("//a[@href='/view_cart']");

    private By proceedToCheckout =
            By.xpath("//a[contains(@class,'check_out')]");

    private By cartRows =
            By.xpath("//tbody/tr");

    private By productNames =
            By.xpath("//td[@class='cart_description']/h4/a");

    private By productPrices =
            By.xpath("//td[@class='cart_price']/p");

    private By productQuantity =
            By.xpath("//td[@class='cart_quantity']/button");

    private By totalPrices =
            By.xpath("//td[@class='cart_total']/p");

    private By deleteButtons =
            By.xpath("//a[contains(@class,'cart_quantity_delete')]");

    private By emptyCartMessage =
            By.xpath("//*[contains(text(),'Cart is empty')]");

    //==========================
    // Navigation
    //==========================

    public void openCart() {

        wait.waitForClickable(driver.findElement(cartMenu)).click();

    }

    //==========================
    // Checkout
    //==========================

    public void clickProceedToCheckout() {

        WebElement button =
                wait.waitForClickable(
                        driver.findElement(proceedToCheckout));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);

    }

    public boolean isProceedToCheckoutDisplayed() {

        return driver.findElement(proceedToCheckout)
                .isDisplayed();

    }

    //==========================
    // Cart Details
    //==========================

    public int getProductCount() {

        return driver.findElements(cartRows).size();

    }

    public List<WebElement> getProducts() {

        return driver.findElements(productNames);

    }

    public String getProductName(int index) {

        return driver.findElements(productNames)
                .get(index)
                .getText();

    }

    public String getProductPrice(int index) {

        return driver.findElements(productPrices)
                .get(index)
                .getText();

    }

    public String getProductQuantity(int index) {

        return driver.findElements(productQuantity)
                .get(index)
                .getText();

    }

    public String getTotalPrice(int index) {

        return driver.findElements(totalPrices)
                .get(index)
                .getText();

    }

    //==========================
    // Remove Product
    //==========================

    public void removeProduct(int index) {

        driver.findElements(deleteButtons)
                .get(index)
                .click();

    }

    //==========================
    // Verification
    //==========================

    public boolean isCartEmpty() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            emptyCartMessage))
                    .isDisplayed();

        }

        catch (Exception e) {

            return false;

        }

    }

    public boolean isProductPresent(String productName) {

        for (WebElement product :
                driver.findElements(productNames)) {

            if (product.getText()
                    .equalsIgnoreCase(productName)) {

                return true;

            }

        }

        return false;

    }

    public boolean verifyProductQuantity(String expectedQuantity) {

        for (WebElement quantity :
                driver.findElements(productQuantity)) {

            if (quantity.getText()
                    .equals(expectedQuantity)) {

                return true;

            }

        }

        return false;

    }

    public boolean verifyTotalPriceDisplayed() {

        return driver.findElements(totalPrices)
                .size() > 0;

    }

}