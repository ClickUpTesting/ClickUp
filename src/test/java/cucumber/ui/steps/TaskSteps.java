/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.ui.steps;

import clickup.ui.pages.ListPage;
import clickup.ui.pages.sidebar.CreateNew;
import clickup.ui.pages.sidebar.FeatureSettings;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.TaskForm;
import clickup.ui.pages.task.TaskPage;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.Map;

public class TaskSteps {
    protected WebDriverManager webDriverManager;
    protected ScenarioTrash scenarioTrash;
    private ScenarioContext scenarioContext;
    private Map<String, String> settingsMap;
    private SoftAssert softAssert;

    public TaskSteps(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash, SoftAssert softAssert) {
        this.webDriverManager = webDriverManager;
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
        scenarioContext = ScenarioContext.getInstance();
    }

    @When("I create a new task with field")
    public void createANewTaskWithField(final Map<String, String> settingsMap) {
        this.settingsMap = settingsMap;
        SideBar sideBar = new SideBar(webDriverManager);
        sideBar.clickInASpace(scenarioContext.getEnvData("space_name"));
        sideBar.clickFolderInSpace(scenarioContext.getEnvData("space_name"));
        sideBar.clickInAList(scenarioTrash.getTrashValue("list_name"));
        FeatureSettings settings = sideBar.clickInSettingList();
        CreateNew createNew = settings.clickCreateNew();
        TaskForm taskForm = createNew.clickNewTask();
        taskForm.setTaskName(settingsMap.get("name"));
        taskForm.clickCreateTaskButton();
    }

    @Then("^I verify that the (?:.*) task contains the default values$")
    public void verifyThatTheCreatedTaskContainsTheDefaultValues() {
        ListPage listPage = new ListPage(webDriverManager);
        softAssert.assertTrue(listPage.getTasks().stream().
                anyMatch(value -> value.equals(settingsMap.get("name"))));
    }

    @When("I update a new task with field")
    public void updateANewTaskWithField(final Map<String, String> settingsMap) {
        this.settingsMap = settingsMap;
        scenarioTrash.setScenarioBodyRequest(settingsMap);
        TaskPage taskPage = new TaskPage(webDriverManager);
        taskPage.typeName(settingsMap.get("name"));
        taskPage.clickCloseIcon();
    }
}
