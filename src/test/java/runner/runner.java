package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Features/HomePage.feature",
				glue={"StepDefinitions","Hooks"},
				plugin= {"pretty","html:target/cucumber-reports/CucumberReport.html"}
	)

public class runner extends AbstractTestNGCucumberTests {

}
