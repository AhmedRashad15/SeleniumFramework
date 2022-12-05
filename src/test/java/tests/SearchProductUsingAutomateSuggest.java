package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class SearchProductUsingAutomateSuggest extends TestBase{

	SearchProductPage searchObject;
	ProductDetailsPage detailsObject;
	String ProductName="Apple MacBook Pro 13-inch";
	
	@Test
	public void  SearchProductwithAutomateSUggest() throws Exception{
		searchObject=new SearchProductPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject=new ProductDetailsPage(driver);
		assertTrue(detailsObject.productNamebreadCrumb.getText().contains(ProductName));
		
	}
}
