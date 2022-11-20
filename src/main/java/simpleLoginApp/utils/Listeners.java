package simpleLoginApp.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Listeners extends AndroidUtility implements ITestListener {

	AndroidDriver driver;
	ExtentTest test;
	ExtentReports extent=ExtentReporter.extendConfig();
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		try {
			driver= (AndroidDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
}
