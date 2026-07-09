package utilities;


import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

public class DriverUtiltestng {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {

                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("edge")) {

                String driverPath =
                        System.getProperty("user.dir")
                        + File.separator
                        + "drivers"
                        + File.separator
                        + "msedgedriver.exe";

                File driverFile =
                        new File(driverPath);

                if (!driverFile.exists()) {

                    throw new RuntimeException(
                            "EdgeDriver not found at: "
                            + driverPath);
                }

                EdgeDriverService service =
                        new EdgeDriverService.Builder()
                                .usingDriverExecutable(driverFile)
                                .build();

                driver = new EdgeDriver(service);

            } else {

                throw new IllegalArgumentException(
                        "Unsupported browser: "
                        + browser);
            }

            driver.manage()
                  .window()
                  .maximize();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}
