package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistationPage;

public class UserRegistrationTestWithDDTandCSVFiles extends TestBase{
	//get path of csv file
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws Exception{
		String csvFile=System.getProperty("user.dir")+"\\src\\test\\java\\data\\CSVData.csv";
		reader=new CSVReader(new FileReader(csvFile));
		
		String[] csvCell ;
		
		//while loop will be executed till the lastValue in CSV file.
		while((csvCell=reader.readNext())!=null)
		{
			String firstname=csvCell[0];
			String lastname=csvCell[1];
			String email=csvCell[2];
			String password=csvCell[3];
			homeObject=new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject=new UserRegistationPage(driver);
			registerObject.userRegistration(firstname, lastname,email,password);
			assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
			registerObject.logOut();
			homeObject.openLoginPage();
			loginObject=new LoginPage(driver);
			loginObject.userLogin(email,password);
			assertTrue(registerObject.logoutBtn.isDisplayed());
			registerObject.logOut();

		}
		
	}
	
}
