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

import clickup.entities.features.FeatureFactory;
import clickup.entities.features.IFeature;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import clickup.utils.StringToMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.JsonFileManager;
import core.utils.MapStringStringToStringObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.Map;

public class ApiSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private FeatureFactory featureFactory = new FeatureFactory();
    private SoftAssert softAssert;
    private String featureName;
    private ScenarioTrash scenarioTrash;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private StringToMap stringToMap = new StringToMap();

    public ApiSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert,
                    ScenarioTrash scenarioTrash) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
    }

    @Given("^I set the (.*) with request endpoint to (.*)$")
    public void setsRequestEndpoint(final String featureName, final String endpoint) {
        this.featureName = featureName;
        apiRequestBuilder
                .endpoint(endpoint)
                .cleanParams()
                .pathParams(stringToMap.extractPathParams(endpoint, scenarioTrash));

    }

    @When("^I execute a (.*) request$")
    public void executesSimpleRequest(final String method) {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(method)).build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().all();
    }

    @When("^I set the request body with following values:$")
    public void setsRequestBody(final Map<String, String> body) throws IOException {
        try {
            IFeature feature = featureFactory.getFeature(featureName);
            feature.setAllFields(body);
            if (body != null && "{}".equals(new ObjectMapper().writeValueAsString(feature))) {
                throw new NullPointerException();
            }
            apiRequestBuilder.body(new ObjectMapper().writeValueAsString(feature));
        } catch (Exception e) {
            MapStringStringToStringObject converter = new MapStringStringToStringObject();
            JsonFileManager jsonFileManager = new JsonFileManager();
            apiRequestBuilder.body(jsonFileManager.writeJson(converter.buildMapStringObject(body)));
        }
    }

    @When("^I execute the (.*) request$")
    public void executesRequest(final String apiMethod) throws IllegalAccessException {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        IFeature featureResponse = apiResponse.getBody(featureFactory.getFeature(this.featureName).getClass());
        scenarioTrash.setScenarioTrash(String.format("%s_id", featureName), featureResponse.getIdentifier());
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
    public void setsTheQueryParameters(final Map<String, String> queryParams) {
        for (String queryParamKey : queryParams.keySet()) {
            apiRequestBuilder.queryParams(queryParamKey, queryParams.get(queryParamKey));
        }
    }
}
