package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\projetos\\poctTestCucumber\\src\\test\\java\\features",
        glue = {"C:\\projetos\\poctTestCucumber\\src\\test\\java\\Steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}

        // plugin = {"pretty","html:target/cucumber-tml-report","json:cucumber.json"}
)
public class TestRunner {

}
