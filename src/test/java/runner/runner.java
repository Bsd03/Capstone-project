package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Features/Contact.feature",
				glue={"StepDefinitions","Hooks"},
				plugin= {"pretty","html:target/cucumber-reports/CucumberReport.html",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
	)

public class runner extends AbstractTestNGCucumberTests {

}
