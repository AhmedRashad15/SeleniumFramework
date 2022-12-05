	package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistationPage extends PageBase{

	public UserRegistationPage(WebDriver driver) {
		super(driver);
	}	
	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	@FindBy(id = "FirstName")
	WebElement firstNameTxtBox;
	@FindBy (id="LastName")
	WebElement lastNameTxtBox;
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	@FindBy(id = "Password")
	WebElement passwordTxt;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxt;
	@FindBy(id = "register-button")
	WebElement registerBtn;
	@FindBy(css="a.ico-logout")
	public WebElement logoutBtn;
	@FindBy(css = "div.result")
	public WebElement successmessage;
	
	
	
	public void userRegistration(String firstName,String lastName,String email,String password)
	{
		clickBtn(genderRdoBtn);
		setText(firstNameTxtBox, firstName);
		setText(lastNameTxtBox, lastName);
		setText(emailTxtBox, email);
		setText(passwordTxt, password);
		setText(confirmPasswordTxt, password);
		clickBtn(registerBtn);
		
	}
	public void logOut() {
		
		clickBtn(logoutBtn);
	}
	
	
}
