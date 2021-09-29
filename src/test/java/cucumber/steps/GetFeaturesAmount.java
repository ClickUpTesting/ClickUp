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

import clickup.entities.GetAllFeatures;
import clickup.entities.tags.Tags;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.ScenarioContext;
import io.cucumber.java.en.And;

public class GetFeaturesAmount {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public GetFeaturesAmount(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @And("^I (.*) request all (.*) amount$")
    public void getAllTagsAmount(String apiMethod, String featureName){
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        GetAllFeatures featureResponse =  apiResponse.getBody(Tags.class);
        scenarioContext.setFeatures("Initial status", featureResponse);
    }
}
