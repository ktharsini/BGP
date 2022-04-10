package cucumberTestRunnerOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features = "C:\\Users\\thars\\TechChallenge\\TechChallenge\\src\\test\\java\\features",
glue = "stepDefinition", 
monochrome = true,
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/techchallenge.html"})

public class testNGTestRunner extends AbstractTestNGCucumberTests{


}
