package testngTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClassTestng;
import pages.BrandsPage;
import utilities.ExcelReader;

public class BrandsTest extends BaseClassTestng {

    private BrandsPage brandsPage;

    @BeforeMethod(alwaysRun = true)
    public void initializeBrandsPage() {

        driver.get(
                "https://automationexercise.com/products");

        brandsPage =
                new BrandsPage(driver);
    }
    
    
    @Test(priority = 1)
    public void verifyBrandsSection() {

        brandsPage.verifyBrandsSection();

        brandsPage.verifyBrandNames();
    }

    @DataProvider(name = "brands")
    public Object[][] getBrands() {

        return new Object[][] {

            {"Polo"},
            {"H&M"},
            {"Madame"},
            {"Mast & Harbour"},
            {"Babyhug"},
            {"Allen Solly Junior"},
            {"Kookie Kids"},
            {"Biba"}
        };
    }

    @Test(
        priority = 2,
        dataProvider = "brands"
    )
    public void verifySelectedBrand(
            String brandName) {

        brandsPage.clickBrand(brandName);

        brandsPage.verifyBrandPage(brandName);

        brandsPage.verifyProductsDisplayed();
    }

    @Test(
        priority = 3,
        dataProvider = "brands"
    )
    public void verifyBrandURL(
            String brandName) {

        brandsPage.clickBrand(brandName);

        Assert.assertTrue(
                brandsPage
                    .getCurrentPageURL()
                    .contains("brand_products"),
                "Incorrect brand URL");
    }

    @Test(priority = 4)
    public void verifySwitchBetweenBrands() {

        brandsPage.clickBrand("Polo");

        brandsPage.verifyBrandPage("Polo");

        brandsPage.clickBrand("H&M");

        brandsPage.verifyBrandPage("H&M");
    }
}
