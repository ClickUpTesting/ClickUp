package cucumber.steps;

import clickup.entities.FeatureFactory;
import clickup.entities.GetAllFeatures;
import clickup.entities.tags.Tags;
import core.api.*;
import core.utils.ScenarioContext;
import io.cucumber.java.en.And;

public class GetFeaturesAmount {
    ApiRequestBuilder apiRequestBuilder;
    ApiRequest apiRequest;
    ApiResponse apiResponse;
    FeatureFactory featureFactory = new FeatureFactory();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();
    public GetFeaturesAmount(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @And("^I (.*) request all (.*) amount$")
    public void iGETRequestAllTagsAmount(String apiMethod, String featureName) throws IllegalAccessException {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        GetAllFeatures featureResponse =  apiResponse.getBody(Tags.class);
        scenarioContext.setFeatures("Initial status", featureResponse );
    }
}
