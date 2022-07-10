package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ScreenShot;

public class Listeners extends BaseClass implements ITestListener{
	public void onTestStart(ITestResult result) {
	System.out.println(result.getName() +" Test is started");
}
	public void onTestSkipped(ITestResult result) {
	System.out.println(result.getName() +" Test is skipped");	
	}
	public void onTestFailure(ITestResult result){
		try {
			ScreenShot.ScreenShotMethod(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
