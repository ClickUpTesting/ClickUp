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

import clickup.ApiEndpoints;
import core.api.ApiHeaders;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import clickup.utils.ScenarioContext;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AddTagsStep {
    private ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse = new ApiResponse();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("I add the amount of {int} to the total of tags")
    public void tagsBulkAdd(int amount) {
        List<String> tagsTrashList = new ArrayList<>();
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.POST_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST);
        String tagName = "tag0";
        JSONObject jsonBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        for (int i = 0; i < amount; i++) {
            tagBody.put("name",tagName+i);
            apiRequestBuilder.body(jsonBody.put("tag",tagBody).toString());
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
            tagsTrashList.add(tagName);

        }
        scenarioContext.setTrash("Tags Trash", tagsTrashList);
    }

}
