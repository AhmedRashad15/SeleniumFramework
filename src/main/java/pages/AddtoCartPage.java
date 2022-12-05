package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtoCartPage extends PageBase{

	public AddtoCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "checkout")
	WebElement CheckoutBtn;
	@FindBy(id = "termsofservice")
	WebElement TermsandServiceBtn;
	@FindBy(id="itemquantity11226")
	WebElement ItemQuantityField;
	@FindBy(css = "button.remove-btn")
	WebElement RemoveBtn;
	@FindBy(id = "updatecart")
	WebElement updateCartBtn;
	
	public void openCheckoutPage()
	{
		clickBtn(TermsandServiceBtn);
		clickBtn(CheckoutBtn);
	}
	public void UpdateProductQuantity(String Quantity) {
		setText(ItemQuantityField, Quantity);
		
	}
	
}
