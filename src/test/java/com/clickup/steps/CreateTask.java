package com.clickup.steps;

import com.clickup.api.Endpoints;
import com.clickup.api.PathParams;
import com.clickup.api.entities.Task;
import com.clickup.api.utils.BaseRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import core.utils.PrerequisiteIds;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

public class CreateTask {

    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private Map<String, String> entity;
    private Map<String, String> objectIds;
    private PrerequisiteIds ids;
    private Task expected_task;
    private Task actual_task;

    public CreateTask(final PrerequisiteIds ids) {
        this.ids = ids;
    }

    @Given("^I build a \"([^\"]*)\" request$")
    public void buildRequest(final ApiMethod method) {
        apiRequest = BaseRequest.baseRequest()
                .method(method)
                .endpoint(Endpoints.CREATE_TASK)
                .pathParams(PathParams.LIST_ID, ids.getObjectId("folderlessList"))
                .build();
    }

    @When("I create a new {string} with parameters:")
    public void createObjectWithParameters(final String entityName, final DataTable object)
            throws JsonProcessingException {
        Map<String, String> json = object.asMap(String.class, String.class);
        entity = new HashMap<>(json);
        expected_task = new Task();
        expected_task.setName(entity.get("name"));
        apiRequest.setBody(expected_task.asString(expected_task));
    }

    @Then("I verify that the response is {int}")
    public void verifyThatTheResponseIs(final int expectedResponse) {
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().all();
        actual_task = new Task();
        actual_task = apiResponse.getBody(Task.class);
        Assert.assertEquals(apiResponse.getStatusCode(), expectedResponse);
    }

    @And("I verify that the parameters are correct")
    public void verifyThatTheParametersAreCorrect() {
        Assert.assertEquals(actual_task.getName(), expected_task.getName());
    }
}
