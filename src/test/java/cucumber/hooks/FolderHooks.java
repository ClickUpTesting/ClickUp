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
import clickup.api.ApiFacade;
import clickup.entities.features.folders.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import clickup.utils.ScenarioContext;
import io.cucumber.java.Before;

import static core.utils.RandomCustom.random;

public class FolderHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiFacade apiFacade = new ApiFacade();
    private ApiResponse apiResponse;

    public FolderHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@AddTagToTask", order = 1)
    public void createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder created in FolderHooks From API".concat(random()));
        apiResponse = apiFacade.createObject(folder, ApiEndpoints.CREATE_FOLDER_IN_SPACE, "space_id",
                scenarioContext.getEnvData("space_id"));
        scenarioContext.setBaseEnvironment("folder_id", apiResponse.getBody(Folder.class).getId());
    }
}
