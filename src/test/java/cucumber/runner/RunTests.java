package cucumber.runner;

import core.utils.ScenarioContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {"src/test/resources/features/tags"},
        plugin = {"html:target/site/cucumber-pretty.html", "json:target/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void setBaseEnv(){
        ScenarioContext scenarioContext = ScenarioContext.getInstance();
        scenarioContext.setBaseEnvironment("space_id", "12950133");
    }

}
