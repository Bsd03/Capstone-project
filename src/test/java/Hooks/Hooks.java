package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.DriverUtil;
import utilities.allureScreenshotUtil;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverUtil.getDriver();

        if (driver != null) {

            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());

            allureScreenshotUtil.captureScreenshot(driver);

            DriverUtil.quitDriver();
        }
    }
}