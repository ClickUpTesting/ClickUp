package com.clickup.hooks;

import com.clickup.api.Endpoints;
import com.clickup.api.PathParams;
import com.clickup.api.entities.Lisst;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import core.utils.PrerequisiteIds;
import core.utils.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Map;

import static com.clickup.api.utils.BaseRequest.baseRequest;

public class FolderlessListHook {

    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private Lisst list;
    private Map<String, String> objectIds;
    private PrerequisiteIds ids;

    public FolderlessListHook(final PrerequisiteIds ids) {
        this.ids = ids;
    }

    @Before(value = "@Task")
    public void createFolderlessList() throws JsonProcessingException {
        String spaceID = PropertiesReader.getProperties("configuration.properties").getProperty("defaultSpaceId");
        apiResponse = new ApiResponse();
        list = new Lisst();
        list.setName("folderlessList");
        apiRequest = baseRequest()
                .method(ApiMethod.POST)
                .endpoint(Endpoints.CREATE_FOLDERLESS_LIST)
                .pathParams(PathParams.SPACE_ID, spaceID)
                .body(list.asString(list))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().all();
        list = apiResponse.getBody(Lisst.class);
        ids.setObjectId(list.getName(), list.getId());
    }

    @After(value = "@Task")
    public void deleteFolderlessList() {
        apiResponse = new ApiResponse();
        apiRequest = baseRequest()
                .method(ApiMethod.DELETE)
                .endpoint(Endpoints.DELETE_LIST)
                .pathParams(PathParams.LIST_ID, list.getId())
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().all();
    }
}
