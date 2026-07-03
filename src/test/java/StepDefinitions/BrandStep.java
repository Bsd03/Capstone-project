package StepDefinitions;

import org.junit.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrandsPage;

public class BrandStep {

    BrandsPage brandsPage = new BrandsPage(Hooks.driver);

    // Verify Brands Section
    @Then("the Brands section should be visible on the left side")
    public void the_brands_section_should_be_visible_on_the_left_side() {
        brandsPage.verifyBrandsSection();
    }

    // Verify Brand Names
    @And("all available brand names should be displayed")
    public void all_available_brand_names_should_be_displayed() {
        brandsPage.verifyBrandNames();
    }

    // Click Any Brand
    @When("the user clicks on {string} brand")
    public void the_user_clicks_on_brand(String brandName) {
        brandsPage.clickBrand(brandName);
    }

    // Verify Brand Page
    @Then("the {string} brand page should be displayed")
    public void the_brand_page_should_be_displayed(String brandName) {
        brandsPage.verifyBrandPage(brandName);
    }

    // Verify Products Displayed
    @And("all displayed products should belong to {string}")
    public void all_displayed_products_should_belong_to(String brandName) {
        brandsPage.verifyProductsDisplayed();
    }

    // Verify Products after Switching Brands
    @Then("the {string} products should be displayed")
    public void the_products_should_be_displayed(String brandName) {
        brandsPage.verifyProductsDisplayed();
    }

    // Verify URL
    @And("the URL should contain {string}")
    public void the_url_should_contain(String urlText) {
        Assert.assertTrue(brandsPage.getCurrentPageURL().contains(urlText));
    }

    // Open First Product
    @And("the user opens the first product")
    public void the_user_opens_the_first_product() {
        brandsPage.openFirstProduct();
    }

    // Verify Product Name
    @Then("the product name should be displayed")
    public void the_product_name_should_be_displayed() {
        brandsPage.verifyProductName();
    }

    // Verify Product Category
    @And("the product category should be displayed")
    public void the_product_category_should_be_displayed() {
        brandsPage.verifyCategory();
    }

    // Verify Product Price
    @And("the product price should be displayed")
    public void the_product_price_should_be_displayed() {
        brandsPage.verifyPrice();
    }

    // Verify Product Availability
    @And("the product availability should be displayed")
    public void the_product_availability_should_be_displayed() {
        brandsPage.verifyAvailability();
    }

    // Verify Product Brand
    @And("the product brand should be {string}")
    public void the_product_brand_should_be(String brandName) {
        brandsPage.verifyBrand(brandName);
    }

    // Add Product to Cart
    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
        brandsPage.addFirstProductToCart();
    }

    // Open Cart
    @And("the user opens the cart")
    public void the_user_opens_the_cart() {
        brandsPage.openCart();
    }

    // Verify Product in Cart
    @Then("the selected {string} product should be displayed in the cart")
    public void the_selected_product_should_be_displayed_in_the_cart(String brandName) {
        brandsPage.verifyCartProduct();
    }
}