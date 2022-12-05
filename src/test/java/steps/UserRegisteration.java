package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{

	HomePage home;
	UserRegistationPage registerObject;


	@Given("the user in the homepage")
	public void the_user_in_the_homepage() {

		home=new HomePage(driver);
		home.openRegistrationPage();

	}
	@When("i click on register link")
	public void i_click_on_register_link() {
		assertTrue(driver.getCurrentUrl().contains("register")); 
	}
	/*
	 * @When("i entered the user data") public void i_entered_the_user_data() {
	 * registerObject=new UserRegistationPage(driver);
	 * registerObject.userRegistration("Ahmed", "Rashad","rashad@test.com",
	 * "123456789"); }
	 */

	@When("i entered {string},{string},{string},{string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject=new UserRegistationPage(driver);
		registerObject.userRegistration(firstname, lastname,email,password);
	}
	@Then("the registeration page displayed successfully")
	public void the_registeration_page_displayed_successfully() {
		registerObject.logOut();
	}	


}
