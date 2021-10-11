/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.hooks;

import clickup.ApiEndpoints;
import clickup.api.ApiFacade;
import clickup.entities.features.Tasks.Task;
import clickup.utils.ScenarioContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static core.utils.RandomCustom.random;

public class TasksHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiFacade apiFacade = new ApiFacade();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;

    public TasksHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@AddTagToTask", order = 3)
    public void createTask() throws JsonProcessingException {
        Task task = new Task();
        task.setName("Task before From API".concat(random()));
        apiRequestBuilder
                .cleanParams()
                .method(ApiMethod.POST)
                .endpoint(ApiEndpoints.CREATE_TASK.getEndpoint())
                .pathParams("list_id", scenarioContext.getEnvData("list_id"))
                .body(new ObjectMapper().writeValueAsString(task))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        scenarioContext.setBaseEnvironment("task_id", apiResponse.getBody(Task.class).getId());
        apiResponse.getResponse().then().log().body();
    }

    @After(value = "@DeleteTask", order = 2)
    public void deleteList() {
        apiFacade.deleteObject(ApiEndpoints.DELETE_TASK, "task_id", scenarioContext.getEnvData("task_id"));
    }
}
