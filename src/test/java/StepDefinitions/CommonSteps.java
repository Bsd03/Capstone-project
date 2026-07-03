package StepDefinitions;

import org.junit.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;

public class CommonSteps {

    ProductsPage productsPage = new ProductsPage(Hooks.driver);

    @When("the user clicks on the {string} menu")
    public void the_user_clicks_on_the_menu(String menu) {

        if(menu.equalsIgnoreCase("Products")) {

            productsPage.clickProducts();

        }

    }

    @Then("the All Products page should be displayed")
    public void the_all_products_page_should_be_displayed() {

        Assert.assertTrue(
                Hooks.driver.getCurrentUrl().contains("/products"));

    }

}