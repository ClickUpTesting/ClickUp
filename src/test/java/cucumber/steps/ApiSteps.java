/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package cucumber.steps;

import clickup.ApiEndpoints;
import clickup.api.ApiFacade;
import clickup.entities.features.FeatureFactory;
import clickup.entities.features.IFeature;
import clickup.entities.features.folders.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import clickup.utils.ScenarioContext;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;
import static core.utils.RandomCustom.random;

public class ApiSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private FeatureFactory featureFactory = new FeatureFactory();
    private SoftAssert softAssert;
    private String featureName;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public ApiSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @Given("^I set the (.*) with request endpoint to (.*)$")
    public void setsRequestEndpoint(final String featureName, final String endpoint) {
        this.featureName = featureName;
        List<String> pathParamsList = getPathParamsFromEndpoint(endpoint);
        apiRequestBuilder
                .endpoint(endpoint)
                .cleanParams();
        for (String pathParams : pathParamsList) {
            apiRequestBuilder.pathParams(pathParams, scenarioContext.getEnvData(pathParams));
        }
    }

    @When("^I set the request body with following values:$")
    public void setsRequestBody(final Map<String, String> body) {
        try {
            IFeature feature = featureFactory.getFeature(featureName);
            feature.setAllFields(body);
            apiRequestBuilder.body(new ObjectMapper().writeValueAsString(feature));
        } catch (Exception e) {
            JSONObject jsonBody = new JSONObject(body);
            apiRequestBuilder.body(jsonBody.toString());
        }
    }

    @When("^I execute the (.*) request$")
    public void executesRequest(final String apiMethod) throws IllegalAccessException {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        IFeature featureResponse = apiResponse.getBody(featureFactory.getFeature(this.featureName).getClass());
        scenarioContext.setBaseEnvironment(String.format("%s_id", featureName), featureResponse.getIdentifier());
    }

    @Then("I verify that the response status is {int}")
    public void verifiesResponseStatus(final int statusCode) {
        softAssert.assertEquals(apiResponse.getStatusCode(), statusCode);
    }

    @Then("^I verify the schema matches the file: (.*)$")
    public void verifiesResponseSchema(final String schemaPath) {
        apiResponse.validateBodySchema(schemaPath);
    }

    @Given("I set the query parameters as:")
    public void iSetTheQueryParametersAs(final Map<String, String> queryParams) {
        for (String queryParamKey : queryParams.keySet()) {
            apiRequestBuilder.queryParams(queryParamKey, queryParams.get(queryParamKey));
        }
    }
}
