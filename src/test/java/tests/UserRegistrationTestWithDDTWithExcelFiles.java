package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegistrationTestWithDDTWithExcelFiles extends TestBase{
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	
	
	
	@DataProvider (name = "ExcelData")
	public Object[][] userRegistrationData() throws Exception{
	//Get Data from excelSheet Class
		ExcelReader ER= new ExcelReader();
		return ER.getExcelData();
	}
	
	
	@Test (priority = 1,alwaysRun = true,dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String FName,String lastName,String email,String Password) {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(FName, lastName, email,Password);
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.logOut();
		
		
	}
	
}
