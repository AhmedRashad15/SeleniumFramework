package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;
import pages.UserRegistationPage;

public class EmailFriendTest extends TestBase{

	//1-User Registeration
	
	//3-Email to Friend
	EmailPage SendEmailToFriend;
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	String ProductName="Apple MacBook Pro 13-inch";
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration("Ahmed", "Rashad", "testmail123333@gmail.com", "123456789");
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}
	//2-Search For Product
	@Test(dependsOnMethods = "UserCanRegisterSuccessfully")
	public void  SearchProductwithAutomateSUggest() throws Exception{
		searchObject=new SearchProductPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject=new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNamebreadCrumb.getText().contains(ProductName));
		
	}
	
	
	//3-Email to Friend
	@Test (dependsOnMethods = "SearchProductwithAutomateSUggest")
	public void RegisteredUserCanSendEmailToFriend() throws Exception{
		detailsObject.openSendEmail();
		SendEmailToFriend=new EmailPage(driver);
		SendEmailToFriend.SendEmailToFriend("myfriend@gmail.com","Hello My Friend");
		Thread.sleep(3000);
		assertTrue(SendEmailToFriend.MessageNotification.getText().contains("Your message has been sent."));
		
		
	}
	
	
	
	
	
	//4 User LogOut
	
	
	@Test (dependsOnMethods = {"RegisteredUserCanSendEmailToFriend"})
	public void RegistredUsercanlogout() {
		registerObject.logOut();
		   
	}
	
}
