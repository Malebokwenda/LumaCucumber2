package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Login",
        glue = "stepDefinition" ,
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}