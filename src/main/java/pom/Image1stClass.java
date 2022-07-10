package pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Image1stClass {
	@FindBy(xpath="(//span[@jsname='ksKsZd'])[1]")private WebElement games;

public Image1stClass(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void clickOnGames() {

	games.click();
}

}


