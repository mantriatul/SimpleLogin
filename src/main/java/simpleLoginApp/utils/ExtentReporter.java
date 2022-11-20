package simpleLoginApp.utils;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReports extent;
	
	@BeforeTest
	public static ExtentReports extendConfig() {
		String path=System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Android Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		extent= new ExtentReports();
		//extent.attachReporter(reporter);
		extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("Tester", "Atul");
		return extent;
	}
	
}
