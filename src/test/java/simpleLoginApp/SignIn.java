package simpleLoginApp;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import simpleLoginApp.pageObject.android.HomePage;
import simpleLoginApp.pageObject.android.SignInPage;

public class SignIn extends BaseTest {

	//@Test(priority = 1)
	public void verifySignInWithValidCredential() throws MalformedURLException {		
		SignInPage signInLib=new SignInPage(driver);
		signInLib.setEmailAddress("atul.mantri@testingxperts.com");
		signInLib.setPassword("Simple1234");
		signInLib.clickOnSignInButton();
		HomePage homePageLib=new HomePage(driver);
		homePageLib.verifyHomePageTitle();
		homePageLib.verifyAlias();
	}
	
	
	@Test(priority = 2)
	public void verifySignInWithValidUserNameAndInvalidPassword() throws MalformedURLException, InterruptedException {		
		SignInPage signInLib=new SignInPage(driver);
		signInLib.setEmailAddress("atul.mantri@testingxperts.com");
		signInLib.setPassword("Simple@1234");
		signInLib.clickOnSignInButton();
		
		Thread.sleep(3000);
		String warningMessage=signInLib.verifyToastMessageWhenAnyFieldIsEmpty();
		System.out.println(warningMessage);
		Assert.assertEquals(warningMessage, "Incorrect email or password");
	}
	
	//@Test(priority = 3)
	public void verifySignInWithInvalidUserNameAndValidPassword() throws MalformedURLException, InterruptedException {		
		SignInPage signInLib=new SignInPage(driver);
		signInLib.setEmailAddress("jhfcir@testingxperts.com");
		signInLib.setPassword("Simple1234");
		signInLib.clickOnSignInButton();
		Thread.sleep(3000);
		String warningMessage=signInLib.verifyToastMessageWhenAnyFieldIsEmpty();
		System.out.println(warningMessage);
		Assert.assertEquals(warningMessage, "Incorrect email or password");
	}
	
	//@Test(priority = 4)
	public void verifySignInWithEmptyUsernameAndPassword() throws MalformedURLException, InterruptedException {		
		SignInPage signInLib=new SignInPage(driver);
		signInLib.setEmailAddress(" ");
		signInLib.setPassword(" ");
		signInLib.clickOnSignInButton();
		Thread.sleep(3000);
		String warningMessage=signInLib.verifyToastMessageWhenAnyFieldIsEmpty();
		System.out.println(warningMessage);
		Assert.assertEquals(warningMessage, "Please enter both email and password");
		
	}
	
}
