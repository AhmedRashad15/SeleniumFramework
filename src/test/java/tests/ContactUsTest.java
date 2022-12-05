package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	HomePage ContactUsBtn;
	ContactUsPage contactUsObject;
	String FullName="Ahmed Rashad";
	String Email="test152@gmail.com";
	String Message="Fuck you";
	
	@Test
	public void ContactUsSubmit() {
		ContactUsBtn= new HomePage(driver);
		ContactUsBtn.openContactUsPage();
		contactUsObject=new ContactUsPage(driver);
		contactUsObject.ContactUs(FullName, Email, Message);
		assertTrue(contactUsObject.EnquirySuccessMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
		
	}

}
