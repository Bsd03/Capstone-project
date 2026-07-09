package testngTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClassTestng;

public class HomeTest extends BaseClassTestng {

    @Test
    public void verifyHomePageDisplayed() {

        String title =
                driver.getTitle();

        System.out.println(
                "Actual Page Title: "
                + title);

        Assert.assertTrue(
                title.contains(
                        "Automation Exercise"),
                "Home page is not displayed");
    }
}