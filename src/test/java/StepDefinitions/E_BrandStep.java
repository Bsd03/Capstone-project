package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrandsPage;

public class E_BrandStep {
	private static final Logger logger=LogManager.getLogger(E_BrandStep.class);
    BrandsPage brandsPage = new BrandsPage(Hooks.driver);
    // Verify Brands Section
    @Then("the Brands section should be visible on the left side")
    public void the_brands_section_should_be_visible_on_the_left_side() {
    		logger.info("Verifying Brands section visibility");
        brandsPage.verifyBrandsSection();
        logger.info("Brands section verified successfully");
    }

    // Verify Brand Names
    @And("all available brand names should be displayed")
    public void all_available_brand_names_should_be_displayed() {
    		logger.info("Verifying all available brand names");
        brandsPage.verifyBrandNames();
        logger.info("All brand names displayed successfully");
    }

    // Click Any Brand
    @When("the user clicks on {string} brand")
    public void the_user_clicks_on_brand(String brandName) {
    		logger.info("Clicking on brand : {}",brandName);
        brandsPage.clickBrand(brandName);
        logger.info("Successfully clicked brand : {}",brandName);
    }
 // Verify All Products Page
    @Then("the All Products page should be displayed")
    public void the_all_products_page_should_be_displayed() {
        logger.info("Verifying All Products page is displayed");

        Assert.assertTrue(
            brandsPage.isAllProductsPageDisplayed(),
            "All Products page is not displayed"
        );

        logger.info("All Products page displayed successfully");
    }

    // Verify Brand Page
    @Then("the {string} brand page should be displayed")
    public void the_brand_page_should_be_displayed(String brandName) {
    		logger.info("Verifying brand page for: {}",brandName);
        brandsPage.verifyBrandPage(brandName);
        logger.info("{} brand page displayed successfully",brandName);
    }

    // Verify Products Displayed
    @And("all displayed products should belong to {string}")
    public void all_displayed_products_should_belong_to(String brandName) {
    		logger.info("Verifying products displayed for brand: {}",brandName);
        brandsPage.verifyProductsDisplayed();
        logger.info("Products displayed successfully");
    }

    // Verify Products after Switching Brands
    @Then("the {string} products should be displayed")
    public void the_products_should_be_displayed(String brandName) {
    		logger.info("Verifying switched brand products for: {}",brandName);
        brandsPage.verifyProductsDisplayed();
        logger.info("{} products displayed successfully",brandName);
    }

    // Verify URL
    @And("the URL should contain {string}")
    public void the_url_should_contain(String urlText) {
    		logger.info("Verifying URL contains: {}",urlText);
        Assert.assertTrue(brandsPage.getCurrentPageURL().contains(urlText));
        logger.info("URL verification successful");
    }

    // Open First Product
    @And("the user opens the first product")
    public void the_user_opens_the_first_product() {
    		logger.info("Opening first product");
        brandsPage.openFirstProduct();
        logger.info("First product opened successfully");
    }

    // Verify Product Name
    @Then("the Brands Page product name should be displayed")
    public void the_Brands_Page_product_name_should_be_displayed() {
    		logger.info("Verifying product name");
        brandsPage.verifyProductName();
        logger.info("Product name verified successfully");
    }

    // Verify Product Category
    @And("the Brands Page product category should be displayed")
    public void the_Brands_Page_product_category_should_be_displayed() {
    		logger.info("Verifying product category");
        brandsPage.verifyCategory();
        logger.info("Product category verified successfully");
    }

    // Verify Product Price
    @And("the Brands Page product price should be displayed")
    public void the_Brands_Page_product_price_should_be_displayed() {
    		logger.info("Verifying product price");
        brandsPage.verifyPrice();
        logger.info("Product price verified successfully");
    }

    // Verify Product Availability
    @And("the Brands Page product availability should be displayed")
    public void the_Brands_Page_product_availability_should_be_displayed() {
    		logger.info("Verifying product availability");
        brandsPage.verifyAvailability();
        logger.info("Product availability verified successfully");
    }

    // Verify Product Brand
    @And("the Brands Page product brand should be {string}")
    public void the_Brands_Page_product_brand_should_be(String brandName) {
    		logger.info("Verifying product brand: {}",brandName);
        brandsPage.verifyBrand(brandName);
        logger.info("Product brand verified successfully");
    }

    // Add Product to Cart
    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
    		logger.info("Adding first product to cart");
        brandsPage.addFirstProductToCart();
        logger.info("Product added to cart successfully");
    }

    // Open Cart
    @When("User opens the cart from Brands page")
    public void  User_opens_the_cart_from_Brands_page() {
    		logger.info("Opening cart from Brands page");
        brandsPage.openCart();
        logger.info("Cart opened successfully");
    }

    // Verify Product in Cart
    @Then("the selected {string} product should be displayed in the cart")
    public void the_selected_product_should_be_displayed_in_the_cart(String brandName) {
    		logger.info("Verifying selected product in cart for brand: {}",brandName);
        brandsPage.verifyCartProduct();
        logger.info("Product verified successfully in cart");
    }
}