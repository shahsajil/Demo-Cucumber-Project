package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Products.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false)   // make true to see all the steps has been covered or not.

public class TestRunner2 extends AbstractTestNGCucumberTests {
}
