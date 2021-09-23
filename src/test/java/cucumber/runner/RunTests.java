package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:target/site/cucumber-pretty.html", "json:target/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {

}
