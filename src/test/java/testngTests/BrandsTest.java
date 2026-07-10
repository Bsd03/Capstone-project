package testngTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import base.BaseClassTestng;
import pages.BrandsPage;
import utilities.ExcelReader;
import utilities.Extentreport;

public class BrandsTest extends BaseClassTestng {
	

    private BrandsPage brandsPage;

    ExtentReports extent;
    ExtentTest test;


    @BeforeSuite
    public void setupReport() {
        extent = Extentreport.getReportInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void initializeBrandsPage() {

        driver.get(
                "https://automationexercise.com/products");

        brandsPage =
                new BrandsPage(driver);
    }
    
    
    @Test(priority = 1)
    public void verifyBrandsSection() {
    	
    	test = extent.createTest("Verify Brands Section");

        brandsPage.verifyBrandsSection();
        test.info("Brands section verified");

        brandsPage.verifyBrandNames();
        test.pass("All brand names verified successfully");
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
    	
    	test = extent.createTest("Verify Selected Brand : " + brandName);
        brandsPage.clickBrand(brandName);
        test.info("Clicked on brand: " + brandName);
        brandsPage.verifyBrandPage(brandName);
        test.info("Brand page verified");
        brandsPage.verifyProductsDisplayed();
        test.pass("Products displayed for brand: " + brandName);
    }

    

    @Test(
        priority = 3,
        dataProvider = "brands"
    )
    public void verifyBrandURL(
            String brandName) {
    	test = extent.createTest("Verify Brand URL : " + brandName);

        brandsPage.clickBrand(brandName);
        test.info("Clicked on brand: " + brandName);
        Assert.assertTrue(
                brandsPage
                    .getCurrentPageURL()
                    .contains("brand_products"),
                "Incorrect brand URL");
        test.pass("Brand URL verified successfully");
    }

    @Test(priority = 4)
    public void verifySwitchBetweenBrands() {
    	test = extent.createTest("Verify Switching Between Brands");

        brandsPage.clickBrand("Polo");

        brandsPage.verifyBrandPage("Polo");
        test.info("Switched to Polo brand");

        brandsPage.clickBrand("H&M");

        brandsPage.verifyBrandPage("H&M");
        test.pass("Successfully switched from Polo to H&M");
    }

@AfterSuite
    public void flushReport() {
        extent.flush();
    }

}
