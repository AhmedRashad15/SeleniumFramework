package runner;


import io.cucumber.testng.CucumberOptions;
import tests.TestBase;
@CucumberOptions(features = "src/test/java/features",
glue = {"steps"},
plugin = {"pretty","html:target/cucumber-reports/html-report.html"},
monochrome = true
)
public class TestRunner extends TestBase{

	
}
