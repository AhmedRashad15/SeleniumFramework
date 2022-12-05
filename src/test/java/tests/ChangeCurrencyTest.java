package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class ChangeCurrencyTest extends TestBase{
HomePage homeObject;
ProductDetailsPage detailsObject;
SearchProductPage searchObject;
String ProductName="Apple MacBook Pro 13-inch";


@Test(priority = 1)
public void UserCanChangeCurrency() {
	homeObject=new HomePage(driver);
	detailsObject=new ProductDetailsPage(driver);
	homeObject.changeCurrency(1);
}

@Test (priority = 2)
public void  SearchProductwithAutomateSUggest() throws Exception{
	try {
		searchObject=new SearchProductPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject=new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNamebreadCrumb.getText().contains(ProductName));
		assertTrue(detailsObject.productPriceLabel.getText().contains("€"));
		System.out.println(detailsObject.productPriceLabel);
	} catch (Exception e) {
		System.out.println("Error is "+ e.getMessage());
	}
	
		
}
}
