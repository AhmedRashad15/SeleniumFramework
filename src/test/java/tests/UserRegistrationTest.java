package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	
	
	
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		logger.info("**** Start Logging *******");
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration("Ahmed", "Rashad", "testmail11522234333333@gmail.com", "123456789");
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));

	}
	@Test (dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegistredUsercanlogout() {
		logger.info("Log Out Starting");
		registerObject.logOut();
		logger.info("Log Out ending");

		   
	}
	@Test (dependsOnMethods = {"RegistredUsercanlogout"})
	public void RegisteredUserCanLogin() {
		logger.info("Login Starting");

		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.userLogin("testmail11522234333333@gmail.com", "123456789");
		assertTrue(registerObject.logoutBtn.isDisplayed());
		logger.info("Login Ending");

	}
}
