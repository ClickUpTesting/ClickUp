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
import clickup.entities.features.folders.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import clickup.utils.ScenarioContext;
import io.cucumber.java.Before;

public class FolderHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;

    public FolderHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@CreateList or @GetList")
    public void createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder before From API");
        apiRequestBuilder
                .method(ApiMethod.POST)
                .endpoint(ApiEndpoints.CREATE_FOLDER_IN_SPACE.getEndpoint())
                .cleanParams()
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .body(new ObjectMapper().writeValueAsString(folder))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        scenarioContext.setBaseEnvironment("folder_id", apiResponse.getBody(Folder.class).getId());
    }
}
