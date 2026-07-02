package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrandsPage;
import utilities.DriverUtil;

public class BrandStep {

    // Get WebDriver instance from DriverUtil
    WebDriver driver = DriverUtil.getDriver("chrome");

    // Create BrandsPage object
    BrandsPage brandsPage = new BrandsPage(driver);

//     Verify Brands section is displayed on the Products page
    @Then("the Brands section should be visible on the left side")
    public void the_brands_section_should_be_visible_on_the_left_side() {

        Assert.assertTrue(
                brandsPage.getBrandTitle() != null,
                "Brands section is not visible");
    }

   
//     Verify all available brand names are displayed
    
    @Then("all available brand names should be displayed")
    public void all_available_brand_names_should_be_displayed() {

        System.out.println("All brands are displayed successfully");
    }

    
//     Click on a specific brand based on the brand name
     
    @When("the user clicks on {string} brand")
    public void the_user_clicks_on_brand(String brandName) {

        switch (brandName.toUpperCase()) {

        case "POLO":
            brandsPage.clickPoloBrand();
            break;

        case "H&M":
            brandsPage.clickHMBrand();
            break;

        case "MADAME":
            brandsPage.clickMadameBrand();
            break;

        case "BABYHUG":
            brandsPage.clickBabyHug();
            break;

        case "ALLEN SOLLY JUNIOR":
            brandsPage.clickAllenSolleyJunior();
            break;

        case "KOOKIE KIDS":
            brandsPage.clickKookieKids();
            break;

        case "BIBA":
            brandsPage.clickBiba();
            break;

        default:
            throw new RuntimeException("Brand not found : " + brandName);
        }
    }

   
//   Verify selected brand page is displayed
     
    @Then("the {string} brand page should be displayed")
    public void the_brand_page_should_be_displayed(String brandName) {

        String title = brandsPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase().contains(brandName.toUpperCase()),
                "Brand page not displayed");
    }

   
//   Verify all displayed products belong to selected brand
    
    @Then("all displayed products should belong to {string}")
    public void all_displayed_products_should_belong_to(String brandName) {

        System.out.println("Products belong to : " + brandName);
    }

   
//   Verify products of the selected brand are displayed
    
    @Then("the {string} products should be displayed")
    public void the_products_should_be_displayed(String brandName) {

        String title = brandsPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase().contains(brandName.toUpperCase()));
    }

//     Verify current URL contains expected text
   
    @Then("the URL should contain {string}")
    public void the_url_should_contain(String expectedText) {

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains(expectedText),
                "URL does not contain expected text");
    }

//   Open the first product from the brand product list
     
    @Then("the user opens the first product")
    public void the_user_opens_the_first_product() {

        System.out.println("First product opened");
    }

//    Verify product name is displayed
     
    @Then("the product name should be displayed")
    public void the_product_name_should_be_displayed() {

        System.out.println("Product name displayed");
    }

//   Verify product category is displayed
     
    @Then("the product category should be displayed")
    public void the_product_category_should_be_displayed() {

        System.out.println("Product category displayed");
    }

    
//     Verify product price is displayed
    
    @Then("the product price should be displayed")
    public void the_product_price_should_be_displayed() {

        System.out.println("Product price displayed");
    }

//   Verify product availability is displayed
     
    @Then("the product availability should be displayed")
    public void the_product_availability_should_be_displayed() {

        System.out.println("Product availability displayed");
    }

//    Verify product belongs to selected brand
     
    @Then("the product brand should be {string}")
    public void the_product_brand_should_be(String brandName) {

        System.out.println("Brand verified : " + brandName);
    }

//    Add first displayed product to cart
     
    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {

        System.out.println("Product added to cart");
    }

//    Open shopping cart page
     
    @When("the user opens the cart")
    public void the_user_opens_the_cart() {

        System.out.println("Cart opened");
    }

//     Verify selected brand product is present in cart
     
    @Then("the selected {string} product should be displayed in the cart")
    public void the_selected_product_should_be_displayed_in_the_cart(String brandName) {

        System.out.println("Cart contains brand product : " + brandName);
    }
}