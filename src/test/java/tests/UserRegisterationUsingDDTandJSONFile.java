package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegisterationUsingDDTandJSONFile extends TestBase{
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws IllegalArgumentException, IOException, ParseException{
		JsonDataReader jsonR=new JsonDataReader();
		jsonR.JsonReader();
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(jsonR.firstname,jsonR.lastname ,jsonR.email ,jsonR.password );
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.logOut();
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(jsonR.email, jsonR.password);
		assertTrue(registerObject.logoutBtn.isDisplayed());
	}

}
