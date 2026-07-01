package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features",glue={"StepDefinitions","Hooks"})
public class runner extends AbstractTestNGCucumberTests {

}
