package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id ="FullName")
	WebElement FullNameTxt;
	@FindBy(id="Email")
	WebElement EmailTxt;
	@FindBy(id="Enquiry")
	WebElement EnquiryTxtBox;
	@FindBy(css ="button.button-1.contact-us-button")
	WebElement SubmitBtn;
	@FindBy(css="div.result")
	public WebElement EnquirySuccessMessage;
	
	public void ContactUs(String FullName,String Email,String Message) {
		setText(FullNameTxt, FullName);
		setText(EmailTxt, Email);
		setText(EnquiryTxtBox, Message);
		clickBtn(SubmitBtn);
		
		
	}


}
