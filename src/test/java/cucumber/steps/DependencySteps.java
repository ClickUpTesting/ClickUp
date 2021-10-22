/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.steps;

import clickup.entities.features.linkedtasks.LinkedTask;
import clickup.entities.features.linkedtasks.LinkedTasks;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependencySteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ScenarioTrash scenarioTrash;

    public DependencySteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert,
                           ScenarioTrash scenarioTrash) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I make a task depends on another one")
    public void addDependencyToEnvTask() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("depends_on", scenarioContext.getEnvData("task_id"));
        apiRequestBuilder.body(jsonBody.toString());

    }

    @When("I remove the dependency from a task")
    public void removeADependencyFromATask() {
        apiRequestBuilder
                .cleanQueryParams()
                .queryParams("depends_on", scenarioContext.getEnvData("task_id"))
                .queryParams("dependency_of", scenarioTrash.getTrashValue("task_id"));
    }

    @And("I verify the tasks are linked")
    public void verifyLinkedTasks() {
        Map<String, String> linkedTasksIds = new HashMap<>();
        linkedTasksIds.put("task_id", scenarioTrash.getTrashValue("links_to"));
        linkedTasksIds.put("links_to", scenarioTrash.getTrashValue("task_id"));
        LinkedTasks linkedTasks = apiResponse.getBody(LinkedTasks.class);
        List<LinkedTask> linkedTaskList = linkedTasks.getTask().getLinkedTasks();
        boolean isInTask = linkedTaskList.stream()
                .anyMatch(link -> link.getMapOfValues(linkedTasksIds).equals(linkedTasksIds));
        softAssert.assertTrue(isInTask);
    }
}
