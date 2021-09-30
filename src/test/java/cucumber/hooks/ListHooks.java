/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.hooks;

import clickup.ApiEndpoints;
import clickup.entities.Lisst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import clickup.utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ListHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;

    public ListHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }


    @Before(value = "@GetList", order = 1)
    public void createList() throws JsonProcessingException {
        Lisst lisst = new Lisst();
        lisst.setName("List before From API");
        apiRequestBuilder
                .method(ApiMethod.POST)
                .endpoint(ApiEndpoints.CREATE_LIST_IN_FOLDER.getEndpoint())
                .pathParams("folder_id", scenarioContext.getEnvData("folder_id"))
                .body(new ObjectMapper().writeValueAsString(lisst))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        scenarioContext.setBaseEnvironment("list_id", apiResponse.getBody(Lisst.class).getId());
    }


    @After(value = "@CreateList", order = 1)
    public void deleteList() {
        apiRequestBuilder
                .method(ApiMethod.DELETE)
                .endpoint(ApiEndpoints.GET_LIST.getEndpoint())
                .cleanParams()
                .pathParams("list_id", scenarioContext.getEnvData("list_id"))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
    }
}
