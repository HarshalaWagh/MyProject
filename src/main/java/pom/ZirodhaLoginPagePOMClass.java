package pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ZirodhaLoginPagePOMClass {
	WebDriver driver;
	String mobNo;
	@FindBy(xpath="//input[@id='userid']")private WebElement userID;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
    @FindBy(xpath="//button[@type='submit']")private WebElement login;
    @FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
    @FindBy(xpath="//img[@alt='Kite Android']")private WebElement kiteAndroid;
    @FindBy(xpath="//img[@alt='Kite iOS']")private WebElement kiteios;
    @FindBy(xpath="//img[@alt='Zerodha']")private WebElement zirodha;
    @FindBy(xpath="//a[@class='text-light']")private WebElement signUp;
    @FindBy(xpath="//input[@id='pin']")private WebElement pin;
    @FindBy(xpath="//button[@type='submit']")private WebElement submit;
    @FindBy(xpath="//img[@alt='Kite']")private WebElement logo;
    @FindBy(xpath="//h2[@class='text-center']")private WebElement forgotText;

 public ZirodhaLoginPagePOMClass(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
 public void enterUserId(String userName) {
	 userID.sendKeys(userName);
	}
 public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
 public void clickOnLogin(){
	 login.click();
}
 public void clickOnForgotLink() {
	 forgot.click();
	 FluentWait<WebDriver> flWait=new FluentWait<WebDriver>(driver);
		flWait.withTimeout(Duration.ofMillis(20000));
		flWait.pollingEvery(Duration.ofMillis(2000));
		flWait.ignoring(Exception.class);
		flWait.until(ExpectedConditions.titleContains("fast and elegant flagship"));
		
	
 }
 public void clickOnKiteAndroid(WebDriver driver) throws InterruptedException{
	 kiteAndroid.click();
	 Thread.sleep(2000);
	 ArrayList<String>al=new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(al.get(1));
	 System.out.println();
 }
 public void clickOnKiteios(){
	 kiteios.click();
 }
 public void clickOnZirodha(){
	 zirodha.click(); 

 }
 public void clickOnSignUp(WebDriver driver) throws InterruptedException {
	 signUp.click();
		Set<String> se=driver.getWindowHandles();
		Iterator<String>it=se.iterator();
		while(it.hasNext()){
			Thread.sleep(2000);
			String handle=it.next();
			driver.switchTo().window(handle);
			String actTitle=driver.getTitle();
			System.out.println(actTitle);
			
			if(actTitle.contains("Signup")) {
				Thread.sleep(2000);
				break;
			}
		}
 }
 public void enterPin(String PIN,WebDriver driver) {
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
	    wait.until(ExpectedConditions.visibilityOf(pin));
	 pin.sendKeys(PIN);
 }
 public void clickOnContinue() {
	 submit.click();
 }
 public Boolean logoDisplayed() {
	 return logo.isDisplayed();
 }
 public Boolean forgotText() {
	return forgotText.isDisplayed();
	 
 }

}
