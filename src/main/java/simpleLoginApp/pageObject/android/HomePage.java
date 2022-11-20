package simpleLoginApp.pageObject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="io.simplelogin.android:id/toolbarTitleText")
	private WebElement PageTitle;
	
	@AndroidFindBy(id="io.simplelogin.android:id/rootCardView")
	private WebElement firstAlias;
	
	public void verifyHomePageTitle() {
		Assert.assertTrue(PageTitle.isDisplayed(),"Page Title is not displaying on Home page");
	}
	
	public void verifyAlias() {
		Assert.assertTrue(firstAlias.isDisplayed(), "Alias is not visible on Home page");
	}
}
