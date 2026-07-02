package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactusPage {
    WebDriver driver;
    //constructor to intialize the driver
    public ContactusPage(WebDriver driver){
        this.driver=driver;
    }
    //Locators
    //contact Us menu
    By contactUsMenu= By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
//Get in touch
    By getInTouchTitle=By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
    //Name textbox
    By contacUsnamefield =By.name("name");
    //Email textbox
    By conatcUsemailField=By.name("email");
    //Subject textbox
    By contacUsSubjectField=By.name("subject");
    //message text area
    By contactUsMessage=By.name("message");
    //upload file button
    By uploadFile=By.name("upload_file");

    By submitButton=By.name("submit");
    //Success message displayed after form submission
    By successMessgae=By.xpath("//div[@class='status alert alert-success']");
    //"Feedback for us section heading"
    By feedbackTitle=By.xpath("//h2[contains(text(),'Feedback For Us')]");
    //feedbackemail link
    By feedbackEmail=By.xpath("//a[contains(@href,'mailto:') or contains(text(),'feedback')]");
      //Methods
    //click on Contact Us Menu
    public void clickContactUs(){
      driver.findElement(contactUsMenu).click();
    }
    //verify contactus page is opened
    public boolean isContactPageDisplayed(){
        return driver.getCurrentUrl().contains("contact_us");
    }
    //verify get in touch heading is visible
    public boolean isGetInTouchVisible(){
        return driver.findElement(getInTouchTitle).isDisplayed();
    }
    //Enter Name
    public void enterName(String name){
        driver.findElement(contacUsnamefield).sendKeys(name);
    }
    //Enter Email
    public void enterEmail(String email){
        driver.findElement(conatcUsemailField).sendKeys(email);
    }
    //Enter Subject
    public void enterSubject(String subject){
        driver.findElement(contacUsSubjectField).sendKeys(subject);
    }
    //Enter Message
    public void enterMessage(String message){
        driver.findElement(contactUsMessage).sendKeys(message);
    }
    //upload a file using its absolute path
    public void uploadFile(String filePath){
        driver.findElement(uploadFile).sendKeys(filePath);
    }
    //click on submit button
    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }
    //Accept the confirmation alret displayed after clicking submit
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //verify success message is displayed
    public boolean isSuccessMessageDisplayed(){
        return driver.findElement(successMessgae).isDisplayed();
    }
    //Verify Feedback  For Us action is visible
    public boolean isFeedbackisDisplayed(){
        return driver.findElement(feedbackTitle).isDisplayed();
    }
//verify feedback email is displayed
    public boolean isFeedbackEmailDisplayed(){
        return driver.findElement(feedbackEmail).isDisplayed();
    }
}
