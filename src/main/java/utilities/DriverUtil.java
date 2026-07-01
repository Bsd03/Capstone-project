
package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class DriverUtil {
 
    private static WebDriver driver;
 
    public static WebDriver getDriver(String browser) {
 
        if (driver == null) {
 
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
 
            driver.manage().window().maximize();
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
