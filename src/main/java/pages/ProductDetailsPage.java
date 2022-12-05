package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;	
	@FindBy (css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	@FindBy(id="price-value-4")
	public WebElement productPriceLabel;
	@FindBy (linkText = "Add your review")
	WebElement addReviewLink;
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement WishListBtn;
	@FindBy(linkText = "wishlist")
	WebElement WishListLink;
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompareBtn;
	@FindBy(linkText = "product comparison")
	WebElement ProductComparisonLink;
	@FindBy(css = "button.button-1.add-to-cart-button")
	WebElement AddtoCartBtn;
	@FindBy(linkText = "shopping cart")
	WebElement ShoppingCartLink;
	public void openSendEmail() {
		clickBtn(emailFriendBtn);
	}
	public void openAddReviewPage() {
		clickBtn(addReviewLink);
	}
	public void openAddToComparePage() {
		clickBtn(AddToCompareBtn);
	}
	
	public void AddtoCartProduct() throws Exception {
		clickBtn(AddtoCartBtn);
		Thread.sleep(2000);
		clickBtn(ShoppingCartLink);
	}
	
	
	public void AddProductToWishListPage() throws Exception {
		clickBtn(WishListBtn);
		Thread.sleep(2000);
		clickBtn(WishListLink);
	}
	public void OpenComaprePage() throws Exception {
		Thread.sleep(2000);
		clickBtn(ProductComparisonLink);
		
	}
	
	
}
