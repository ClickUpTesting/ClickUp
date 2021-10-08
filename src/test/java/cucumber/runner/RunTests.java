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

import clickup.requests.FoldersRequest;
import clickup.requests.ListsRequest;
import clickup.requests.SpaceRequest;
import clickup.requests.TasksRequests;
import core.utils.ReportGenerator;
import clickup.utils.ScenarioContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    private String teamId = System.getenv("TEAM_ID");
    private ScenarioContext scenarioContext;
    private SpaceRequest spaceRequest = new SpaceRequest();
    private FoldersRequest foldersRequest = new FoldersRequest();
    private ListsRequest listsRequest = new ListsRequest();
    private TasksRequests tasksRequests = new TasksRequests();

    @BeforeSuite
    public void setBaseEnv() throws JsonProcessingException {
        scenarioContext = ScenarioContext.getInstance();
        scenarioContext.setBaseEnvironment("team_id", teamId);
        scenarioContext.setBaseEnvironment("space_id", spaceRequest.createSpace());
        scenarioContext.setBaseEnvironment("folder_id", foldersRequest.createFolder());
        scenarioContext.setBaseEnvironment("list_id", listsRequest.createListInFolder());
        scenarioContext.setBaseEnvironment("list_in_space_id", listsRequest.createListInSpace());
        scenarioContext.setBaseEnvironment("task_id", tasksRequests.createTask());
    }

    @AfterTest()
    public void deleteSpace() {
        spaceRequest.deleteSpace(scenarioContext.getEnvData("space_id"));
    }

    @AfterSuite
    public void createReports() {
        ReportGenerator.generateReport();
    }
}
