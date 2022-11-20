package simpleLoginApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import simpleLoginApp.utils.ExtentReporter;

public class BaseTest {
	
	public static AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//simpleLoginApp//resource//data.properties");
		prop.load(fis);
		
		//AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Atul Mantri//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
		//	.withIPAddress("127.0.0.1").usingPort(4723).build();
	    //service.start();
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	    capabilities.setCapability("appPackage", "io.simplelogin.android");
	    capabilities.setCapability("appActivity", "io.simplelogin.android.module.startup.StartupActivity");
	    driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	
	    //service.stop();
	}


}
