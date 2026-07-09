package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitUtil;

public class CheckOutPage {

    private WebDriver driver;
    private ExplicitWaitUtil wait;

    public CheckOutPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new ExplicitWaitUtil(driver);

        PageFactory.initElements(driver, this);

    }

    //==========================================
    // Checkout Page
    //==========================================

    @FindBy(xpath="//a[contains(@class,'check_out')]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(id="address_delivery")
    private WebElement deliveryAddress;

    @FindBy(id="address_invoice")
    private WebElement billingAddress;

    @FindBy(xpath="//h2[text()='Review Your Order']")
    private WebElement reviewOrderHeading;

    @FindBy(name="message")
    private WebElement commentBox;

    @FindBy(linkText="Place Order")
    private WebElement placeOrderBtn;

    //==========================================
    // Order Summary
    //==========================================

    @FindBy(xpath="//tbody/tr")
    private List<WebElement> orderRows;

    @FindBy(xpath="//td[@class='cart_description']/h4/a")
    private List<WebElement> productNames;

    @FindBy(xpath="//td[@class='cart_price']/p")
    private List<WebElement> productPrices;

    @FindBy(xpath="//td[@class='cart_quantity']/button")
    private List<WebElement> quantities;

    @FindBy(xpath="//td[@class='cart_total']/p")
    private List<WebElement> totalPrices;

    //==========================================
    // Payment Details
    //==========================================

    @FindBy(name="name_on_card")
    private WebElement cardName;

    @FindBy(name="card_number")
    private WebElement cardNumber;

    @FindBy(name="cvc")
    private WebElement cvc;

    @FindBy(name="expiry_month")
    private WebElement expiryMonth;

    @FindBy(name="expiry_year")
    private WebElement expiryYear;

    @FindBy(id="submit")
    private WebElement confirmOrderBtn;

    //==========================================
    // Order Confirmation
    //==========================================

    @FindBy(xpath="//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    private WebElement successMessage;

    @FindBy(linkText="Download Invoice")
    private WebElement downloadInvoiceBtn;

    @FindBy(linkText="Continue")
    private WebElement continueBtn;

    //==========================================
    // Actions
    //==========================================

    public void clickProceedToCheckout() {

        wait.waitForClickable(proceedToCheckoutBtn).click();

    }

    public void clickPlaceOrder() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                placeOrderBtn);

        js.executeScript(
                "arguments[0].click();",
                placeOrderBtn);

    }

    public void enterComment(String message) {

        commentBox.clear();
        commentBox.sendKeys(message);

    }

    //==========================================
    // Payment
    //==========================================

    public void enterCardName(String name) {

        cardName.clear();
        cardName.sendKeys(name);

    }

    public void enterCardNumber(String number) {

        cardNumber.clear();
        cardNumber.sendKeys(number);

    }

    public void enterCVC(String number) {

        cvc.clear();
        cvc.sendKeys(number);

    }

    public void enterExpiryMonth(String month) {

        expiryMonth.clear();
        expiryMonth.sendKeys(month);

    }

    public void enterExpiryYear(String year) {

        expiryYear.clear();
        expiryYear.sendKeys(year);

    }

    public void enterPaymentDetails(String name,
                                    String card,
                                    String cvcNo,
                                    String month,
                                    String year) {

        enterCardName(name);
        enterCardNumber(card);
        enterCVC(cvcNo);
        enterExpiryMonth(month);
        enterExpiryYear(year);

    }

    public void confirmOrder() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", confirmOrderBtn);

        js.executeScript("arguments[0].click();", confirmOrderBtn);

    }

    //==========================================
    // Invoice
    //==========================================

    public void downloadInvoice() {

        wait.waitForClickable(downloadInvoiceBtn).click();

    }

    public void clickContinue() {

        wait.waitForClickable(continueBtn).click();

    }

    //==========================================
    // Verification Methods
    //==========================================

    public boolean isCheckoutPageDisplayed() {

        return wait.waitForVisibility(reviewOrderHeading)
                .isDisplayed();

    }

    public boolean isDeliveryAddressDisplayed() {

        return deliveryAddress.isDisplayed();

    }

    public boolean isBillingAddressDisplayed() {

        return billingAddress.isDisplayed();

    }

    public boolean isReviewOrderDisplayed() {

        return reviewOrderHeading.isDisplayed();

    }

    public boolean isPlaceOrderButtonDisplayed() {

        return placeOrderBtn.isDisplayed();

    }

    public int getOrderCount() {

        return orderRows.size();

    }

    public String getProductName(int index) {

        return productNames.get(index).getText();

    }

    public String getProductPrice(int index) {

        return productPrices.get(index).getText();

    }

    public String getQuantity(int index) {

        return quantities.get(index).getText();

    }

    public String getTotalPrice(int index) {

        return totalPrices.get(index).getText();

    }

    public boolean isOrderPlacedSuccessfully() {

        return wait.waitForVisibility(successMessage)
                .isDisplayed();

    }

    public String getSuccessMessage() {

        return wait.waitForVisibility(successMessage)
                .getText();

    }

    public boolean isDownloadInvoiceDisplayed() {

        return downloadInvoiceBtn.isDisplayed();

    }

    public boolean isContinueButtonDisplayed() {

        return continueBtn.isDisplayed();

    }

}