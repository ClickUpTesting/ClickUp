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
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import clickup.utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.json.JSONObject;
import java.util.LinkedList;

public class TagsHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;

    public TagsHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@DeleteTag")
    public void createTag() {
        LinkedList<String> tagsTrashList = new LinkedList<>();
        String tagName = "deleteMe";
        JSONObject jsonBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        tagBody.put("name", tagName);
        jsonBody.put("tag", tagBody);
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.CREATE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST)
                .body(jsonBody.toString())
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        tagsTrashList.add(tagName);
        scenarioContext.setTrash("Tags", tagsTrashList);
    }

    @After(value = "@CreateTag")
    public void deleteTags() {
        LinkedList<String> tagsTrashList = scenarioContext.getTrashList("Tags");
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.DELETE);
        for (String tagName : tagsTrashList) {
            apiRequestBuilder.pathParams("tag_name", tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
        scenarioContext.getTrashList("Tags").clear();
    }

    @Before(value = "@AddTagToTask", order = 3)
    public void addTagToTask() {
        createTag();
    }

    @After(value = "@AddTagToTask", order = 3)
    public void deleteTagFromTask() {
        deleteTags();
    }
}
