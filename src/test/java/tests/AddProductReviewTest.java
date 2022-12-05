package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;
import pages.UserRegistationPage;

public class AddProductReviewTest extends TestBase{
	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductReviewPage ReviewPageObject;
	String ProductName="Apple MacBook Pro 13-inch";
	@Test (priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration("Ahmed", "Rashad", "testmail11522234333333@gmail.com", "123456789");
		assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		
	}

	@Test (dependsOnMethods = "UserCanRegisterSuccessfully")
	public void  SearchProductwithAutomateSUggest() throws Exception{
		searchObject=new SearchProductPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject=new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNamebreadCrumb.getText().contains(ProductName));
		detailsObject.openAddReviewPage();
		
	}
	@Test (dependsOnMethods = "SearchProductwithAutomateSUggest")
	public void RegisteredUserCanAddReview(){
		ReviewPageObject=new AddProductReviewPage(driver);
		ReviewPageObject.ReviewProduct("Rashadd Review", "Fck This Product");
	}
	
	@Test (dependsOnMethods = {"RegisteredUserCanAddReview"})
	public void RegistredUsercanlogout() {
		registerObject.logOut();
		   
	}
}
