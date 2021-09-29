/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package cucumber.runner;

import core.utils.ReportGenerator;
import core.utils.ScenarioContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void setBaseEnv() {
        ScenarioContext scenarioContext = ScenarioContext.getInstance();
        scenarioContext.setBaseEnvironment("space_id", "12950133");
    }

    @AfterSuite
    public void createReports() {
        ReportGenerator.generateReport();
    }
}
