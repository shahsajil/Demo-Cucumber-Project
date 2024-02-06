package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/login.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}

//Note: 2nd test will fail of data driven testing of scenario outline.