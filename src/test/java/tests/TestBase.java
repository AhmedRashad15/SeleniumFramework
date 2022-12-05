package tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilityOrHelper.Helper;


public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	public static String downloadPath=System.getProperty("user.dir")+"/Downloads";
	public Logger logger;

	public static FirefoxOptions firefoxOptions() {
		FirefoxOptions options=new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", downloadPath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		options.addPreference("browser.download.manager.showWhenStarting", false);
		options.addPreference("pdfjs.disabled", true);
		
		return options;
	
	}
	
	
	public static ChromeOptions chromeOptions() {
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Object> chromePrefs=new HashMap<String,Object>();
		chromePrefs.put("profile.default.content_setting.popups", 0);
		chromePrefs.put("download.default.directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		return options;
	
	}
	
	
	
	
	@BeforeSuite
	@Parameters ({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		logger=LogManager.getLogger(this.getClass());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver=new ChromeDriver(chromeOptions());
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver=new FirefoxDriver(firefoxOptions());
		}
		else {
			System.out.println("Values must be in (Chrome or Firefox)");
			
		}
		
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	//Take screenShot When TestCase Fail and add it in the screenshots  Folder
	@AfterMethod
	public void screenShotonFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			System.out.println("Failed");
			System.out.println("Taking screenshot ....");
			Helper.captureScreenShot(driver, result.getName());			
		}
		
	}
	
	
}
