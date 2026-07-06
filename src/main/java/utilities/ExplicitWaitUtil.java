package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtil {
	public WebDriver driver;
    public WebDriverWait wait;
 
    public ExplicitWaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void  waitExplicitily(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
 
    // Wait until element is visible
    public WebElement waitForVisibility(WebElement element) {
    	 return wait.until(ExpectedConditions.visibilityOf(element));
    }
 
    // Wait until element is clickable.
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
 
    // Wait until element is invisible
    public boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
 
    // Wait for page title
    public boolean waitForTitle(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }
 
    // Wait for URL
    public boolean waitForURL(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

}
