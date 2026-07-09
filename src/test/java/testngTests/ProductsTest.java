package testngTests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClassTestng;
import pages.ProductsPage;
import utilities.ExcelReader;

public class ProductsTest extends BaseClassTestng {

    private ProductsPage productsPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void initializeProductsPage() {

        productsPage = new ProductsPage(driver);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));

        System.out.println(
                "ProductsPage initialized successfully");
    }
    
    
    // =========================================================
    // COMMON METHOD 1
    // OPEN PRODUCTS PAGE
    // =========================================================

    private void openProductsPage() {

        productsPage.clickProducts();

        handleGoogleVignette();

        wait.until(
                ExpectedConditions.urlContains("/products"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("search_product")));

        System.out.println(
                "Products page opened successfully");
    }


    // =========================================================
    // COMMON METHOD 2
    // HANDLE GOOGLE VIGNETTE AD
    // =========================================================

    private void handleGoogleVignette() {

        try {

            if (driver.getCurrentUrl()
                    .contains("#google_vignette")) {

                System.out.println(
                        "Google vignette detected");

                ((JavascriptExecutor) driver)
                        .executeScript(
                                "window.location.hash='';");

                wait.until(d ->
                        !d.getCurrentUrl()
                                .contains("#google_vignette"));

                System.out.println(
                        "Google vignette removed");
            }

        } catch (Exception e) {

            System.out.println(
                    "No Google vignette handling required");
        }
    }


    // =========================================================
    // COMMON METHOD 3
    // OPEN PRODUCT DETAILS SAFELY
    // =========================================================

    private void openProductDetailsSafely(String id) {

        openProductsPage();

        By productLink = By.xpath(
                "//a[@href='/product_details/"
                        + id + "']");

        WebElement link = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        productLink));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView("
                        + "{block:'center'});",
                        link);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // First attempt using existing ProductsPage
        productsPage.viewProduct(id);

        // Check if Google ad intercepted navigation
        if (driver.getCurrentUrl()
                .contains("#google_vignette")) {

            System.out.println(
                    "Google vignette intercepted product "
                    + id);

            handleGoogleVignette();

            // Find element again because DOM may change
            WebElement retryLink = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            productLink));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            retryLink);
        }

        // If normal navigation still did not happen,
        // navigate using the real href of existing element
        try {

            wait.until(
                    ExpectedConditions.urlContains(
                            "/product_details/" + id));

        } catch (TimeoutException e) {

            System.out.println(
                    "Normal click intercepted. "
                    + "Using existing product href.");

            WebElement existingLink = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            productLink));

            String href =
                    existingLink.getAttribute("href");

            Assert.assertNotNull(
                    href,
                    "Product href is null for ID: " + id);

            driver.get(href);

            wait.until(
                    ExpectedConditions.urlContains(
                            "/product_details/" + id));
        }

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(
                                ".product-information h2")));

        System.out.println(
                "Product details opened for ID: " + id);
    }


    // =========================================================
    // TEST 1
    // VERIFY PRODUCTS PAGE
    // =========================================================

    @Test(priority = 1)
    public void verifyProductsPageDisplayed() {

        openProductsPage();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("/products"),
                "Products page is not displayed");

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("search_product")));

        Assert.assertTrue(
                searchBox.isDisplayed(),
                "Search box is not displayed");

        System.out.println(
                "Products page displayed successfully");
    }


    // =========================================================
    // TEST 2
    // VERIFY PRODUCTS DISPLAYED
    // =========================================================

    @Test(priority = 2)
    public void verifyProductsAreDisplayed() {

        openProductsPage();

        List<WebElement> products = wait.until(
                ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(
                                By.cssSelector(
                                        ".features_items "
                                        + ".product-image-wrapper")));

        Assert.assertTrue(
                products.size() > 0,
                "No products are displayed");

        System.out.println(
                "Total products displayed: "
                        + products.size());
    }


    // =========================================================
    // SEARCH DATA
    // =========================================================

    @DataProvider(name = "searchData")
    public Object[][] searchData() {

        return new Object[][] {
                {"Blue Top"},
                {"Men Tshirt"},
                {"Dress"}
        };
    }


    // =========================================================
    // TEST 3
    // VERIFY SEARCH PRODUCT
    // =========================================================

    @Test(
        priority = 3,
        dataProvider = "searchData"
    )
    public void verifySearchProduct(
            String searchText) {

        openProductsPage();

        productsPage.searchProduct(searchText);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//h2[contains("
                                + "translate(normalize-space(.),"
                                + "'abcdefghijklmnopqrstuvwxyz',"
                                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ'),"
                                + "'SEARCHED PRODUCTS')]")));

        List<WebElement> resultNames =
                wait.until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By.cssSelector(
                                                ".features_items "
                                                + ".productinfo p")));

        Assert.assertTrue(
                resultNames.size() > 0,
                "No search results displayed for: "
                        + searchText);

        boolean matchingProductFound = false;

        String normalizedSearch =
                searchText.toLowerCase().trim();

        for (WebElement product : resultNames) {

            String productName =
                    product.getText()
                            .toLowerCase()
                            .trim();

            System.out.println(
                    "Search result: " + productName);

            // Flexible matching
            if (productName.contains(normalizedSearch)
                    || normalizedSearch.contains(productName)) {

                matchingProductFound = true;
                break;
            }

            // Word-by-word matching
            String[] words =
                    normalizedSearch.split("\\s+");

            boolean allWordsFound = true;

            for (String word : words) {

                if (!productName.contains(word)) {
                    allWordsFound = false;
                    break;
                }
            }

            if (allWordsFound) {
                matchingProductFound = true;
                break;
            }
        }

        Assert.assertTrue(
                matchingProductFound,
                "Search result not found for: "
                        + searchText);

        System.out.println(
                "Search successful for: "
                        + searchText);
    }


    // =========================================================
    // PRODUCT IDS
    // =========================================================

    @DataProvider(name = "productIds")
    public Object[][] productIds() {

        return new Object[][] {
                {"1"},
                {"2"},
                {"3"}
        };
    }


    // =========================================================
    // TEST 4
    // VERIFY VIEW PRODUCT
    // =========================================================

    @Test(
        priority = 4,
        dataProvider = "productIds"
    )
    public void verifyViewProduct(String id) {

        openProductDetailsSafely(id);

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains(
                                "/product_details/" + id),
                "Product details page not opened "
                        + "for ID: " + id);

        WebElement productName = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.cssSelector(
                                        ".product-information h2")));

        Assert.assertTrue(
                productName.isDisplayed(),
                "Product name is not displayed");

        System.out.println(
                "Product details displayed: "
                        + productName.getText());
    }


    // =========================================================
    // TEST 5
    // VERIFY PRODUCT DETAILS
    // =========================================================

    @Test(priority = 5)
    public void verifyProductDetails() {

        // Always explicitly open a product first
        openProductDetailsSafely("1");

        WebElement productName = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.cssSelector(
                                        ".product-information h2")));

        WebElement category = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.xpath(
                                        "//div[contains("
                                        + "@class,'product-information')]"
                                        + "/p[contains(.,'Category:')]")));

        WebElement price = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.cssSelector(
                                        ".product-information "
                                        + "span span")));

        WebElement availability = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.xpath(
                                        "//div[contains("
                                        + "@class,'product-information')]"
                                        + "/p[b[contains("
                                        + ".,'Availability:')]]")));

        WebElement condition = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.xpath(
                                        "//div[contains("
                                        + "@class,'product-information')]"
                                        + "/p[b[contains("
                                        + ".,'Condition:')]]")));

        WebElement brand = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.xpath(
                                        "//div[contains("
                                        + "@class,'product-information')]"
                                        + "/p[b[contains("
                                        + ".,'Brand:')]]")));

        Assert.assertFalse(
                productName.getText().trim().isEmpty(),
                "Product name is empty");

        Assert.assertTrue(
                category.isDisplayed(),
                "Category is not displayed");

        Assert.assertTrue(
                price.isDisplayed(),
                "Price is not displayed");

        Assert.assertTrue(
                availability.isDisplayed(),
                "Availability is not displayed");

        Assert.assertTrue(
                condition.isDisplayed(),
                "Condition is not displayed");

        Assert.assertTrue(
                brand.isDisplayed(),
                "Brand is not displayed");

        System.out.println(
                "Product Name: "
                        + productName.getText());

        System.out.println(
                "Category: "
                        + category.getText());

        System.out.println(
                "Price: "
                        + price.getText());

        System.out.println(
                "Availability: "
                        + availability.getText());

        System.out.println(
                "Condition: "
                        + condition.getText());

        System.out.println(
                "Brand: "
                        + brand.getText());

        System.out.println(
                "All product details verified successfully");
    }


    // =========================================================
    // TEST 6
    // VERIFY ADD PRODUCT TO CART
    // =========================================================

    @Test(priority = 6)
    public void verifyAddProductToCart() {

        openProductsPage();

        productsPage.addToCart("1");

        WebElement modal = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.id("cartModal")));

        Assert.assertTrue(
                modal.isDisplayed(),
                "Add to cart modal not displayed");

        System.out.println(
                "Product added to cart successfully");
    }


    // =========================================================
    // TEST 7
    // VERIFY PRODUCT QUANTITY
    // =========================================================

    @Test(priority = 7)
    public void verifyProductQuantity() {

        openProductDetailsSafely("1");

        productsPage.increaseQuantity("4");

        WebElement quantityField =
                driver.findElement(
                        By.id("quantity"));

        Assert.assertEquals(
                quantityField.getAttribute("value"),
                "4",
                "Product quantity mismatch");

        System.out.println(
                "Product quantity verified successfully");
    }


    // =========================================================
    // TEST 8
    // VERIFY OPEN CART
    // =========================================================

    @Test(priority = 8)
    public void verifyOpenCart() {

        openProductsPage();

        productsPage.addToCart("1");

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.id("cartModal")));

        WebElement viewCart = wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                By.xpath(
                                        "//div[@id='cartModal']"
                                        + "//a[@href='/view_cart']")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        viewCart);

        wait.until(
                ExpectedConditions
                        .urlContains("/view_cart"));

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("/view_cart"),
                "Cart page is not displayed");

        System.out.println(
                "Cart page displayed successfully");
    }
}