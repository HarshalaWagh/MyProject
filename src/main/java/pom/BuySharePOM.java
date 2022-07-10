package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuySharePOM {
	@FindBy(xpath="//label[text()='BSE: '] ")private WebElement bscRadio;
	@FindBy(xpath="//label[text()='NSE: ']")private WebElement nscRadio;
	@FindBy(xpath="(//span[@class='icon icon-info'])[1]")private WebElement help;
	@FindBy(xpath="//label[text()='Regular']")private WebElement regular;
	@FindBy(xpath="//label[text()='Cover']")private WebElement cover;
	@FindBy(xpath="//label[text()='AMO']")private WebElement amo;
	@FindBy(xpath="//label[text()='Iceberg']")private WebElement iceberge;
	@FindBy(xpath="//label[text()='Intraday ']")private WebElement intraday;
	@FindBy(xpath="//label[text()='Longterm ']")private WebElement longterm;
	@FindBy(xpath="//input[@label='Qty.']")private WebElement qty;
	@FindBy(xpath="//input[@label='Price']")private WebElement price;
	@FindBy(xpath="//input[@label='Trigger price']")private WebElement triggerPrice;
	@FindBy(xpath="//label[text()='Market']")private WebElement market;
	@FindBy(xpath="//label[text()='Limit']")private WebElement limit;
	@FindBy(xpath="//label[text()='SL']")private WebElement sl;
	@FindBy(xpath="//label[text()='SL-M']")private WebElement slm;
	@FindBy(xpath="//div[@class='more-options']")private WebElement moreOptions;
	@FindBy(xpath="(//span[@class='icon icon-info'])[2]")private WebElement marginCalcExp;
	@FindBy(xpath="//span[@class='reload-margin icon icon-reload']")private WebElement refresh;
	@FindBy(xpath="(//span[text()='Buy'])[2]")private WebElement buy;
	@FindBy(xpath="//button[@class='button-outline cancel']")private WebElement cancel;
	@FindBy(xpath="//form[@data-drag-boundary='true']")private WebElement form;
	@FindBy(xpath="//input[@label='Stoploss trigger Price']") private WebElement stoplossTriggerPrice;
	
	public BuySharePOM(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnBSC() {
		bscRadio.click();
	}
	public void clickOnNSC() {
		nscRadio.click();
	}
	public void clickOnHelp() {
		help.click();
	}
	public void clickOnRegular() {
		regular.click();
	}
	public void clickOnCover() {
		cover.click();
	}
	public void clearInitialStopLTrigger() {
		stoplossTriggerPrice.clear();
	}
	public void enterStopLossTriggerPrice(String pri) {
		stoplossTriggerPrice.sendKeys(pri);
	}
	public void clickOnAMO() {
		amo.click();
	}
	public void clickOnIntraday() {
		intraday.click();
	}
	public void clickOnLongterm() {
		longterm.click();
	}
	
	public void clickOnQty(String qtys) {
		qty.sendKeys(qtys);
	}
	public void clearInitialPriceField()
	{
		price.clear();
	}
	public void clickOnPrice(String pp) {
		price.sendKeys(pp);
	}
	public void clearInitialTriggerPrice() {
		triggerPrice.clear();
	}
	public void clickOnTriggerPrice(String tp) {
		triggerPrice.sendKeys(tp);
	}
	public void clickOnMarket() {
		market.click();
	}
	public void clickOnLimit() {
		limit.click();
	}
	public void clickOnStopLoss() {
		sl.click();
	}
	public void clickOnStopLossMarket() {
		slm.click();
	}
	public void clickOnMoreOptions() {
		moreOptions.click();
	}
	public void clickOnMarginCalcExp() {
		marginCalcExp.click();
	}
	public void clickOnRefresh() {
		refresh.click();
	}
	public void clickOnBuy() {
		buy.click();
	}
	public void clickOnCancel() {
		cancel.click();
	}

}
