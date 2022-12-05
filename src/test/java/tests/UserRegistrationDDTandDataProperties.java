package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegistrationDDTandDataProperties extends TestBase{
	
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	String fn=LoadProperties.userData.getProperty("firstName");
	String lastName=LoadProperties.userData.getProperty("lastname");
	String email=LoadProperties.userData.getProperty("email");
	String PasswordAuthentication=LoadProperties.userData.getProperty("password");
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(fn, lastName,email, PasswordAuthentication);
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegistredUsercanlogout() {
		registerObject.logOut();
		   
	}
	@Test (dependsOnMethods = {"RegistredUsercanlogout"})
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email, PasswordAuthentication);
		assertTrue(registerObject.logoutBtn.isDisplayed());
	}
}
