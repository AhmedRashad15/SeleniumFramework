package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;
	@FindBy(css="div.no-data")
	public WebElement noDataLbl;
	@FindBy(css="table.compare-products-table")
	WebElement compareTable;
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	@FindBy(tagName = "td")
	public List<WebElement> allColumns;
	public void ClearCompareList() throws Exception{
		clickBtn(clearListBtn);
		Thread.sleep(3000);

	}
	public void CompareProducts() {
		//Get All Rows
		System.out.println(allRows.size());
		//Get Data From Rows
		for(WebElement row:allRows) {
			System.out.println(row.getText()+ "\t");
			for(WebElement col :allColumns) {
				System.out.println(col.getText()+"\t");
			}
		}
	}

}
