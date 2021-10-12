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

import clickup.entities.features.IGetAllFeatures;
import clickup.entities.features.tags.Tag;
import clickup.entities.features.tags.Tags;
import clickup.entities.features.tasks.Task;
import clickup.requests.TagsRequest;
import clickup.requests.TasksRequests;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TagsSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    private TagsRequest tagsRequest;
    private TasksRequests tasksRequests;
    private ScenarioTrash scenarioTrash;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public TagsSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, ScenarioTrash scenarioTrash,
                     SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
        this.apiResponse = apiResponse;
        this.tagsRequest = new TagsRequest();
        this.tasksRequests = new TasksRequests();
    }

    @When("I set the tags body with following values:")
    public void setTagBody(final Map<String, String> body) {
        if (body.get("name") != null) {
            scenarioTrash.setScenarioTrash("tag_name", body.get("name"));
        }
        JSONObject jsonBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        for (String tagComponent: body.keySet()) {
            tagBody.put(tagComponent, body.get(tagComponent));
        }
        jsonBody.put("tag", tagBody);
        apiRequestBuilder.body(jsonBody.toString());
    }

    @When("I add the amount of {int} to the total of tags")
    public void tagsBulkAdd(int amount) {
        LinkedList<String> tagsTrashList = new LinkedList<>();
        String tagName = "tag00";
        for (int i = 0; i < amount; i++) {
            tagName = tagName + i;
            tagsRequest.createTag(tagName);
            tagsTrashList.addLast(tagName);
        }
        scenarioContext.setTrash("Tags", tagsTrashList);
    }

    @And("^I (.*) request all (?:.*?) amount$")
    public void getAllTagsAmount(String apiMethod) {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        IGetAllFeatures featureResponse =  apiResponse.getBody(Tags.class);
        scenarioContext.setFeatures("Initial status", featureResponse);
    }

    @Then("I verify the amount of has increased by {int}")
    public void verifyAmountOfTags(int amount) {
        int actual = scenarioContext.getFeatures("Initial status").getAmount() + amount;
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        IGetAllFeatures featureResponse = apiResponse.getBody(Tags.class);
        int expected = featureResponse.getAmount();
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }

    @Then("I verify that the tag does not exist in the task")
    public void verifyTagAbsenceByName() {
        Task task = tasksRequests.getTask(scenarioContext.getEnvData("task_id"));
        List<Tag> tagsList = task.getTags();
        String tagName = scenarioTrash.getTrashValue("tag_name");
        boolean isInTask = tagsList.stream().anyMatch(tag -> tag.getName().equals(tagName));
        softAssert.assertFalse(isInTask);
    }
}

