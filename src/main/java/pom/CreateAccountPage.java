package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	@FindBy(xpath="//input[@name='mobile']")private WebElement mobileNo;
    @FindBy(xpath="(//a[text()='Signup'])[1]")private WebElement signUp;
    @FindBy(xpath="//button[@id='open_account_proceed_form']")private WebElement conti;
	
	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void enterMobileNo(String mNo) {
		mobileNo.sendKeys(mNo);
	}
	public void clickOnSignUp() {
		signUp.click();
	}
	public void clickOnContinue() {
		conti.click();
	}
	
	
	
}
