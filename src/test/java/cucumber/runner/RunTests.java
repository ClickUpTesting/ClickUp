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

import clickup.api.entities.features.folders.Folder;
import clickup.api.entities.features.lists.Lisst;
import clickup.api.entities.features.spaces.Space;
import clickup.api.requests.ChecklistRequest;
import clickup.api.requests.FoldersRequest;
import clickup.api.requests.ListsRequest;
import clickup.api.requests.SpaceRequest;
import clickup.api.requests.TasksRequests;
import core.utils.ReportGenerator;
import clickup.utils.ScenarioContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    private ChecklistRequest checklistRequest = new ChecklistRequest();
    private FileOutputStream fileOutputStream;

    @BeforeSuite
    public void setBaseEnv() throws JsonProcessingException, FileNotFoundException {
        scenarioContext = ScenarioContext.getInstance();
        scenarioContext.setBaseEnvironment("team_id", teamId);
        Space space = spaceRequest.createSpace();
        scenarioContext.setBaseEnvironment("space_id", space.getId());
        scenarioContext.setBaseEnvironment("space_name", space.getName());
        Folder folder = foldersRequest.createFolder();
        scenarioContext.setBaseEnvironment("folder_id", folder.getId());
        scenarioContext.setBaseEnvironment("folder_name", folder.getName());
        Lisst listInFolder = listsRequest.createListInFolder();
        scenarioContext.setBaseEnvironment("list_id", listInFolder.getId());
        scenarioContext.setBaseEnvironment("list_name", listInFolder.getName());
        Lisst listInSpace = listsRequest.createListInSpace();
        scenarioContext.setBaseEnvironment("list_in_space_id", listInSpace.getId());
        scenarioContext.setBaseEnvironment("task_id", tasksRequests.createTask());
        scenarioContext.setBaseEnvironment("checklist_id", checklistRequest.createChecklist());
        fileOutputStream = new FileOutputStream("attachment.txt");
    }

    @AfterTest()
    public void deleteSpace() throws IOException {
        spaceRequest.deleteSpace(scenarioContext.getEnvData("space_id"));
        File file = new File(System.getProperty("user.dir"), "attachment.txt");
        fileOutputStream.close();
        file.delete();
    }

    @AfterSuite
    public void createReports() {
        ReportGenerator.generateReport();
    }
}
