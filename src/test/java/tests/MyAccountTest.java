package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountAndChangePasswordPage;
import pages.UserRegistationPage;

public class MyAccountTest extends TestBase {

	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	MyAccountAndChangePasswordPage myAccountObject;
	String oldPassword="123456789";
	String newPassword="123456789100";
	String firstName="Ahmed";
	String lastName="Rashad";
	String email="test121556666611111@gmail.com";
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}
		@Test (dependsOnMethods = {"UserCanRegisterSuccessfully"})
		public void RegisteredUserCanChangePassword() throws InterruptedException {
			myAccountObject=new MyAccountAndChangePasswordPage(driver);
			homeObject=new HomePage(driver);
			homeObject.openMyAccount();	
			myAccountObject.openChangePasswordPage();
			myAccountObject.ChangePassword(oldPassword, newPassword);
			assertTrue(myAccountObject.successChangepasswordMessage.getText().contains("Password"));
			Thread.sleep(5000);

		}
		@Test (dependsOnMethods = {"RegisteredUserCanChangePassword"})
		public void RegistredUsercanlogout() {
			registerObject.logOut();
			   
		}
		@Test (dependsOnMethods = {"RegistredUsercanlogout"})
		public void RegisteredUserCanLogin() {
			homeObject.openLoginPage();
			loginObject=new LoginPage(driver);
			loginObject.userLogin(email,newPassword);
			assertTrue(registerObject.logoutBtn.isDisplayed());
		}
	
	
}
