
package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
public class DriverUtil {
 
    private static WebDriver driver;
 
    public static WebDriver getDriver(String browser) {

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase("edge")) {

                EdgeOptions options = new EdgeOptions();

                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");

                driver = new EdgeDriver(options);   // <-- IMPORTANT
            }
        }

        return driver;
    }
}
