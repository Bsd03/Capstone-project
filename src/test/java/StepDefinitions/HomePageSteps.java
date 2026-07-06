package StepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
	  Assert.assertTrue(home.Home().isDisplayed());
	  
	}

	@Then("Products menu should be visible")
	public void products_menu_should_be_visible() {
	  Assert.assertTrue(home.products().isDisplayed());
	  
	}

	@Then("Cart menu should be visible")
	public void cart_menu_should_be_visible() {
	  Assert.assertTrue(home.cart().isDisplayed());
	  
	}

	@Then("Signup Login menu should be visible")
	public void signup_login_menu_should_be_visible() {
	  Assert.assertTrue(home.SignUp().isDisplayed());
	  
	}

	@Then("Contact Us menu should be visible")
	public void contact_us_menu_should_be_visible() {
	  Assert.assertTrue(home.ContactUs().isDisplayed());
	  
	}

	@Then("Homepage slider should be displayed")
	public void homepage_slider_should_be_displayed() {
	  Assert.assertTrue(home.HomePageSlider().isDisplayed());
	  
	}

	@When("User clicks next slider button")
	public void user_clicks_next_slider_button() {
	  home.RightSlider().click();
	  
	}
	@Then("Next banner should be displayed")
	public void next_banner_should_be_visible() {
		util.waitForVisibility(home.SecondBanner());
		Assert.assertTrue(home.SecondBanner().isDisplayed());
	}
	

	@Then("Category section should be visible")
	public void category_section_should_be_visible() {
	  Assert.assertTrue(home.CategorySection().isDisplayed());
	  
	}

	@Then("Women category should be displayed")
	public void women_category_should_be_displayed() {
		actions.moveToElement(home.WomenSection()).perform();
		Assert.assertTrue(home.WomenSection().isDisplayed());

	   
	}

	@Then("Men category should be displayed")
	public void men_category_should_be_displayed() {
		actions.moveToElement(home.Mensection()).perform();
		  Assert.assertTrue(home.Mensection().isDisplayed());

	    
	}

	@Then("Kids category should be displayed")
	public void kids_category_should_be_displayed() {
		actions.moveToElement(home.KidsSection()).perform();
		  Assert.assertTrue(home.KidsSection().isDisplayed());

	   
	}

	@When("User expands Women category")
	public void user_expands_women_category() {
		home.clickWomensSection();
	}

	@Then("Women category subcategories should be displayed")
	public void women_category_subcategories_should_be_displayed() {
		util.waitForVisibility(home.WomenSubCategory());
	   Assert.assertTrue(home.WomenSubCategory().isDisplayed());
	   
	}

	@When("User expands Men category")
	public void user_expands_men_category() {
		home.clickMensSection();
	}

	@Then("Men category subcategories should be displayed")
	public void men_category_subcategories_should_be_displayed() {
	   util.waitForVisibility(home.MenSubCategory());
	   Assert.assertTrue(home.MenSubCategory().isDisplayed());
	}

	@When("User expands Kids category")
	public void user_expands_kids_category() {
		home.clickKidsSection();
	  
	}

	@Then("Kids category subcategories should be displayed")
	public void kids_category_subcategories_should_be_displayed() {
		util.waitForVisibility(home.KidsSubCategory());
	  Assert.assertTrue(home.KidsSubCategory().isDisplayed());
	  
	}

	@Then("Features Items section should be displayed")
	public void features_items_section_should_be_displayed() {
	  Assert.assertTrue(home.FeatureItems().isDisplayed());
	  
	}

	@When("User clicks View Product for a product")
	public void user_clicks_view_product_for_a_product() {
		home.clickViewProduct();
	   
	}

	@Then("Product details page should be displayed")
	public void product_details_page_should_be_displayed() {
		
		util.waitForURL("product_details");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/product_details/"));
	}

	@When("User clicks Add to Cart for a product")
	public void user_clicks_add_to_cart_for_a_product() {
		home.clickAddtoCart();
	}

	@Then("Product should be added to cart successfully")
	public void product_should_be_added_to_cart_successfully() {
		util.waitForVisibility(home.AddedMessage());
	    Assert.assertTrue(home.AddedMessage().isDisplayed());
	  
	}

	@Then("Brands section should be displayed")
	public void brands_section_should_be_displayed() {
		actions.moveToElement(home.BrandsSection()).perform();
		Assert.assertTrue(home.BrandsSection().isDisplayed());
		
	}

	@Then("Brand names should be listed")
	public void brand_names_should_be_listed() {

	    List<WebElement> brands = home.getBrandNames();

	    Assert.assertTrue(brands.size() > 0);

	    for (WebElement brand : brands) {

	        Assert.assertTrue(
	                brand.isDisplayed());
	    }
	}

	@When("User clicks on a brand")
	public void user_clicks_on_a_brand() {

	    home.clickFirstBrand();
	}
	@Then("Brand products page should be displayed")
	public void brand_products_page_should_be_displayed() {

	    Assert.assertTrue(driver.getCurrentUrl().contains("/brand_products/"));
	}

	@When("User scrolls down the page")
	public void user_scrolls_down_the_page() {

	    home.scrollToBottom();
	}

	@Then("Scroll Up button should be visible")
	public void scroll_up_button_should_be_visible() {

	    Assert.assertTrue(home.getScrollUpButton().isDisplayed());
	}

	@When("User clicks Scroll Up button")
	public void user_clicks_scroll_up_button() {

	    home.clickScrollUpButton();
	}

	@Then("User should be navigated to the top of the page")
	public void user_should_be_navigated_to_the_top_of_the_page() {
		util.waitForVisibility(home.HomePageText());
	    Assert.assertTrue(home.HomePageText().isDisplayed());
	}

	@When("User scrolls to bottom of page")
	public void user_scrolls_to_bottom_of_page() {
	   home.scrollToBottom();
	   
	}

	@Then("Footer should be displayed")
	public void footer_should_be_displayed() {
	  home.Footer().isDisplayed();
	  
	}

	@When("User enters valid email address")
	public void user_enters_valid_email_address() {

	    home.enterSubscriptionEmail("Rakesh@gmail.com");
	}
	@When("User clicks Subscribe button")
	public void user_clicks_subscribe_button() {

	    home.clickSubscribeButton();
	}

	@Then("Subscription success message should be displayed")
	public void subscription_success_message_should_be_displayed() {
	    Assert.assertTrue(home.isSubscriptionSuccessMessageDisplayed());
	}

}
