/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.steps;

import clickup.ApiEndpoints;
import clickup.entities.features.tasks.Task;
import clickup.entities.features.tasks.Tasks;
import clickup.utils.ScenarioContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.ApiHeaders;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import java.util.LinkedList;

import static core.utils.RandomCustom.random;

public class TasksSteps {
    private ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert = new SoftAssert();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiResponse response = new ApiResponse();

    public TasksSteps(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    @Given("I add the amount of {int} to the total of task")
    public void createNFeatures(int amount)
            throws JsonProcessingException {
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.CREATE_TASK.getEndpoint())
                .pathParams("list_id", scenarioContext.getEnvData("list_id"))
                .method(ApiMethod.POST);
        LinkedList<String> featureTrashList = new LinkedList<>();
        Task task = new Task();
        for (int i = 0; i < amount; i++) {
            task.setName("Serial task".concat(random()));
            apiRequestBuilder.body(new ObjectMapper().writeValueAsString(task));
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, response);
            featureTrashList.addLast(response.getBody(Task.class).getIdentifier());
        }
        scenarioContext.setTrash("FeatureName Trash", featureTrashList);
    }

    @Then("I verify the amount of tasks has increased by {int}")
    public void verifiesTheAmountOfFoldersHasIncreased(int addedTasks) {
        int expected = apiResponse.getBody(Tasks.class).getTasks().size();
        softAssert.assertEquals(addedTasks, expected);
    }
}
