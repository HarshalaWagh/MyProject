package ZirodhaTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pojo.Browser;
import pom.BuySharePOM;
import pom.ZerodhaHomePage;
import pom.ZirodhaLoginPagePOMClass;
import utility.ExelFile;

public class BuyTest {
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
	
	@Test(priority=1)
	public void buyNSCRegIntrMarkeShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnNSC();
		buySharePOM.clickOnIntraday();
		buySharePOM.clickOnMarket();
		buySharePOM.clickOnQty("10");
		buySharePOM.clickOnBuy();
}
	@Test(priority=2)
	public void buyNSCRegIntrLimitShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnLimit();
		buySharePOM.clickOnQty("10");
		buySharePOM.clearInitialPriceField();
		buySharePOM.clickOnPrice("700");
		buySharePOM.clickOnBuy();
}

	@Test(priority=3)
	public void buyNSCRegIntrStopLossShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnStopLoss();
		buySharePOM.clickOnQty("12");
		buySharePOM.clearInitialPriceField();
		buySharePOM.clickOnPrice("700");
		buySharePOM.clearInitialTriggerPrice();
		buySharePOM.clickOnTriggerPrice("698");
		buySharePOM.clickOnBuy();
	
}
	@Test(priority=4)
	public void buyNSCRegIntrStopLossMarketShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnStopLossMarket();
		buySharePOM.clickOnQty("12");
		buySharePOM.clearInitialTriggerPrice();
		buySharePOM.clickOnTriggerPrice("698");
		buySharePOM.clickOnBuy();
}
	@Test(priority=5)
	public void buyNSCCoverIntradayMarketShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnCover();
		buySharePOM.clickOnMarket();
		buySharePOM.clickOnQty("10");
		buySharePOM.clearInitialStopLTrigger();
		buySharePOM.enterStopLossTriggerPrice("700");
		buySharePOM.clickOnBuy();
}
	@Test(priority=6)
	public void buyNSCCoverIntradayLimitShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnCover();
		buySharePOM.clickOnMarket();
		buySharePOM.clickOnQty("10");
		buySharePOM.clearInitialPriceField();
		buySharePOM.clickOnPrice("700");
		Thread.sleep(2000);
		buySharePOM.clickOnBuy();
}
	@Test
	public void buyNSCAMOIntrLimitShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnAMO();
		buySharePOM.clickOnIntraday();
		buySharePOM.clickOnLimit();
		Thread.sleep(2000);
		buySharePOM.clickOnQty("10");
		buySharePOM.clearInitialPriceField();
		buySharePOM.clickOnPrice("700");
		buySharePOM.clickOnBuy();
		
}
	@Test
	public void buyNSCAMOIntrMarketShare() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnSearch(driver,"TATA");
		BuySharePOM buySharePOM=new BuySharePOM(driver);
		Thread.sleep(2000);
		buySharePOM.clickOnAMO();
		buySharePOM.clickOnIntraday();
		buySharePOM.clickOnMarket();
		Thread.sleep(2000);
		buySharePOM.clickOnQty("10");
		buySharePOM.clearInitialPriceField();
		buySharePOM.clickOnPrice("700");
		buySharePOM.clickOnBuy();
		
}
}