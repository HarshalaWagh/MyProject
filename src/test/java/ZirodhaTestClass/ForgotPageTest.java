package ZirodhaTestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import pojo.Browser;
import pom.ForgotLink;
import pom.ZirodhaLoginPagePOMClass;
import utility.ScreenShot;

public class ForgotPageTest {
	WebDriver driver;
	@BeforeMethod
	public void Browser1() throws InterruptedException {
		driver=Browser.openChromeBrowser();
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test
	public void enterForgotCredentials() throws   InterruptedException {
		ZirodhaLoginPagePOMClass forgotpage=new ZirodhaLoginPagePOMClass(driver);
		forgotpage.clickOnForgotLink();
		ForgotLink forgotpage1=new ForgotLink(driver);
		forgotpage1.enteruserIDd("12345asd");
		forgotpage1.enterPAN("ASW1234W12");
		forgotpage1.clickOnSms();
		forgotpage1.enterEmail("abc@yahoo.com");
		forgotpage1.clickOnReset();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void screenShot() throws IOException{
		ScreenShot.ScreenShotMethod(driver,"ZerodhaLogin");
		//driver.close();
	}

}
