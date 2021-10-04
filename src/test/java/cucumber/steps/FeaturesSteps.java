/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.steps;

import clickup.entities.features.FeatureFactory;
import clickup.entities.features.IFeature;
import clickup.utils.ScenarioContext;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.Given;
import java.util.LinkedList;
import java.util.List;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class FeaturesSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private FeatureFactory featureFactory = new FeatureFactory();

    public FeaturesSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Given("^I set the (.*) (.*) with the endpoint to (.*)$")
    public void createNFeatures(String numberEntities, String featureName, String endpoint)
            throws IllegalAccessException {
        List<String> pathParamsList = getPathParamsFromEndpoint(endpoint);
        apiRequestBuilder
                .endpoint(endpoint)
                .cleanParams()
        .method(ApiMethod.POST);
        pathParamsList.forEach(pathParams -> apiRequestBuilder.pathParams(
                pathParams,
                scenarioContext.getEnvData(pathParams)));
        IFeature feature = featureFactory.getFeature(featureName);
        LinkedList<String> featureTrashList = new LinkedList<>();
        IFeature featureResponse;

        for (int i = 0; i < Integer.parseInt(numberEntities); i++) {
            apiRequestBuilder.body(feature.getRequiredField());
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            featureResponse = apiResponse.getBody(featureFactory.getFeature(featureName).getClass());
            featureTrashList.addLast(featureResponse.getIdentifier());
        }
        scenarioContext.setTrash("FeatureName Trash", featureTrashList);
    }
}
