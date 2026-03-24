package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"stepdefinitions.api", "context"},
        plugin = {"pretty",
                "html:target/cucumber-api.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "junit:target/cucumber-api.xml"
        },
        monochrome = true,
        tags = "@POSTUser"
)
public class ApiRunnerTest {}


