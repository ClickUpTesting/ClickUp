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
    public ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("I add the amount of {int} to the total of tags")
    public void tagsBulkAdd(int arg0) {
        List<String> tagsTrashList = new ArrayList<>();
        apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "3152915_d6831bb6342aea560c0d7bdcfd16a6f9ce50b1fb")
                .headers("Content-Type", "application/json")
                .endpoint("/space/{space_id}/tag")
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST);
        String tagName = "";
        for (int i = 0; i < arg0; i++) {
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
