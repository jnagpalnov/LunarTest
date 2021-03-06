package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"message", "html:build/reports/tests/cucumber/cucumber-report.html"},
        monochrome = true
)
public class CucumberTestsRunner {

}
