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

import clickup.entities.FeatureFactory;
import clickup.entities.Features;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class ApiSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private FeatureFactory featureFactory = new FeatureFactory();
    private SoftAssert softAssert = new SoftAssert();
    private String featureName;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public ApiSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Given("^I set the request endpoint to (.*)$")
    public void setsRequestEndpoint(final String endpoint) {
        List<String> pathParamsList = getPathParamsFromEndpoint(endpoint);
        apiRequestBuilder
                .endpoint(endpoint);
        for (String pathParams:pathParamsList) {
            apiRequestBuilder
                    .pathParams(pathParams, scenarioContext.getEnvData(pathParams));
        }
    }

    @When("^I set the request body as (.*) with following values:$")
    public void setsRequestBody(final String featureName, final Map<String, String> body)
            throws Exception {
        Features feature = featureFactory.getFeature(featureName);
        feature.setAllFields(body);
        apiRequestBuilder.body(new ObjectMapper().writeValueAsString(feature));
        this.featureName = featureName;
    }

    @When("^I execute the (.*) request$")
    public void executesRequest(final String apiMethod) throws IllegalAccessException {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        Features featureResponse = apiResponse.getBody(featureFactory.getFeature(this.featureName).getClass());
    }

    @Then("I verify that the response status is {int}")
    public void verifiesResponseStatus(final int statusCode) {
        softAssert.assertEquals(apiResponse.getStatusCode(), statusCode);
    }

    @Then("^I verify the schema matches the file: (.*)$")
    public void verifiesResponseSchema(final String schemaPath) {
        apiResponse.validateBodySchema(schemaPath);
    }

    @Then("I verify the values set on the feature")
    public void verifiesValuesOnFeature() {
        softAssert.assertAll();
    }
}
