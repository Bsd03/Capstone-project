package StepDefinitions;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
 
import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;
 
public class F_ProductSteps {
 
    private static final Logger logger =
            LogManager.getLogger(F_ProductSteps.class);
 
  WebDriver driver=Hooks.driver;
  ProductsPage productsPage= new ProductsPage(driver);
 
    private String productId;
    private String productName;

    // Constructor
   // public ProductSteps() {
     //   this.driver = Hooks.driver;
       // this.productsPage = new ProductsPage(driver);
   // }
 
    // -------------------------------------------------
    // Click Products menu
    // Feature:
    // When the user clicks on the "Products" menu
    // -------------------------------------------------
    
    @Given("the user navigates to Automation exercise Website")
    public void the_user_navigates_to_automation_exercise_website() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	System.out.println("Navigated to the automation website");
    }
    @Then("the Products Page of All Products page should be displayed")
    public void the_products_page_of_all_products_page_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Verifying All Products page");
 
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/products"),
                "All Products page is not displayed"
        );
    }
    
    
    @When("the user clicks on the {string} menu")
    public void the_user_clicks_on_the_menu(String menu) {
 
        logger.info("Clicking menu: " + menu);
 
        if (menu.equalsIgnoreCase("Products")) {
            productsPage.clickProducts();
        } else {
            Assert.fail("Unsupported menu: " + menu);
        }
    }
 
    // -------------------------------------------------
    // Verify All Products page
    // Feature:
    // Then the All Products page should be displayed
//    // -------------------------------------------------
//    @Then("the Products Page All Products page should be displayed")
//    public void the_Products_Page_all_products_page_should_be_displayed() {
// 
//        logger.info("Verifying All Products page");
// 
//        Assert.assertTrue(
//                driver.getCurrentUrl().contains("/products"),
//                "All Products page is not displayed"
//        );
//    }
// 
    // -------------------------------------------------
    // Verify all products list
    // -------------------------------------------------
    @Then("the list of all products should be displayed")
    public void the_list_of_all_products_should_be_displayed() {
 
        logger.info("Verifying product list");
        
        int productCount = driver.findElements(
                By.xpath("//div[contains(@class,'product-image-wrapper')]")
        ).size();
 
        Assert.assertTrue(
                productCount > 0,
                "No products are displayed"
        );
    }
 
    // -------------------------------------------------
    // Open selected product
    // -------------------------------------------------
    @When("the user opens the {string} product")
    public void the_user_opens_the_product(String product) {
 
        logger.info("Opening product: " + product);
 
        productName = product;
        
        if(productName.equals("Blue Top")) {
            productsPage.clickBluetop();
            System.out.println("Blue top clicked");
        }
        else if(productName.equals("Men Tshirt")) {
        	productsPage.clickMenTshirt();
        	System.out.println("Men Tshirt Clikced");
        	
        }
        else {
        	
        	productsPage.clickSleevelessDress();
        	System.out.println("Sleeveless Dress Clicked");
        	
        }
       
    }
 
    // -------------------------------------------------
    // Verify product details page
    // -------------------------------------------------
    @Then("the product details page should be displayed")
    public void the_product_details_page_should_be_displayed() {
    	System.out.println("verifing");
    	System.out.println("Current URL: " + driver.getCurrentUrl());
        logger.info("Verifying Product Details page");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("/product_details/"),
                "User is not navigated to Product Details page. Current URL: " + currentUrl
        );
    }
 
    // -------------------------------------------------
    // Verify product name
    // -------------------------------------------------
    @Then("the product name should be displayed")
    public void the_product_name_should_be_displayed() {

        logger.info("Verifying Product Name");

        WebElement name = driver.findElement(
                By.xpath("//div[@class='product-information']/h2")
        );

        Assert.assertTrue(
                name.isDisplayed(),
                "Product name is not displayed"
        );

        String actualName = name.getText().replaceAll("\\s+", " ").trim();
        String expectedName = productName.replaceAll("\\s+", " ").trim();

        Assert.assertEquals(
                actualName,
                expectedName,
                "Wrong product name displayed"
        );
    }
   
    // -------------------------------------------------
    // Verify category
    // -------------------------------------------------
    @Then("the product category should be displayed")
    public void the_product_category_should_be_displayed() {
 
        logger.info("Verifying Product Category");
 
        WebElement category = driver.findElement(
                By.xpath("//div[@class='product-information']/p[1]")
        );
 
        Assert.assertTrue(
                category.isDisplayed(),
                "Product category is not displayed"
        );
 
        Assert.assertTrue(
                category.getText().contains("Category"),
                "Category text is not displayed"
        );
    }
 
    // -------------------------------------------------
    // Verify price
    // -------------------------------------------------
    @Then("the product price should be displayed")
    public void the_product_price_should_be_displayed() {
 
        logger.info("Verifying Product Price");
 
        WebElement price = driver.findElement(
                By.xpath("//div[@class='product-information']//span/span")
        );
 
        Assert.assertTrue(
                price.isDisplayed(),
                "Product price is not displayed"
        );
    }
 
    // -------------------------------------------------
    // Verify availability
    // -------------------------------------------------
    @Then("the product availability should be displayed")
    public void the_product_availability_should_be_displayed() {
 
        logger.info("Verifying Product Availability");
 
        Assert.assertTrue(
                driver.getPageSource().contains("Availability"),
                "Product availability is not displayed"
        );
    }
 
    // -------------------------------------------------
    // Verify condition
    // -------------------------------------------------
    @Then("the product condition should be displayed")
    public void the_product_condition_should_be_displayed() {
 
        logger.info("Verifying Product Condition");
 
        Assert.assertTrue(
                driver.getPageSource().contains("Condition"),
                "Product condition is not displayed"
        );
    }
 
    // -------------------------------------------------
    // Verify brand
    // -------------------------------------------------
    @Then("the product brand should be displayed")
    public void the_product_brand_should_be_displayed() {
 
        logger.info("Verifying Product Brand");
 
        Assert.assertTrue(
                driver.getPageSource().contains("Brand"),
                "Product brand is not displayed"
        );
    }
 
    // -------------------------------------------------
    // Search product
    // -------------------------------------------------
    @When("the user searches for {string}")
    public void the_user_searches_for(String product) {
 
        logger.info("Searching product: " + product);
 
        productName = product;
 
        productsPage.searchProduct(product);
    }
 
    // -------------------------------------------------
    // Verify searched products page
    // -------------------------------------------------
    @Then("the searched products page should be displayed")
    public void the_searched_products_page_should_be_displayed() {
 
        logger.info("Verifying Searched Products page");
 
        WebElement searchedProductsHeading =
                driver.findElement(
                        By.xpath("//h2[contains(text(),'Searched Products')]")
                );
 
        Assert.assertTrue(
                searchedProductsHeading.isDisplayed(),
                "Searched Products page is not displayed"
        );
    }
 
    // -------------------------------------------------
    // Verify searched product
    // -------------------------------------------------
    @Then("the searched product {string} should be displayed")
    public void the_searched_product_should_be_displayed(String product) {

        logger.info("Verifying searched product: " + product);

        boolean found = false;

        for (WebElement element : driver.findElements(
                By.xpath("//div[@class='productinfo text-center']/p"))) {

            String actualProduct =
                    element.getText().replaceAll("\\s+", " ").trim();

            String expectedProduct =
                    product.replaceAll("\\s+", " ").trim();

            if (actualProduct.equalsIgnoreCase(expectedProduct)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(
                found,
                "Searched product is not displayed: " + product
        );
    }
 
    // -------------------------------------------------
    // Click Add to Cart
    // -------------------------------------------------
    @When("the user clicks the Add to Cart button")
    public void the_user_clicks_the_add_to_cart_button() {
 
      productsPage.addToCart();
     
 
        
    }
 
    // -------------------------------------------------
    // Open cart
    // -------------------------------------------------
    @When("the user opens the cart")
    public void the_user_opens_the_cart() {
 
        logger.info("Opening Cart");
       
        System.out.println("opening cart");
        productsPage.viewCartFromPopup(); 
        
    }
 
    // -------------------------------------------------
    // Verify product in cart
    // -------------------------------------------------
    @Then("the product {string} should be displayed in the cart")
    public void the_product_should_be_displayed_in_the_cart(String product) {

        logger.info("Verifying cart product: " + product);

        boolean productDisplayed =
                driver.findElements(
                        By.xpath("//td[@class='cart_description']//a[text()='"
                                + product + "']")
                ) .size() > 0;

        Assert.assertTrue(
                productDisplayed,
                "Product not displayed in cart: " + product
        );
    }
    // -------------------------------------------------
    // Change quantity
    // -------------------------------------------------
    @When("the user changes the quantity to {string}")
    public void the_user_changes_the_quantity_to(String quantity) {
 
        logger.info("Changing quantity to: " + quantity);
        
        productsPage.increaseQuantity(quantity);
    }
    
    //Verify quantity
    
    @Then("the product quantity should be {string}")
    public void the_product_quantity_should_be(String quantity) {
    	 
    	logger.info("Verifying quantity:" + quantity);
    	
    	String actualQuantity = driver.findElement(By.xpath("//td[contains(@class,'cart_quantity')]//button")).getText().trim();
    	
    	Assert.assertEquals(actualQuantity, quantity, "Product quantity does not match");
    }
    }
 