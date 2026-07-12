package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;
import utilities.DriverUtil;

public class BaseClassTestng {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        driver = DriverUtil.getDriver(browser);

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.manage().timeouts()
              .pageLoadTimeout(Duration.ofSeconds(60));

        openWebsiteWithRetry(url);
    }

    private void openWebsiteWithRetry(String url) {

        int maxAttempts = 3;

        for (int attempt = 1;
             attempt <= maxAttempts;
             attempt++) {

            try {

                System.out.println(
                        "Opening website - Attempt "
                        + attempt);

                driver.get(url);

                if (driver.getTitle() != null
                        && !driver.getTitle().isEmpty()) {

                    return;
                }

            } catch (WebDriverException e) {

                System.out.println(
                        "Website opening failed on attempt "
                        + attempt);

                System.out.println(
                        "Reason: " + e.getMessage());

                if (attempt == maxAttempts) {

                    throw e;
                }

                try {

                    Thread.sleep(3000);

                } catch (InterruptedException ex) {

                    Thread.currentThread().interrupt();

                    throw new RuntimeException(ex);
                }
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed successfully");
    }
}