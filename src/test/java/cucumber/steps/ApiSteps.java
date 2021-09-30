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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static clickup.FoldersRequests.getFolder;

public class ApiSteps {
    ApiRequestBuilder apiRequestBuilder;
    ApiRequest apiRequest = new ApiRequest();
    ApiResponse apiResponse;
    FeatureFactory featureFactory = new FeatureFactory();
    SoftAssert softAssert;
    String featureName;

    public ApiSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @Given("^I set the request endpoint to (.*)$")
    public void setsRequestEndpoint(final String endpoint) {
        apiRequestBuilder
                .endpoint(endpoint)
                .pathParams("space_id", "12971248");
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
    public void executesRequest(final String apiMethod) {
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
        Features actual = apiResponse.getBody(featureFactory.getFeature(this.featureName).getClass());
        actual.setDefaultValues();
        Features expected = getFolder(actual.getIdentifier())
                .getBody(featureFactory.getFeature(this.featureName).getClass());
        System.out.println(actual);
        System.out.println(expected);
//        softAssert.assertTrue(actual.equals(expected));
        softAssert.assertEquals(actual, expected);
    }
}
