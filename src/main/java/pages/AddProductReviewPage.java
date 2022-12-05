package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;
	@FindBy(id="AddProductReview_ReviewText")
	WebElement ReviewTextField;
	@FindBy(id="addproductrating_4")
	WebElement addRatingBtn;
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement AddReviewBtn;

	public void ReviewProduct(String ReviewTitle,String ReviewTxt) {
		setText(reviewTitleTxt, ReviewTitle);
		setText(ReviewTextField, ReviewTxt);
		clickBtn(addRatingBtn);
		clickBtn(AddReviewBtn);
	
	}
}
