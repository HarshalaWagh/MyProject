package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void ScreenShotMethod(WebDriver driver,String name) throws IOException {

		String d=ScreenShot.dateTimeFormate();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\harsh\\OneDrive\\Desktop\\Automation Screenshots\\"+name+ d+ ".png");
		FileHandler.copy(source,dest);
	}

		public static String dateTimeFormate(){
		
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-mm-dd hh-mm-ss");
			LocalDateTime ldt=LocalDateTime.now();
			String d=dtf.format(ldt);
			return d;	

	}
}

