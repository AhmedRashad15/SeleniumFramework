package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
protected WebDriver driver;
public JavascriptExecutor js;
public Select select;
public Actions action;

	//Create constructors
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
protected static void clickBtn(WebElement btn) {
	btn.click();
}
protected static void setText(WebElement TxtElement ,String value) {
	TxtElement.sendKeys(value);	
}
public void ScrollToBottom() {
	js.executeScript("scrollBy(0,2500)");
}
}
