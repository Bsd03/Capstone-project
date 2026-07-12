package testngTests;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import base.BaseClass;

import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;
 
public class CheckoutTest extends BaseClass {
 
    private CheckOutPage checkOutPage;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private WebDriverWait wait;
 
    // =====================================================
    // BEFORE EACH TEST
    // =====================================================
 
    @BeforeMethod(alwaysRun = true)
    public void initializeCheckoutTest() {
 
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
 
        checkOutPage = new CheckOutPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
 
        System.out.println(
                "Checkout test objects initialized");
    }
 
    // =====================================================
    // COMMON METHOD - LOGIN
    // =====================================================
 
    private void loginUser(
            String email,
            String password) {
 
        driver.get(
                "https://automationexercise.com/login");
 
        loginPage = new LoginPage(driver);
 
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
 
        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "Login failed for email: " + email);
 
        System.out.println(
                "Login successful");
    }
 
    // =====================================================
    // COMMON METHOD - ADD PRODUCT AND OPEN CART
    // =====================================================
 
    private void addProductAndOpenCart(
            String productId) {
 
        productsPage = new ProductsPage(driver);
 
        productsPage.clickProducts();
 
        wait.until(
                ExpectedConditions
                        .urlContains("/products"));
 
        productsPage.addToCart(productId);
 
        By viewCartPopup =
                By.xpath(
                        "//div[@id='cartModal']"
                        + "//a[@href='/view_cart']");
 
        wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                viewCartPopup))
                .click();
 
        wait.until(
                ExpectedConditions
                        .urlContains("/view_cart"));
 
        System.out.println(
                "Product " + productId
                + " added and cart opened");
    }
 
    // =====================================================
    // COMMON METHOD - PROCEED TO CHECKOUT
    // =====================================================
 
    private void proceedToCheckout() {
 
        By proceedButton =
                By.xpath(
                        "//a[contains(@class,'btn') "
                        + "and contains(@class,'check_out')]");
 
        WebElement button =
                wait.until(
                        ExpectedConditions
                                .elementToBeClickable(
                                        proceedButton));
 
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        button);
 
        wait.until(
                ExpectedConditions
                        .urlContains("/checkout"));
 
        System.out.println(
                "Proceeded to checkout successfully");
    }
 
    // =====================================================
    // COMMON METHOD - PLACE ORDER
    // =====================================================
 
    private void clickPlaceOrder() {
 
        By placeOrder =
                By.linkText("Place Order");
 
        WebElement button =
                wait.until(
                        ExpectedConditions
                                .elementToBeClickable(
                                        placeOrder));
 
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        button);
 
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        button);
 
        wait.until(
                ExpectedConditions
                        .urlContains("/payment"));
 
        System.out.println(
                "Place Order clicked successfully");
    }
 
    // =====================================================
    // COMMON METHOD - ENTER PAYMENT DETAILS
    // =====================================================
 
    private void enterPaymentDetails(
            String cardName,
            String cardNumber,
            String cvcNumber,
            String expiryMonth,
            String expiryYear) {
 
        WebElement cardNameField =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.name("name_on_card")));
 
        cardNameField.clear();
        cardNameField.sendKeys(cardName);
 
        WebElement cardNumberField =
                driver.findElement(
                        By.name("card_number"));
 
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
 
        WebElement cvcField =
                driver.findElement(
                        By.name("cvc"));
 
        cvcField.clear();
        cvcField.sendKeys(cvcNumber);
 
        WebElement expiryMonthField =
                driver.findElement(
                        By.name("expiry_month"));
 
        expiryMonthField.clear();
        expiryMonthField.sendKeys(expiryMonth);
 
        WebElement expiryYearField =
                driver.findElement(
                        By.name("expiry_year"));
 
        expiryYearField.clear();
        expiryYearField.sendKeys(expiryYear);
 
        System.out.println(
                "Payment details entered successfully");
    }
 
    // =====================================================
    // TEST 1 - VERIFY CHECKOUT PAGE
    // =====================================================
 
    @Test(priority = 1)
    @Parameters({
            "checkoutEmail",
            "checkoutPassword",
            "productId"
    })
    public void verifyCheckoutPageDisplayed(
            String email,
            String password,
            String productId) {
 
        loginUser(email, password);
 
        addProductAndOpenCart(productId);
 
        proceedToCheckout();
 
        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("/checkout"),
                "Checkout page is not displayed");
 
        System.out.println(
                "Checkout page displayed successfully");
    }
 
    // =====================================================
    // TEST 2 - VERIFY DELIVERY ADDRESS
    // =====================================================
 
    @Test(priority = 2)
    @Parameters({
            "checkoutEmail",
            "checkoutPassword",
            "productId"
    })
    public void verifyDeliveryAddressDisplayed(
            String email,
            String password,
            String productId) {
 
        loginUser(email, password);
 
        addProductAndOpenCart(productId);
 
        proceedToCheckout();
 
        WebElement deliveryAddress =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.id("address_delivery")));
 
        Assert.assertTrue(
                deliveryAddress.isDisplayed(),
                "Delivery address is not displayed");
 
        Assert.assertFalse(
                deliveryAddress.getText()
                        .trim()
                        .isEmpty(),
                "Delivery address is empty");
 
        System.out.println(
                "Delivery Address:");
 
        System.out.println(
                deliveryAddress.getText());
    }
 
    // =====================================================
    // TEST 3 - VERIFY BILLING ADDRESS
    // =====================================================
 
    @Test(priority = 3)
    @Parameters({
            "checkoutEmail",
            "checkoutPassword",
            "productId"
    })
    public void verifyBillingAddressDisplayed(
            String email,
            String password,
            String productId) {
 
        loginUser(email, password);
 
        addProductAndOpenCart(productId);
 
        proceedToCheckout();
 
        WebElement billingAddress =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.id("address_invoice")));
 
        Assert.assertTrue(
                billingAddress.isDisplayed(),
                "Billing address is not displayed");
 
        Assert.assertFalse(
                billingAddress.getText()
                        .trim()
                        .isEmpty(),
                "Billing address is empty");
 
        System.out.println(
                "Billing Address:");
 
        System.out.println(
                billingAddress.getText());
    }
 
    // =====================================================
    // TEST 4 - VERIFY REVIEW ORDER
    // =====================================================
 
    @Test(priority = 4)
    @Parameters({
            "checkoutEmail",
            "checkoutPassword",
            "productId"
    })
    public void verifyReviewOrderDisplayed(
            String email,
            String password,
            String productId) {
 
        loginUser(email, password);
 
        addProductAndOpenCart(productId);
 
        proceedToCheckout();
 
        WebElement reviewOrder =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath(
                                                "//h2[contains(text(),'Review Your Order')]")));
 
        Assert.assertTrue(
                reviewOrder.isDisplayed(),
                "Review Your Order section not displayed");
 
        WebElement cartProduct =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath(
                                                "//tr[contains(@id,'product-')]")));
 
        Assert.assertTrue(
                cartProduct.isDisplayed(),
                "Product not displayed in order summary");
 
        System.out.println(
                "Review Order verified successfully");
    }
}