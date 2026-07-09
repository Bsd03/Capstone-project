package utilities;

import org.openqa.selenium.WebDriver;

public class GoogleAdsHandler {
    WebDriver driver;
    public GoogleAdsHandler(WebDriver driver){
        this.driver=driver;
    }
    public void handleGoogleVignette(Runnable retryAction) {

        System.out.println("Current URL : " + driver.getCurrentUrl());

        if (driver.getCurrentUrl().contains("google_vignette")) {

            System.out.println("======================================");
            System.out.println("Google Vignette Advertisement Detected");
            System.out.println("Refreshing the current page...");

            driver.navigate().refresh();

            System.out.println("Page Refreshed Successfully");
            System.out.println("Re-clicking ...");

            retryAction.run();

            System.out.println(" Re-clicked Successfully");
            System.out.println("Current URL : " + driver.getCurrentUrl());
            System.out.println("Google Advertisement Handled Successfully");
            System.out.println("======================================");

        } else {

            System.out.println("No Google Advertisement Detected");
        }
    }
}
