package pojo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver openChromeBrowser() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		//for disable extra notification
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//****************************************//
		
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://kite.zerodha.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}

}
