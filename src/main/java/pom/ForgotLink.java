package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotLink {

	@FindBy(xpath="//input[@placeholder='User ID']")private WebElement userId;
	@FindBy(xpath="//input[@placeholder='PAN']")private WebElement pan;
	@FindBy(xpath="//label[@for='radio-36']")private WebElement sms;
	@FindBy(xpath="//input[@placeholder='Mobile number (as on account)']")private WebElement mobNo;
	@FindBy(xpath="//button[@type='submit']")private WebElement reset;

public ForgotLink(WebDriver driver) {
	PageFactory.initElements(driver,this);	
}
public void enteruserIDd(String id) {
	userId.sendKeys(id);
}
public void enterPAN(String PAN) {
	pan.sendKeys(PAN);
}
public void clickOnSms() {
	sms.click();
}
public void enterEmail(String mNO) {
	mobNo.sendKeys(mNO);
	
}
public void clickOnReset() {
	reset.click();
}

}
