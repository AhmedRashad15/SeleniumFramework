package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends PageBase{

	public SearchProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id ="small-searchterms")
	WebElement SearchTxtBox;
	@FindBy(css="button.button-1.search-box-button")
	WebElement SearchBtn;
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[1]/a/img")
	WebElement imgLink;
	
	public void productSearch(String ProductName) throws Exception{
		setText(SearchTxtBox, ProductName);
		clickBtn(SearchBtn);
		Thread.sleep(3000);
		
	}
	public void openProductDetailsPage() throws Exception{
		Thread.sleep(3000);
		clickBtn(imgLink);
	}
	public void ProductSearchUsingAutoSuggest(String SearchTxt) throws Exception{
		setText(SearchTxtBox, SearchTxt);
		Thread.sleep(3000);
		productList.get(0).click();
	}
	

}
