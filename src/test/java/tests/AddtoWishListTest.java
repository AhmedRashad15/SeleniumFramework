package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;
import pages.UserRegistationPage;
import pages.WishListPage;

public class AddtoWishListTest extends TestBase {

	HomePage homeObject;
	UserRegistationPage registerObject;
	LoginPage loginObject;
	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductReviewPage ReviewPageObject;
	WishListPage wishListObject;
	String ProductName="Apple MacBook Pro 13-inch";
	

	@Test ()
	public void  SearchProductwithAutomateSUggest() throws Exception{
		searchObject=new SearchProductPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject=new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNamebreadCrumb.getText().contains(ProductName));
		
	}
	@Test (dependsOnMethods = "SearchProductwithAutomateSUggest")
	public void UserCanAddToWishList() throws Exception{
		wishListObject=new WishListPage(driver);
		detailsObject.AddProductToWishListPage();
		wishListObject.removeProductFromCart();
		assertTrue(wishListObject.EmptyField.getText().contains("The wishlist is empty!"));
		
		
		
		
	}
	
	
}
