/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.requests;

import clickup.ApiEndpoints;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import org.json.JSONObject;
import java.util.LinkedList;

public class TagsRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Creates a tag.
     *
     * @param tagName to be set on the tag
     * @author Jorge Caceres
     */
    public void createTag(final String tagName) {
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
    }

    /**
     * Adds a tag to a task.
     *
     * @param tagName to be added to a task
     * @author Jorge Caceres
     */
    public void addTagToTask(final String tagName) {
        apiRequestBuilder
                .cleanParams()
                .clearBody()
                .endpoint(ApiEndpoints.ADD_TAG_TO_TASK.getEndpoint())
                .pathParams("task_id", scenarioContext.getEnvData("task_id"))
                .pathParams("tag_name", tagName)
                .method(ApiMethod.POST);
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    /**
     * Removes a tag from a task.
     *
     * @param tagName to be removed from a task
     * @author Jorge Caceres
     */
    public void removeTagFromTask(final String tagName) {
        apiRequestBuilder
                .cleanParams()
                .clearBody()
                .endpoint(ApiEndpoints.REMOVE_TAG_FROM_TASK.getEndpoint())
                .pathParams("task_id", scenarioContext.getEnvData("task_id"))
                .pathParams("tag_name", tagName)
                .method(ApiMethod.DELETE);
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    /**
     * Deletes a tag's list.
     *
     * @author Jorge Caceres
     */
    public void deleteTagsList() {
        LinkedList<String> tagsTrashList = scenarioContext.getTrashList("Tags");
        apiRequestBuilder
                .cleanParams()
                .clearBody()
                .endpoint(ApiEndpoints.DELETE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.DELETE);
        for (String tagName : tagsTrashList) {
            apiRequestBuilder.pathParams("tag_name", tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
    }

    /**
     * Deletes a tag.
     *
     * @param tagName tag's name to be deleted
     * @author Jorge Caceres
     */
    public void deleteTag(String tagName) {
        apiRequestBuilder
                .cleanParams()
                .clearBody()
                .endpoint(ApiEndpoints.DELETE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.DELETE);
            apiRequestBuilder.pathParams("tag_name", tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
    }
}
