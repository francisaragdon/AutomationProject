package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "api.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true,
        tags = "@POSTItem"
)
public class ApiTestRunner {
}
