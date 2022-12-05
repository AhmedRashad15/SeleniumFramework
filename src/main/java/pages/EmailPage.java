package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage  extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		}

	@FindBy(id ="FriendEmail")
	WebElement FriendEmailField;
	@FindBy(id="YourEmailAddress")
	WebElement LoggedEmail;
	@FindBy(id="PersonalMessage")
	WebElement PersonalMessageField;
	@FindBy(css ="button.button-1.send-email-a-friend-button")
	WebElement SendEmailBtn;
	@FindBy(css="div.result")
	public WebElement MessageNotification;
	
	public void SendEmailToFriend(String FriendEmailTxt,String PersonalMessage) {
		setText(FriendEmailField, FriendEmailTxt);
		setText(PersonalMessageField, PersonalMessage);
		clickBtn(SendEmailBtn);
		
	}
	
}
