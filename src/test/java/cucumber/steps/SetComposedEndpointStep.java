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

import clickup.utils.ScenarioContext;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.Given;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class SetComposedEndpointStep {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public SetComposedEndpointStep(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse,
                                   SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @Given("^I set the (.*) composed endpoint (.*)$")
    public void setComposedEndpoint(final String featureName, final String endpoint) {
        List<String> pathParamsList = getPathParamsFromEndpoint(endpoint);
        apiRequestBuilder
                .endpoint(endpoint)
                .cleanParams();
        apiRequestBuilder.pathParams(pathParamsList.get(0), scenarioContext.getEnvData(pathParamsList.get(0)))
                .pathParams(pathParamsList.get(1), scenarioContext.getTrashList(featureName).getLast());
    }
}
