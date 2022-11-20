package simpleLoginApp.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class AndroidUtility {

	AndroidDriver driver;
	
	
	public String getScreenShot(String testCaseName, AndroidDriver driver) throws IOException {
		File soruce=driver.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"//report"+testCaseName+".png";
		FileUtils.copyFile(soruce,new File(destination));
		return destination;
	}
}
