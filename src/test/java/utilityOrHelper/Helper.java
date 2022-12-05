package utilityOrHelper;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {
	//Method to take screenshot when the test case fail

	public static void captureScreenShot(WebDriver driver,String screenShotName) {
		Path dest=Paths.get("./ScreenShots/"+screenShotName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out=new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		}catch (Exception e) {
		
			System.out.println("Error is "+e.getMessage());
		}
	}
}
