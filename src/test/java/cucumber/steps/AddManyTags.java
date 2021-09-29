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
import core.utils.ScenarioContext;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class AddManyTags {
    private ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse = new ApiResponse();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("I add the amount of {int} to the total of tags")
    public void tagsBulkAdd(int amount) {
        List<String> tagsTrashList = new ArrayList<>();
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), "18915744_4f5e1d5e81284a083475fe64660390d8d6bb17db")
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.POST_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST);
        String tagName = "";
        for (int i = 0; i < amount; i++) {
            tagName = "tag0" + i;
            apiRequestBuilder.body("{\n"
                    + "  \"tag\": {\n"
                    + "    \"name\": \"" + tagName + "\"\n"
                    + "  }\n"
                    + "}");
            apiRequest = apiRequestBuilder.build();
            tagsTrashList.add(tagName);
            scenarioContext.setTrash("Tags Trash", tagsTrashList);
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
    }

}
