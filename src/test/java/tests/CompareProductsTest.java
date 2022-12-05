package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchProductPage;

public class CompareProductsTest extends TestBase{
String firstProductName="Apple MacBook Pro 13-inch";
String SecondProductName="Asus N551JK-XO076H Laptop";

//1-Search For Product Number One
//2-Search For Product Numbe two
//3-Add to Compare
//4-Clear List

ProductDetailsPage detailsObject;
HomePage homeObject;
ComparePage compareObject;
SearchProductPage SearchObject;

@Test (priority = 1)
public void UserCanCompareProducts() throws Exception {
	detailsObject=new ProductDetailsPage(driver);
	homeObject=new HomePage(driver);
	compareObject=new ComparePage(driver);
	SearchObject=new SearchProductPage(driver);

	SearchObject.productSearch(firstProductName);
	SearchObject.openProductDetailsPage();
	assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
	detailsObject.openAddToComparePage();
	
	
	SearchObject.productSearch(SecondProductName);
	SearchObject.openProductDetailsPage();
	assertTrue(detailsObject.productNamebreadCrumb.getText().contains(SecondProductName));
	detailsObject.openAddToComparePage();
	detailsObject.OpenComaprePage();
	
	compareObject.CompareProducts();
	
}

@Test(priority = 2)
public void ClearCompareList() throws Exception {
	compareObject.ClearCompareList();
	assertTrue(compareObject.noDataLbl.getText().equals("You have no items to compare."));

}
}
