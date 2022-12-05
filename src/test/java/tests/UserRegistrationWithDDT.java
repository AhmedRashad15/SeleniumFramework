package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegistrationWithDDT extends TestBase{


	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testData")
	public static Object[][] UserData()
	{


		return new Object[][] {
			{"Ahmed","Rashadd","testcvvvv@gmail.com","12345678"},
			{"Ahmed","Alii","testvvvvvv@gmail.com","12345678"}
			};
	}








	@Test (priority = 1,alwaysRun = true,dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fName,String lName,String email,String password) {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(fName, lName, email,password);
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.logOut();
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(fName, lName, email,password);
		registerObject.logOut();
		loginObject.userLogin(email, password);
		


	}

}
