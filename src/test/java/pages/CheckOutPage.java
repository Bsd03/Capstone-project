package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitUtil;

public class CheckOutPage {
	
	//Declare WebDriver 
		private WebDriver driver;
		private ExplicitWaitUtil wait;
		
		//Constructor to initialize PageFactory elements
		public CheckOutPage(WebDriver driver ) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
			}
		
		//proceed to checkout button
		@FindBy(
				xpath="//a[contains(@class,'btn') and contains(@class,'check_out')]") 
		WebElement Proceed_TO_checkoutbtn;
		
		//Place Order button
		@FindBy(
				linkText="Place Order") WebElement place_order_btn;
		
		//Payment Details
		
		//Card name
		@FindBy(name="name_on_card") WebElement CardName;
		//card number
		@FindBy(name="card_number") WebElement CardNumber;
		//Cvc number
		@FindBy(name="cvc") WebElement cvc;
		//Expire Month
		@FindBy(name="expiry_month") WebElement ExpireMonth;
		//Expire Year
		@FindBy(name="expiry_year") WebElement ExpireYear;
		
		//Confirm Order
		@FindBy(xpath="//button[@id='submit']") WebElement ConfirmOrder;
		
		//Alert 
		@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement Alert;
		
		//Download Invoice
		@FindBy(linkText="Download Invoice") WebElement Download_Invoice;
		
		//Continue button
		@FindBy(linkText="Continue") WebElement Continuebtn;
		
		//Clicking on checkout button
		public void checkout_button() {
			wait.waitForClickable(Proceed_TO_checkoutbtn).click();
		}
		
		//Clicking on order button
		public void place_order_button() {
			wait.waitForClickable(place_order_btn).click();
		}
		
		//Payment Details
		
		//Entering cardname
		public void cardName(String name) {
			CardName.sendKeys(name);
			
		}
		//Entering card number
		public void card_number(String number) {
			CardNumber.sendKeys(number);
		}
		//Entering expire_month
		public void expire_month(String month) {
			ExpireMonth.sendKeys(month);
		}
		//Entering expire year
		public void expire_year(String year) {
			ExpireYear.sendKeys(year);
		}
		
		
		//Confirm order 
		public void confirmOrder() {
			wait.waitForClickable(ConfirmOrder).click();
		}
		//Display Alert
		public void alert() {
			System.out.println(Alert);
		}
		//Download invoice
		public void invoice_Download() {
			Download_Invoice.click();
		}
		
		//Continue button
		public void click_Continue() {
			wait.waitForClickable(Continuebtn).click();
			
		}

}
