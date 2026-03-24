package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/web",
        glue = {"stepdefinitions", "hooks", "web"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },

        monochrome = true,

        tags = "@Regression"
)
public class WebRunnerTest {}