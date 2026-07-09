package StepDefinitions;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import Hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.GoogleAdsHandler;

public class G_CheckOutSteps {
	
	private static final Logger logger = LogManager.getLogger(G_CheckOutSteps.class);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    ProductsPage productsPage = new ProductsPage(Hooks.driver);
    CartPage cartPage = new CartPage(Hooks.driver);
    CheckOutPage checkoutPage = new CheckOutPage(Hooks.driver);
    GoogleAdsHandler googleHandler=new GoogleAdsHandler(Hooks.driver);

    @Given("User is on Automation Exercise home page")
    public void user_is_on_home_page() {
    		logger.info("Verifying Automation Exercise Home Page");
        Assert.assertTrue(
                Hooks.driver.getCurrentUrl().contains("automationexercise"));
        logger.info("Home Page Verified Successfully");
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
    		logger.info("Clicking Signup/Login");

        loginPage.clickSignupLogin();
        logger.info("Logging in with valid credentials");

        loginPage.login(
                "iut@gmail.com",
                "Afrin*123");

        Assert.assertTrue(loginPage.isLoggedIn());
        logger.info("Login Successful");

    }

    @When("User clicks on Products menu")
    public void user_clicks_products_menu() {
    	 	logger.info("Clicking Products Menu");
        productsPage.clickProducts();
        logger.info("Products Menu Opened");

    }

    @When("User opens the first product")
    public void user_opens_first_product() {
    	
    		logger.info("opening First Product");
        productsPage.clickBluetop();
        logger.info("First Product Opened Successfully");

    }

    @When("User adds the product to cart")
    public void user_adds_product_to_cart() {
    	
    		logger.info("Adding Product To Cart");
        productsPage.addToCart();
        logger.info("Product Added to cart successfully");

    }

    @When("User views the cart")
    public void user_views_cart() {
    		
    		logger.info("Opening Cart");
        try {
            productsPage.viewCartFromPopup();
        } catch (Exception e) {
        		logger.error("Popup Cart Not Available Opening Cart Directly");
            cartPage.openCart();
        }
        logger.info("Cart Opened Successfully");

    }
    @When("User opens the cart")
    public void user_opens_the_cart() {
    	
    		logger.info("Opening Cart");
        cartPage.openCart();
        logger.info("Cart Opened Successfully");

    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
    		logger.info("Clicking Proceed To checkout");
        cartPage.clickProceedToCheckout();
        logger.info("Navigated to checkout page");

    }

    @Then("Checkout page should be displayed")
    public void checkout_page_should_be_displayed() {
    			
    		logger.info("Verifying Checkout page");
        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed());
        logger.info("Checkout Page Verified Successfully");

    }

    @Then("Cart should contain {int} product")
    public void cart_should_contain_product(Integer count) {
    		
    		logger.info("Verifying Cart Product Count");
        Assert.assertEquals(
                count.intValue(),
                cartPage.getProductCount());
        logger.info("Cart contains {} Product",count);

    }

    @Then("Cart should contain {int} products")
    public void cart_should_contain_products(Integer count) {
    	
    		logger.info("Verifying Cart Products Count");
        Assert.assertEquals(
                count.intValue(),
                cartPage.getProductCount());
        logger.info("Cart Contains {} Products",count);

    }

    @Then("Cart should be empty")
    public void cart_should_be_empty() {
    	
    		logger.info("Verifying Empty Cart");
        Assert.assertTrue(
                cartPage.isCartEmpty());
        logger.info("Cart Verified As Empty");

    }

    @Then("Delivery address should be displayed")
    public void delivery_address_should_be_displayed() {
    	
    		logger.info("Verifying Delivery Address");
        Assert.assertTrue(
                checkoutPage.isDeliveryAddressDisplayed());
        logger.info("Delivery Address Verified");

    }

    @Then("Billing address should be displayed")
    public void billing_address_should_be_displayed() {

    		logger.info("Verifying Billing Address");
        Assert.assertTrue(
                checkoutPage.isBillingAddressDisplayed());
        logger.info("Billing Address Verified");

    }

    @Then("Review order section should be displayed")
    public void review_order_section_should_be_displayed() {
    	
    		logger.info("Verifying Review Order Section");
        Assert.assertTrue(
                checkoutPage.isReviewOrderDisplayed());
        logger.info("Review Order Section Verified");

    }

   

    @Then("Place Order button should be visible")
    public void place_order_button_should_be_visible() {
    	
    		logger.info("Verifying Place Order Button");
        Assert.assertTrue(
                checkoutPage.isPlaceOrderButtonDisplayed());
        logger.info("Place Order Button Verified");

    }
  //==========================================
 // Multiple Products
 //==========================================

 @When("User adds the following products")
 public void user_adds_the_following_products(DataTable table) {
	 
	 logger.info("Adding Multiple Products to cart");

     for (String product : table.asList()) {
    	 	logger.info("Processing Product : {}",product);

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
        	 	logger.error("Product Not Found : {}",product);

             throw new RuntimeException("Product not found : " + product);

         }

         productsPage.addToCart();
         logger.info("{} Added to cart",product);
         productsPage.continueShopping();

         // Go back to Products page before adding the next product
         Hooks.driver.get("https://automationexercise.com/products");
     }
     logger.info("All Products Added Successfully");
 }

 //==========================================
 // Place Order
 //==========================================

 @When("User places the order")
 public void user_places_the_order() {
	 
	 logger.info("Placing the order");
     checkoutPage.clickPlaceOrder();
     String currenturl= productsPage.getCurrentUrl();
     //
     if(currenturl.contains("#google_vignette")) {
         //calling the googleHandler
         googleHandler.handleGoogleVignette(() -> {
             checkoutPage.clickPlaceOrder();
         });
     }
     logger.info("Place order clicked successfully");

 }

 //==========================================
 // Payment Details
 //==========================================

 @When("User enters payment details")
 public void user_enters_payment_details(DataTable table) {
	 
	 logger.info("Entering Payment Details");
     Map<String, String> payment =
             table.asMap(String.class, String.class);

     checkoutPage.enterPaymentDetails(

             payment.get("name"),
             payment.get("card"),
             payment.get("cvc"),
             payment.get("month"),
             payment.get("year"));
     logger.info("Payment Details Entered Successfully");

 }

 //==========================================
 // Confirm Order
 //==========================================

 @When("User confirms the order")
 public void user_confirms_the_order() {

	 logger.info("Confirming Order");
     checkoutPage.confirmOrder();
     logger.info("Order Confirmed");

 }

 //==========================================
 // Success Message
 //==========================================

 @Then("Order should be placed successfully")
 public void order_should_be_placed_successfully() {
	 
	 logger.info("Verifying order success message");
     Assert.assertTrue(

             checkoutPage.isOrderPlacedSuccessfully());
     logger.info("Order placed successfully");

 }

 //==========================================
 // Download Invoice
 //==========================================

 @Then("Download Invoice button should be visible")
 public void download_invoice_button_should_be_visible() {

	 logger.info("Verifying Download Invoice Button");
     Assert.assertTrue(

             checkoutPage.isDownloadInvoiceDisplayed());
     logger.info("Download Invoice Button verified");

 }

 //==========================================
 // Continue Button
 //==========================================

 @Then("Continue button should be visible")
 public void continue_button_should_be_visible() {
	 
	 logger.info("Verifying Continue Button");
     Assert.assertTrue(

             checkoutPage.isContinueButtonDisplayed());
     logger.info("Continue Button Verified");

 }

}