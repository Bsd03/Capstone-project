package base;
 
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
 
import utilities.ConfigReader;
import utilities.DriverUtil;
 
public class BaseClass {
 
    public static WebDriver driver;
 
    @BeforeMethod
    public void setup() {
 
        driver = DriverUtil.getDriver(ConfigReader.getProperty("browser"));
 
        driver.get(ConfigReader.getProperty("url"));
 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
 
    @AfterMethod
    public void tearDown() {
 
        DriverUtil.quitDriver();
    }
}
 
