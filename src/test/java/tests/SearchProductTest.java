package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class SearchProductTest extends TestBase {
String ProductName="mac";
SearchProductPage searchObject;
ProductDetailsPage detailsObject;

@Test
public void UserCanSearchForProduct() throws Exception{
	searchObject=new SearchProductPage(driver);
	detailsObject=new ProductDetailsPage(driver);
	searchObject.productSearch(ProductName);
	Thread.sleep(5000);
	assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
	//assertTrue(detailsObject.productNamebreadCrumb.getText(),ProductName);
}
	
}
