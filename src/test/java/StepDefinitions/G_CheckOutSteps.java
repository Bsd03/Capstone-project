package StepDefinitions;


import java.util.Map;

import org.junit.Assert;

import Hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class G_CheckOutSteps {

    LoginPage loginPage = new LoginPage(Hooks.driver);
    ProductsPage productsPage = new ProductsPage(Hooks.driver);
    CartPage cartPage = new CartPage(Hooks.driver);
    CheckOutPage checkoutPage = new CheckOutPage(Hooks.driver);

    @Given("User is on Automation Exercise home page")
    public void user_is_on_home_page() {

        Assert.assertTrue(
                Hooks.driver.getCurrentUrl().contains("automationexercise"));

    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

        loginPage.clickSignupLogin();

        loginPage.login(
                "iut@gmail.com",
                "Afrin*123");

        Assert.assertTrue(loginPage.isLoggedIn());

    }

    @When("User clicks on Products menu")
    public void user_clicks_products_menu() {

        productsPage.clickProducts();

    }

    @When("User opens the first product")
    public void user_opens_first_product() {

        productsPage.clickBluetop();

    }

    @When("User adds the product to cart")
    public void user_adds_product_to_cart() {

        productsPage.addToCart();

    }

    @When("User views the cart")
    public void user_views_cart() {

        try {
            productsPage.viewCartFromPopup();
        } catch (Exception e) {
            cartPage.openCart();
        }

    }
    @When("User opens the cart")
    public void user_opens_the_cart() {

        cartPage.openCart();

    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {

        cartPage.clickProceedToCheckout();

    }

    @Then("Checkout page should be displayed")
    public void checkout_page_should_be_displayed() {

        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed());

    }

    @Then("Cart should contain {int} product")
    public void cart_should_contain_product(Integer count) {

        Assert.assertEquals(
                count.intValue(),
                cartPage.getProductCount());

    }

    @Then("Cart should contain {int} products")
    public void cart_should_contain_products(Integer count) {

        Assert.assertEquals(
                count.intValue(),
                cartPage.getProductCount());

    }

    @Then("Cart should be empty")
    public void cart_should_be_empty() {

        Assert.assertTrue(
                cartPage.isCartEmpty());

    }

    @Then("Delivery address should be displayed")
    public void delivery_address_should_be_displayed() {

        Assert.assertTrue(
                checkoutPage.isDeliveryAddressDisplayed());

    }

    @Then("Billing address should be displayed")
    public void billing_address_should_be_displayed() {

        Assert.assertTrue(
                checkoutPage.isBillingAddressDisplayed());

    }

    @Then("Review order section should be displayed")
    public void review_order_section_should_be_displayed() {

        Assert.assertTrue(
                checkoutPage.isReviewOrderDisplayed());

    }

   

    @Then("Place Order button should be visible")
    public void place_order_button_should_be_visible() {

        Assert.assertTrue(
                checkoutPage.isPlaceOrderButtonDisplayed());

    }
  //==========================================
 // Multiple Products
 //==========================================

 @When("User adds the following products")
 public void user_adds_the_following_products(DataTable table) {

     for (String product : table.asList()) {

         productsPage.clickProducts();

         switch (product.toLowerCase()) {

         case "blue top":

             productsPage.clickBluetop();
             break;

         case "men tshirt":

             productsPage.clickMenTshirt();
             break;

         case "sleeveless dress":

             productsPage.clickSleevelessDress();
             break;

         default:

             throw new RuntimeException("Product not found : " + product);

         }

         productsPage.addToCart();
         productsPage.continueShopping();

         // Go back to Products page before adding the next product
         Hooks.driver.get("https://automationexercise.com/products");
     }
 }

 //==========================================
 // Place Order
 //==========================================

 @When("User places the order")
 public void user_places_the_order() {

     checkoutPage.clickPlaceOrder();

 }

 //==========================================
 // Payment Details
 //==========================================

 @When("User enters payment details")
 public void user_enters_payment_details(DataTable table) {

     Map<String, String> payment =
             table.asMap(String.class, String.class);

     checkoutPage.enterPaymentDetails(

             payment.get("name"),
             payment.get("card"),
             payment.get("cvc"),
             payment.get("month"),
             payment.get("year"));

 }

 //==========================================
 // Confirm Order
 //==========================================

 @When("User confirms the order")
 public void user_confirms_the_order() {

     checkoutPage.confirmOrder();

 }

 //==========================================
 // Success Message
 //==========================================

 @Then("Order should be placed successfully")
 public void order_should_be_placed_successfully() {

     Assert.assertTrue(

             checkoutPage.isOrderPlacedSuccessfully());

 }

 //==========================================
 // Download Invoice
 //==========================================

 @Then("Download Invoice button should be visible")
 public void download_invoice_button_should_be_visible() {

     Assert.assertTrue(

             checkoutPage.isDownloadInvoiceDisplayed());

 }

 //==========================================
 // Continue Button
 //==========================================

 @Then("Continue button should be visible")
 public void continue_button_should_be_visible() {

     Assert.assertTrue(

             checkoutPage.isContinueButtonDisplayed());

 }

}