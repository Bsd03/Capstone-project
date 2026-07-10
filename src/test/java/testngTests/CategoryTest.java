package testngTests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import base.BaseClassTestng;
import pages.CategoryPage;
import utilities.ExcelReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.Extentreport;


public class CategoryTest extends BaseClassTestng {

    private CategoryPage categoryPage;
    ExtentReports extent;
    ExtentTest test;
    

    @BeforeSuite
    public void setupReport() {
        extent = Extentreport.getReportInstance();
    }



    @BeforeMethod(alwaysRun = true)
    public void initializeCategoryPage() {

        categoryPage =
                new CategoryPage(driver);
    }
    
   
    @Test(priority = 1)
    public void verifyWomenDressCategory() {
    	test = extent.createTest("Verify Women Dress Category");

        categoryPage.click_Women_Category();

        categoryPage.click_Dress_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Women_Category();

            categoryPage.click_Dress_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("DRESS"),
                "Dress category not displayed");
    }

    @Test(priority = 2)
    public void verifyWomenTopsCategory() {
    	test = extent.createTest("Verify Women Tops Category");

        categoryPage.click_Women_Category();

        categoryPage.click_Tops_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Women_Category();

            categoryPage.click_Tops_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("TOPS"),
                "Tops category not displayed");
    }

    @Test(priority = 3)
    public void verifyWomenSareeCategory() {
    	test = extent.createTest("Verify Women Saree Category");

        categoryPage.click_Women_Category();

        categoryPage.click_Saree_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Women_Category();

            categoryPage.click_Saree_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("SAREE"),
                "Saree category not displayed");
    }

    @Test(priority = 4)
    public void verifyMenTshirtCategory() {
    	test = extent.createTest("Verify Men Tshirt Category");

        categoryPage.click_Men_Category();

        categoryPage.click_Tshirt_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Men_Category();

            categoryPage.click_Tshirt_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("TSHIRTS"),
                "Tshirt category not displayed");
    }

    @Test(priority = 5)
    public void verifyMenJeansCategory() {
    	 test = extent.createTest("Verify Men Jeans Category");

        categoryPage.click_Men_Category();

        categoryPage.click_Jeans_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Men_Category();

            categoryPage.click_Jeans_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("JEANS"),
                "Jeans category not displayed");
    }

    @Test(priority = 6)
    public void verifyKidsDressCategory() {
    	test = extent.createTest("Verify Kids Dress Category");

        categoryPage.click_Kids_Category();

        categoryPage.click_KidsDress_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Kids_Category();

            categoryPage.click_KidsDress_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("DRESS"),
                "Kids Dress category not displayed");
    }

    @Test(priority = 7)
    public void verifyKidsTopsCategory() {
    	test = extent.createTest("Verify Kids Tops & Shirts Category");

        categoryPage.click_Kids_Category();

        categoryPage.click_TopsAndShirts_Category();

        categoryPage.handleGoogleVignette(() -> {

            categoryPage.click_Kids_Category();

            categoryPage.click_TopsAndShirts_Category();
        });

        String title =
                categoryPage.getBrandTitle();

        Assert.assertTrue(
                title.toUpperCase()
                     .contains("TOPS & SHIRTS"),
                "Kids Tops category not displayed");
    }

@AfterSuite
    public void flushReport() {
        extent.flush();
    }

}
   