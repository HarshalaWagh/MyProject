package ZirodhaTestClass;

import java.io.IOException;
import utility.ScreenShot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.CreateAccountPage;
import pom.ForgotLink;
import pom.Image1stClass;
import pom.ZirodhaLoginPagePOMClass;
import utility.BaseClass;
import utility.ExelFile;
import utility.ScreenShot;
@Listeners(utility.Listeners.class)
public class LoginPageTest extends BaseClass {
	//WebDriver driver;
	String expTitle;
	@BeforeMethod
	public void openBrowser1() throws InterruptedException {
		driver=Browser.openChromeBrowser();
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void loginTest() throws EncryptedDocumentException, IOException, InterruptedException{
		String userN=ExelFile.ExcelFileRead("Sheet1",0,0);
		String pass=ExelFile.ExcelFileRead("Sheet1",0,1);
		String pin=ExelFile.ExcelFileRead("Sheet1",0,2); 
		
		ZirodhaLoginPagePOMClass loginPage=new ZirodhaLoginPagePOMClass(driver);
		Boolean kiteLogo=loginPage.logoDisplayed();
		SoftAssert soft=new SoftAssert();
		soft.assertFalse(kiteLogo);
		//Assert.assertFalse(kiteLogo);
		//Assert.assertTrue(kiteLogo);
		loginPage.enterUserId(userN);
		loginPage.enterPassword(pass);
		loginPage.clickOnLogin();
		
		String expTitle=driver.getTitle();
		String actTitle="Kite - Zerodha's fast and elegant flagship trading platform";
		//Assert.assertNotEquals(actTitle,expTitle);
		Assert.assertEquals(actTitle,expTitle);
		loginPage.enterPin(pin,driver);
		loginPage.clickOnContinue();
		Thread.sleep(2000);
		soft.assertAll();
	}
	@Test(priority=1,enabled=false)
	public void forgotLink() throws InterruptedException, EncryptedDocumentException, IOException {
		String userId=ExelFile.ExcelFileRead("Sheet2",0,0);
		String pan=ExelFile.ExcelFileRead("Sheet2",1,0);
		String email=ExelFile.ExcelFileRead("Sheet2",2,0);
		
		ZirodhaLoginPagePOMClass loginPage=new ZirodhaLoginPagePOMClass(driver);
		loginPage.clickOnForgotLink();
		Thread.sleep(2000);
		/*Boolean fT=loginPage.forgotText();
		Assert.assertTrue(fT);*/
		 
		ForgotLink forgotLink=new ForgotLink(driver);
		forgotLink.enteruserIDd(userId);
		forgotLink.enterPAN(pan);
		forgotLink.clickOnSms();
		forgotLink.enterEmail(email);
		forgotLink.clickOnReset();
		Thread.sleep(2000);
		
	}
	@Test(priority=1)
	public void signUpLink() throws InterruptedException, EncryptedDocumentException, IOException {
		ZirodhaLoginPagePOMClass loginPage=new ZirodhaLoginPagePOMClass(driver);
		loginPage.clickOnSignUp(driver);
		Thread.sleep(2000);	
		String mobNo=ExelFile.ExcelFileRead("Sheet3", 0, 0);
		CreateAccountPage createAccount=new CreateAccountPage(driver);
		createAccount.enterMobileNo(mobNo);
		createAccount.clickOnContinue();
	}
	
	@Test(enabled=false)
	public void goToGooglePlayStore() throws InterruptedException {
		ZirodhaLoginPagePOMClass goToPlayStore1=new ZirodhaLoginPagePOMClass(driver);
		goToPlayStore1.clickOnKiteAndroid(driver);
		System.out.println();
		Image1stClass obj1=new Image1stClass(driver);
		obj1.clickOnGames();
	}
	
	
	@AfterMethod
	public void screenShot() throws IOException{
		ScreenShot.ScreenShotMethod(driver,"ZerodhaLogin");
		//driver.close();
	}
	
	
	
	
	
}
