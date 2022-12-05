package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(css = "Apple MacBook Pro 13-inch")
public WebElement ProductName;
@FindBy(css="button.remove-btn")
WebElement removeBtn;
@FindBy(css="button.button-2.email-a-friend-wishlist-button")
WebElement EmailtoFriendBtn;
@FindBy(css = "button.button-2.wishlist-add-to-cart-button")
WebElement AddtoCartBtn;
@FindBy(css = "a.share-link")
WebElement shareTextLink;
@FindBy(id = "updatecart")
WebElement updateCartBtn;
@FindBy(css = "div.no-data")
public WebElement EmptyField;
public void removeProductFromCart() {
	clickBtn(removeBtn);
}

}
