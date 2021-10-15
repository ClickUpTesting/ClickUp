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

public class DependencyRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Add a dependency to a task.
     *
     * @param id to be set on the tag
     * @author Jorge Caceres
     */
    public void addDependency(final String id) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("depends_on", scenarioContext.getEnvData("task_id"));
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.ADD_DEPENDENCY.getEndpoint())
                .pathParams("task_id", id)
                .method(ApiMethod.POST)
                .body(jsonBody.toString())
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    /**
     * Add a link to a task.
     *
     * @param taskId that will be linked
     * @param linkTask to link
     * @author Jorge Caceres
     */
    public void addLinkTask(final String taskId, final String linkTask) {
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.LINK_TASK.getEndpoint())
                .pathParams("task_id", taskId)
                .pathParams("links_to", linkTask)
                .method(ApiMethod.POST)
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }
}
