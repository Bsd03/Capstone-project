package StepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import utilities.ExplicitWaitUtil;

public class HomePageSteps {
	private static final Logger logger = LogManager.getLogger(HomePageSteps.class);
    WebDriver driver = Hooks.driver;
    HomePage home=new HomePage(driver);
    Actions actions=new Actions(driver);
    ExplicitWaitUtil util=new ExplicitWaitUtil(driver);
	@Given("User launches the browser")
	public void user_launches_the_browser() {
		logger.info("Launching a browser");
	}

	@Given("User navigates to {string}")
	public void user_navigates_to(String string) {
	  driver.get(string);
	  logger.info("navigated to "+ string);
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		 logger.info("Verifying Home Page");
	    Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
	}

	@Then("Website logo should be visible")
	public void website_logo_should_be_visible() {
	  Assert.assertTrue(home.checkLogo());
	  logger.info("Logo is visible when website loads");
	  
	}

	@Then("Home menu should be visible")
	public void home_menu_should_be_visible() {

	  logger.info("Verifying Home menu is visible");
	  Assert.assertTrue(home.Home().isDisplayed());
	  logger.info("Home menu is displayed successfully");

	  
	}

	@Then("Products menu should be visible")
	public void products_menu_should_be_visible() {

		logger.info("Verifying Products menu is visible");
		Assert.assertTrue(home.products().isDisplayed());
		logger.info("Products menu is displayed successfully");
	  
	}

	@Then("Cart menu should be visible")
	public void cart_menu_should_be_visible() {
		logger.info("Verifying Cart menu is visible");
		Assert.assertTrue(home.cart().isDisplayed());
		logger.info("Cart menu is displayed successfully");

	}

	@Then("Signup Login menu should be visible")
	public void signup_login_menu_should_be_visible() {

	    logger.info("Verifying Signup/Login menu is visible");
	    Assert.assertTrue(home.SignUp().isDisplayed());
	    logger.info("Signup/Login menu is displayed successfully");

	  
	}

	@Then("Contact Us menu should be visible")
	public void contact_us_menu_should_be_visible() {

	    logger.info("Verifying Contact Us menu is visible");
	    Assert.assertTrue(home.ContactUs().isDisplayed());
	    logger.info("Contact Us menu is displayed successfully");

	  
	}

	@Then("Homepage slider should be displayed")
	public void homepage_slider_should_be_displayed() {
		logger.info("Verifying Home Page slider is visible");
		Assert.assertTrue(home.HomePageSlider().isDisplayed());
		logger.info("Home Page slider is visible");
	}

	@When("User clicks next slider button")
	public void user_clicks_next_slider_button() {

		 logger.info("Clicking next slider button");
		 home.RightSlider().click();

	  
	}
	@Then("Next banner should be displayed")
	public void next_banner_should_be_visible() {

		logger.info("Waiting for second banner to become visible");
		util.waitForVisibility(home.SecondBanner());
		Assert.assertTrue(home.SecondBanner().isDisplayed());
		logger.info("Second banner displayed successfully");

	}
	

	@Then("Category section should be visible")
	public void category_section_should_be_visible() {
		logger.info("Verifying Category section is visible");
	  Assert.assertTrue(home.CategorySection().isDisplayed());
	  logger.info("Category section is visible");
	}

	@Then("Women category should be displayed")
	public void women_category_should_be_displayed() {
		logger.info("Scroll to Women Section of home Page");
		actions.moveToElement(home.WomenSection()).perform();
		Assert.assertTrue(home.WomenSection().isDisplayed());
		logger.info("Women Section is visible");
	   
	}

	@Then("Men category should be displayed")
	public void men_category_should_be_displayed() {
		logger.info("Scroll to Men Section of home Page");
		actions.moveToElement(home.Mensection()).perform();
		  Assert.assertTrue(home.Mensection().isDisplayed());
			logger.info("Men Section is visible");

	    
	}

	@Then("Kids category should be displayed")
	public void kids_category_should_be_displayed() {
		logger.info("Scroll to Kids Section of home Page");
		actions.moveToElement(home.KidsSection()).perform();
		  Assert.assertTrue(home.KidsSection().isDisplayed());
			logger.info("Kids Section is visible");

	   
	}

	@When("User expands Women category")
	public void user_expands_women_category() {
		   logger.info("Expanding Women category");
		    home.clickWomensSection();

	}

	@Then("Women category subcategories should be displayed")
	public void women_category_subcategories_should_be_displayed() {

	    logger.info("Verifying Women subcategories");

	    util.waitForVisibility(home.WomenSubCategory());
	    Assert.assertTrue(home.WomenSubCategory().isDisplayed());

	    logger.info("Women subcategories displayed successfully");

	   
	}

	@When("User expands Men category")
	public void user_expands_men_category() {
		   logger.info("Expanding Men category");

		home.clickMensSection();
	}

	@Then("Men category subcategories should be displayed")
	public void men_category_subcategories_should_be_displayed() {
	    logger.info("Verifying Men subcategories");

	   util.waitForVisibility(home.MenSubCategory());
	   Assert.assertTrue(home.MenSubCategory().isDisplayed());
	    logger.info("Men subcategories displayed successfully");

	}

	@When("User expands Kids category")
	public void user_expands_kids_category() {
		   logger.info("Expanding Kids category");

		home.clickKidsSection();
	  
	}

	@Then("Kids category subcategories should be displayed")
	public void kids_category_subcategories_should_be_displayed() {
	    logger.info("Verifying Kids subcategories");

		util.waitForVisibility(home.KidsSubCategory());
	  Assert.assertTrue(home.KidsSubCategory().isDisplayed());
	    logger.info("Kids subcategories displayed successfully");

	  
	}

	@Then("Features Items section should be displayed")
	public void features_items_section_should_be_displayed() {
		logger.info("Verifying feature items are visible");
	  Assert.assertTrue(home.FeatureItems().isDisplayed());
	  logger.info("Feature items are visible");
	}

	@When("User clicks View Product for a product")
	public void user_clicks_view_product_for_a_product() {
		logger.info("Clicking view Product on a product");
		home.clickViewProduct();
	   
	}

	@Then("Product details page should be displayed")
	public void product_details_page_should_be_displayed() {

	    logger.info("Waiting for Product Details page");

	    util.waitForURL("product_details");

	    String currentUrl = driver.getCurrentUrl();

	    Assert.assertTrue(currentUrl.contains("/product_details/"));

	    logger.info("Product Details page displayed successfully");

	}

	@When("User clicks Add to Cart for a product")
	public void user_clicks_add_to_cart_for_a_product() {

	    logger.info("Clicking Add To Cart");
	    home.clickAddtoCart();
	}

	@Then("Product should be added to cart successfully")
	public void product_should_be_added_to_cart_successfully() {

	    logger.info("Verifying Add To Cart success message");

	    util.waitForVisibility(home.AddedMessage());

	    Assert.assertTrue(home.AddedMessage().isDisplayed());

	    logger.info("Product added to cart successfully");

	  
	}

	@Then("Brands section should be displayed")
	public void brands_section_should_be_displayed() {
		logger.info("Scrolling down to Brands Section of the Home Page");
		actions.moveToElement(home.BrandsSection()).perform();
		Assert.assertTrue(home.BrandsSection().isDisplayed());
		logger.info("Brands section is visible");
		
	}

	@Then("Brand names should be listed")
	public void brand_names_should_be_listed() {
		logger.info("Getting all the brand Names");
	    List<WebElement> brands = home.getBrandNames();

	    Assert.assertTrue(brands.size() > 0);

	    for (WebElement brand : brands) {

	        Assert.assertTrue(
	                brand.isDisplayed());
	    }
	}

	@When("User clicks on a brand")
	public void user_clicks_on_a_brand() {

	    logger.info("Clicking first available brand");

	    home.clickFirstBrand();

	}
	@Then("Brand products page should be displayed")
	public void brand_products_page_should_be_displayed() {

	    Assert.assertTrue(driver.getCurrentUrl().contains("/brand_products/"));

	    logger.info("Brand products page displayed successfully");

	}

	@When("User scrolls down the page")
	public void user_scrolls_down_the_page() {

	    logger.info("Scrolling to bottom of page");

	    home.scrollToBottom();

	}

	@Then("Scroll Up button should be visible")
	public void scroll_up_button_should_be_visible() {
		logger.info("Verifying scroll up button is visible");
	    Assert.assertTrue(home.getScrollUpButton().isDisplayed());
	    logger.info("Scroll up button is visible");
	}

	@When("User clicks Scroll Up button")
	public void user_clicks_scroll_up_button() {

	    logger.info("Clicking Scroll Up button");

	    home.clickScrollUpButton();

	}

	@Then("User should be navigated to the top of the page")
	public void user_should_be_navigated_to_the_top_of_the_page() {

	    logger.info("Verifying page returned to top");

	    util.waitForVisibility(home.HomePageText());

	    Assert.assertTrue(home.HomePageText().isDisplayed());

	    logger.info("Successfully navigated to top of page");

	}

	@When("User scrolls to bottom of page")
	public void user_scrolls_to_bottom_of_page() {
	   home.scrollToBottom();
	logger.info("User scrolls to bottom of the page");

	   
	}

	@Then("Footer should be displayed")
	public void footer_should_be_displayed() {
		logger.info("Verifiying footer is displayed or not");
	  home.Footer().isDisplayed();
	  logger.info("footer is displayed");
	  
	}

	@When("User enters valid email address")
	public void user_enters_valid_email_address() {

	    logger.info("Entering subscription email");

	    home.enterSubscriptionEmail("Rakesh@gmail.com");
	}
	@When("User clicks Subscribe button")
	public void user_clicks_subscribe_button() {

	    logger.info("Clicking Subscribe button");

	    home.clickSubscribeButton();

	}

	@Then("Subscription success message should be displayed")
	public void subscription_success_message_should_be_displayed() {

	    Assert.assertTrue(home.isSubscriptionSuccessMessageDisplayed());

	    logger.info("Subscription completed successfully");
	}

}
