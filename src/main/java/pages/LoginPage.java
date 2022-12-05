package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "Email")
	WebElement emailfield;
	@FindBy(id = "Password")
	WebElement passwordField;
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;
	
	public void userLogin(String email,String Password) 
	{
		setText(emailfield, email);
		setText(passwordField,Password);
		clickBtn(loginBtn);
	}
	
	
	
	
}
