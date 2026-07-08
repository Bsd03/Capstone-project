package StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoryPage;
import utilities.ExplicitWaitUtil;

public class D_CategorySteps{

    // Create CategoryPage object
	
    WebDriver driver = Hooks.driver;
    CategoryPage categoryPage = new CategoryPage(driver);
    ExplicitWaitUtil explicitWaitutil=new ExplicitWaitUtil(driver);
    @Given("User launches the browser")
    public void User_launches_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Launching Browser");
    }
    @Given("User navigates to Automation Exercise Website")
    public void user_navigates_to_automation_exercise_website() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Navigated to Automation Exercise Website");
    }
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Verifying Home Page");
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
    }
    // ========================= WOMEN CATEGORY =========================

    // Click on Women category
    @When("User clicks on Women category")
    public void user_clicks_on_women_category() {

        categoryPage.click_Women_Category();
        System.out.println("Women Category Clicked");

    }

    // Click on Dress subcategory
    @And("User clicks on Dress subcategory")
    public void user_clicks_on_dress_subcategory() {

    	categoryPage.click_Dress_Category();

    	categoryPage.handleGoogleVignette(() -> {

    	    categoryPage.click_Women_Category();
    	    categoryPage.click_Dress_Category();

    	});

    }
    // Verify Dress category page title is displayed.
    @Then("User should see Dress category title")
    public void User_should_see_Dress_category_title() {
        System.out.println("Women Dress Category Verifying__");

        String actualTitle = categoryPage.getBrandTitle();
        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("DRESS") || actualTitle.contains("Dress"),
                "Category page is not displayed.");
    }

    // Click on Tops subcategory
    @And("User clicks on Tops subcategory")
    public void user_clicks_on_tops_subcategory() {

        System.out.println("Women Tops Category Clicked");
        categoryPage.click_Tops_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Women_Category();
            categoryPage.click_Tops_Category();

        });
      

    }
    // Verify tops category page title
    @Then("User should see Top category page title")
    public void User_should_see_Top_category_title() {
        System.out.println("Women Tops Category Verifying__");
      
        String actualTitle = categoryPage.getBrandTitle();
        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("TOPS") || actualTitle.contains("Tops"),
                "Category page is not displayed.");

    }

    // Click on Saree subcategory
    @And("User clicks on Saree subcategory")
    public void user_clicks_on_saree_subcategory() {

    	categoryPage.click_Saree_Category();

    	categoryPage.handleGoogleVignette(() -> {

    	    categoryPage.click_Women_Category();
    	    categoryPage.click_Saree_Category();

    	});

        System.out.println("Women Saree Category Clicked");

    }
    // Verify Saree category page title
    @Then("User should see Saree page title")
    public void User_should_see_Saree_category_title() {
        System.out.println("Women Saree Category Verifying__");
        System.out.println(driver.getCurrentUrl());
     
        String actualTitle = categoryPage.getBrandTitle();

        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("SAREE") || actualTitle.contains("Saree"),
                "Category page is not displayed.");
    }
    // ========================= MEN CATEGORY =========================

    // Click on Men category
    @When("User clicks on Men category")
    public void user_clicks_on_men_category() {

        categoryPage.click_Men_Category();
        System.out.println("men Category click");
    }

    // Click on Tshirts subcategory
    @And("User clicks on Tshirt subcategory")
    public void user_clicks_on_tshirt_subcategory() {
    	categoryPage.click_Tshirt_Category();

    	categoryPage.handleGoogleVignette(() -> {

    	    categoryPage.click_Men_Category();
    	    categoryPage.click_Tshirt_Category();

    	});
      
        System.out.println("men  Category  Tshirt click");
    }
    @Then("User should see Tshirt category page title")
    public void User_should_see_Tshirt_category_title() {
        System.out.println("men Category Tshirt Verifying__");
   
        String actualTitle = categoryPage.getBrandTitle();

        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("TSHIRTS") || actualTitle.contains("Tshirts"),
                "Category page is not displayed.");
    }
    // Click on Jeans subcategory
    @And("User clicks on Jeans subcategory")
    public void user_clicks_on_jeans_subcategory() {
    	categoryPage.click_Jeans_Category();

    	categoryPage.handleGoogleVignette(() -> {

    	    categoryPage.click_Men_Category();
    	    categoryPage.click_Jeans_Category();

    	});
        System.out.println("men Jeans Category click");
    }
    @Then("User should see Jeans category page title")
    public void User_should_see_Jeans_category_title() {
        System.out.println("men Category Jeans Verifying__");
      
        String actualTitle = categoryPage.getBrandTitle();

        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("JEANS") || actualTitle.contains("Jeans"),
                "Category page is not displayed.");
    }
    // ========================= KIDS CATEGORY =========================

    // Click on Kids category
    @When("User clicks on Kids category")
    public void user_clicks_on_kids_category() {

        categoryPage.click_Kids_Category();
        System.out.println("clicked on Kids Category");
    }

    // Click on Kids Dress subcategory
    @And("User clicks on Kids Dress subcategory")
    public void user_clicks_on_kids_dress_subcategory() {

    	categoryPage.click_KidsDress_Category();

    	categoryPage.handleGoogleVignette(() -> {

    	    categoryPage.click_Kids_Category();
    	    categoryPage.click_KidsDress_Category();

    	});;
        System.out.println("clicked on Kids Dress Category");
    }
    @Then("User should see Dress page title")
    public void User_should_see_Dress_page_title() {
        System.out.println("Verifying on Kids Dress Category");
      
        String actualTitle = categoryPage.getBrandTitle();

        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("DRESS") || actualTitle.contains("Dress"),
                "Category page is not displayed.");
    }
    // Click on Tops & Shirts subcategory
    @And("User clicks on Tops & Shirts subcategory")
    public void user_clicks_on_tops_and_shirts_subcategory() {

    	categoryPage.click_TopsAndShirts_Category();

    	categoryPage.handleGoogleVignette(() -> {

    	    categoryPage.click_Kids_Category();
    	    categoryPage.click_TopsAndShirts_Category();

    	});
        System.out.println("clicked on Kids Tops & Shirts Category");

    }
    @Then("User should see Tops & Shirts  page title")
    public void User_should_see_Tops_Shirts_title() {
        System.out.println("Verifying on Kids Tops & Shirts Category");
     
        String actualTitle = categoryPage.getBrandTitle();

        System.out.println(actualTitle);


        Assert.assertTrue(actualTitle.contains("Tops & Shirts") || actualTitle.contains("TOPS & SHIRTS"),
                "Category page is not displayed.");
    }
    // ========================= VALIDATION =========================



}