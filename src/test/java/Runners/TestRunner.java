package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resourcers/features",
        glue = {"Steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}

        // plugin = {"pretty","html:target/cucumber-tml-report","json:cucumber.json"}
)
public class TestRunner {

}
