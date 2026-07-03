package Hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;
import utilities.DriverUtil;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        driver = DriverUtil.getDriver(ConfigReader.getProperty("browser"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.getProperty("url"));

        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Page Title  : " + driver.getTitle());
    }

    @After
    public void tearDown() {

        DriverUtil.quitDriver();
    }
}