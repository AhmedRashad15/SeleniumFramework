package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
	public HomePage(WebDriver driver) {
		super(driver);	
		js=(JavascriptExecutor) driver;
		action=new Actions(driver);
		
	}
	@FindBy(linkText ="Register")
	WebElement registerLink;
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	@FindBy(linkText = "My account")
	WebElement MyAccountbtn;
	@FindBy(linkText = "Contact us")
	WebElement ContactUsLink;
	@FindBy(id = "customerCurrency")
	WebElement currencydrl;
	@FindBy(linkText = "Computers")
	WebElement ComputerMenu;
	@FindBy(linkText = "Notebooks")
	WebElement NotebookMenu;
	
	public void openRegistrationPage() 
	{
		clickBtn(registerLink);
	}
	public void openLoginPage() {
		clickBtn(loginlink);
	}
	public void openMyAccount()
	{
		clickBtn(MyAccountbtn);
	}
	public void openContactUsPage() {
		ScrollToBottom();
		clickBtn(ContactUsLink);
	}
	public void changeCurrency(int index) {
		select=new Select(currencydrl);
		select.selectByIndex(index);
	}
	public void SelectNotebookMenu()
	{
		action.moveToElement(ComputerMenu).perform();
		clickBtn(NotebookMenu);
	}
	}
