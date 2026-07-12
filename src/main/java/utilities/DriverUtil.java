
package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
public class DriverUtil {
 
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
 
    public static WebDriver getDriver(String browser) {

        if (driver == null) {

            switch (browser.toLowerCase()) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "edge":

                    EdgeOptions options = new EdgeOptions();

                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--window-size=1920,1080");

                    driver = new EdgeDriver(options);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Unsupported browser : " + browser);
            }
        }

        return driver;
    }

	public static void quitDriver() {
		driver.quit();
		// TODO Auto-generated method stub
		
	}

	
}
