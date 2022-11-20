package simpleLoginApp.pageObject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SignInPage {

	AndroidDriver driver;
	
	public SignInPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email address']")
	private WebElement emailAddress;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private WebElement passwordField;
	
	@AndroidFindBy(id="io.simplelogin.android:id/loginButton")
	private WebElement signInButton;
	
	@AndroidFindBy(id="io.simplelogin.android:id/loginWithProtonButton")
	private WebElement loginWithProtonButton;
	
	@AndroidFindBy(id="io.simplelogin.android:id/forgotPasswordButton")
	private WebElement forgotPasswordButton;
	
	@AndroidFindBy(xpath="//android.widget.Toast")
	private WebElement WarningToastMsg;
	
	
	public void setEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	
	public String verifyToastMessageWhenAnyFieldIsEmpty() {
		String warningMessage=WarningToastMsg.getAttribute("name");
		return warningMessage;
	}
	
	
}
