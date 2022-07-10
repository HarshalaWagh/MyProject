package ZirodhaTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import pojo.Browser;
import pom.ZerodhaHomePage;
import pom.ZirodhaLoginPagePOMClass;
import utility.ExelFile;

public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void openBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver=Browser.openChromeBrowser();
		driver.manage().window().maximize();
		String userN=ExelFile.ExcelFileRead("Sheet1",0,0);
		String pass=ExelFile.ExcelFileRead("Sheet1",0,1);
		String pin=ExelFile.ExcelFileRead("Sheet1",0,2);
		ZirodhaLoginPagePOMClass loginPage=new ZirodhaLoginPagePOMClass(driver);
		loginPage.enterUserId(userN);
		loginPage.enterPassword(pass);
		loginPage.clickOnLogin();
		loginPage.enterPin(pin,driver);
		loginPage.clickOnContinue();
		Thread.sleep(2000);
	}
	@Test
	public void searchShareFromWatchList() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.selectFromShareWatchList("WIPRO",driver);
	
	}
	@Test
	public void searchShareFromNList() {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.selectShareFromNormalList("T",driver);
	}

}
