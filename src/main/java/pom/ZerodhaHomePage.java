package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	WebDriver driver;
	@FindBy(xpath="//a[@class='orders-nav-item']")private WebElement orders;
	@FindBy(xpath="//a[@href='/holdings']")private WebElement holdings;
	@FindBy(xpath="//a[@href='/positions']")private WebElement positions;
	@FindBy(xpath="//a[@href='/funds']")private WebElement funds; 
	@FindBy(xpath="//a[@href='/apps']")private WebElement apps;
	@FindBy(xpath="//div[@class='avatar']")private WebElement userName;
	@FindBy(xpath="//span[@class='user-id']")private WebElement userID;
	@FindBy(xpath="//input[@icon='search']")private WebElement search;
	@FindBy(xpath="(//button[@type='button'] )[1]")private WebElement buyButton;
	@FindBy(xpath="//button[@class='button-orange sell']")private WebElement sellButton;
	@FindBy(xpath="//span[@class='icon icon-align-center']")private WebElement marketDepth;
	@FindBy(xpath="(//button[@class='button-outline'])[2]")private WebElement chart;
	@FindBy(xpath="//span[@class='icon icon-trash']")private WebElement delete;
	@FindBy(xpath="//span[@class='icon icon-ellipsis']")private WebElement more;
	@FindBy(xpath="//span[@class='symbol']")private List<WebElement> shareWatchList;
	@FindBy(xpath="//button[@class='button-blue buy']")private WebElement shareWatchListBuy;
	@FindBy(xpath="//li[@class='search-result-item']")private List<WebElement> shareNList;
	
	
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnSearch(WebDriver driver,String shareName){
		search.click();
		search.sendKeys(shareName);
	}
	//Buy the share from watchlist
	public void selectFromShareWatchList(String stockName,WebDriver driver) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(search));
		System.out.println(shareWatchList.size());
	
		
		for(int i=0;i<shareWatchList.size();i++) {
			
			WebElement stock=shareWatchList.get(i);
			String shareName=stock.getText();
			
			if(shareName.equals(stockName)) {
				Actions act=new Actions(driver);
				act.moveToElement(stock).perform();
				act.moveToElement(shareWatchListBuy).click().perform();
			}
		}
	}
		
	//Buy the share by sending 1 characters and giving name
	public void selectShareFromNormalList(String share,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(share);
		System.out.println(shareNList.size());
		for(int i=0;i<shareNList.size();i++) {
			WebElement stock=shareNList.get(i);
			String stockName=stock.getText();
			if(stockName.contains("TATACONSUM")) {
				Actions act=new Actions(driver);
				act.moveToElement(stock).perform();
				act.moveToElement(buyButton).click().perform();
				
			}
			
			
		}
		
		
	}
	public void clickOnOrders() {
		orders.click();
	}
	public void clickOnHoldings() {
		holdings.click();
	}
	public void clickOnPositions() {
		positions.click();
	}
	public void clickOnFunds() {
		funds.click();
	}
	public void clickOnApps() {
		apps.click();
	}
	public void clickOnUserName() {
		userName.click();
	}
	public void clickOnUserID() {
		userID.click();
	}
	public void clickOnBuyButton() {
		buyButton.click();
	}
	public void clickOnSellButton() {
		sellButton.click();
	}
	public void clickOnMarketDepth() {
	marketDepth.click();
	}
	public void clickOnChart() {
		chart.click();
	}
	public void clickOnDelete() {
		delete.click();
	}
	public void clickOnMore() {
		more.click();
	}
	
}
