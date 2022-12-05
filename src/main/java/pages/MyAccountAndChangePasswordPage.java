package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountAndChangePasswordPage extends PageBase{
public MyAccountAndChangePasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



@FindBy(css = "span.close")
WebElement closeChangePasswordMessage;
@FindBy(linkText  = "Change password")
 WebElement changePasswordLink;
@FindBy(css = "p.content")
public WebElement successChangepasswordMessage;
@FindBy(id = "OldPassword")
WebElement oldPasswordField;
@FindBy(id="NewPassword")
WebElement newPasswordField;
@FindBy(id = "ConfirmNewPassword")
WebElement ConfirmPasswordField;
@FindBy(css = "button.button-1.change-password-button")
WebElement changePasswordBtn;
	




public void openChangePasswordPage() {
	clickBtn(changePasswordLink);
}
public void ChangePassword(String oldPassword,String newPassword) {
	setText(oldPasswordField, oldPassword);
	setText(newPasswordField, newPassword);
	setText(ConfirmPasswordField, newPassword);
	clickBtn(changePasswordBtn);
	clickBtn(closeChangePasswordMessage);
}



}
