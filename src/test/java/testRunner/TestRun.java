package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/Customer.feature", 
					glue = "stepDefinitions", 
					dryRun = true, 
					monochrome=true,
							
					plugin = { "pretty","html:target/cucumber-reports.html" }
)

public class TestRun {

}
