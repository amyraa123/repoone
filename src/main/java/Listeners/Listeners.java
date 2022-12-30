package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	WebDriver driver = null;

	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getName()+" execution started");
		extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		//extentTest.log(Status.PASS,"Test Passed");
		extentTestThread.get().log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		//For ExtentReports
		//extentTest.fail(result.getThrowable());
		
		extentTestThread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testMethodName = result.getName();
		
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		try {
			
			String screenshotFilePath = takeScreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);	//Adding the screen shot to extent reports
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		/*Code For taking screen shots
		 * 
		String testMethodName = result.getName();

		try {
			
			 driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		try {
			
			takeScreenshot(testMethodName, driver);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();
	}

}
