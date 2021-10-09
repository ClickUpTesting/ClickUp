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

import clickup.requests.TasksRequests;
import clickup.utils.ScenarioContext;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.When;

public class ApiBasicRequest {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private TasksRequests tasksRequests = new TasksRequests();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public ApiBasicRequest(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @When("^I execute the (.*) request for tags$")
    public void executesRequest(final String method) {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(method)).build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().all();
    }
}
