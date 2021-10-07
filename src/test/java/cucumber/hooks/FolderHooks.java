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
import clickup.utils.ScenarioContext;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.LinkedList;

import static core.utils.RandomCustom.random;

public class FolderHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiFacade apiFacade = new ApiFacade();
    private ApiResponse apiResponse;
    private ApiRequest apiRequest;

    public FolderHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@CreateFolder or @AddTagToTask", order = 1)
    public void createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder created in FolderHooks From API".concat(random()));
        apiResponse = apiFacade.createObject(folder, ApiEndpoints.CREATE_FOLDER_IN_SPACE, "space_id",
                scenarioContext.getEnvData("space_id"));
        scenarioContext.setBaseEnvironment("folder_id", apiResponse.getBody(Folder.class).getId());
    }

    @After(value = "@DeleteFolder")
    public void deleteFolder() {
        apiFacade.deleteObject(ApiEndpoints.GET_FOLDER, "folder_id", scenarioContext.getEnvData("folder_id"));
    }

    @After(value = "@DeleteFolders")
    public void deleteFolders() {
        LinkedList<String> foldersTrashList = scenarioContext.getTrashList("Folders");
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_FOLDER.getEndpoint())
                .method(ApiMethod.DELETE);
        for (String folderid : foldersTrashList) {
            apiRequestBuilder.pathParams("folder_id", folderid);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
        scenarioContext.getTrashList("Folders").clear();
    }
}
