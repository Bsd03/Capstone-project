package StepDefinitions;

import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrandsPage;
import pages.ProductsPage;

public class E_BrandStep {

    BrandsPage brandsPage = new BrandsPage(Hooks.driver);
//    ProductsPage productsPage = new ProductsPage(Hooks.driver);
//    
    
// // Click Products Menu
//    @When("the user clicks on the {string} menu")
//    public void the_user_clicks_on_the_menu(String menu) {
//
//        if (menu.equalsIgnoreCase("Products")) {
//            productsPage.clickProducts();
//        }
//    }

    // Verify All Products Page
//    @Then("the All Products page should be displayed")
//    public void the_all_products_page_should_be_displayed() {
//
//        Assert.assertTrue(
//                Hooks.driver.getCurrentUrl().contains("/products"));
//    }

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
    @Then("the Brands Page product name should be displayed")
    public void the_Brands_Page_product_name_should_be_displayed() {
        brandsPage.verifyProductName();
    }

    // Verify Product Category
    @And("the Brands Page product category should be displayed")
    public void the_Brands_Page_product_category_should_be_displayed() {
        brandsPage.verifyCategory();
    }

    // Verify Product Price
    @And("the Brands Page product price should be displayed")
    public void the_Brands_Page_product_price_should_be_displayed() {
        brandsPage.verifyPrice();
    }

    // Verify Product Availability
    @And("the Brands Page product availability should be displayed")
    public void the_Brands_Page_product_availability_should_be_displayed() {
        brandsPage.verifyAvailability();
    }

    // Verify Product Brand
    @And("the Brands Page product brand should be {string}")
    public void the_Brands_Page_product_brand_should_be(String brandName) {
        brandsPage.verifyBrand(brandName);
    }

    // Add Product to Cart
    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
        brandsPage.addFirstProductToCart();
    }

    // Open Cart
    @When("User opens the cart from Brands page")
    public void  User_opens_the_cart_from_Brands_page() {
        brandsPage.openCart();
    }

    // Verify Product in Cart
    @Then("the selected {string} product should be displayed in the cart")
    public void the_selected_product_should_be_displayed_in_the_cart(String brandName) {
        brandsPage.verifyCartProduct();
    }
}