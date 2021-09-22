package com.clickup.hooks;

import com.clickup.api.Endpoints;
import com.clickup.api.entities.Lisst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.clickup.api.utils.BaseRequest.baseRequest;

public class folderlessListHook {

    ApiRequest apiRequest;
    ApiResponse apiResponse;

    @Before(value="@Task")
    public void createFolderlessList() throws JsonProcessingException {
        apiResponse = new ApiResponse();
        Lisst list = new Lisst();
        list.setName("folderlessList");
        apiRequest = baseRequest()
                .method(ApiMethod.POST)
                .endpoint(Endpoints.CREATE_FOLDERLESS_LIST)
                .pathParams("space_id", "3282669")
                .body(list.asString(list))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().all();
    }

    @After(value="@Task")
    public void deleteFolderlessList() {

    }
}
