package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.DriverUtil;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    //Executes before every scenario
    @Before
    public void setup(){

        driver= DriverUtil.getDriver(ConfigReader.getProperty("browser"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getProperty("url"));
        System.out.println("Current Url:"+driver.getCurrentUrl());
        System.out.println("Current Url:"+driver.getTitle());

    }
    @After
    public void teartDown(){
        DriverUtil.quitDriver();
    }



}
