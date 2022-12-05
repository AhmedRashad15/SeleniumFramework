package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegisterationWithDDTAndFakerData extends TestBase{
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	Faker fakeData=new Faker();
	String firstname=fakeData.name().firstName();
	String lastname=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(8).toString();
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws IllegalArgumentException, IOException, ParseException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(firstname,lastname ,email ,password );
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.logOut();
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
		assertTrue(registerObject.logoutBtn.isDisplayed());
	}
}
