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
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class VerifyAmount {
    ApiRequestBuilder apiRequestBuilder;
    ApiRequest apiRequest;
    ApiResponse apiResponse;
    SoftAssert softAssert = new SoftAssert();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public VerifyAmount(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Then("I verify the amount of has increased by {int}")
    public void verifyAmountOfTags(int arg0) {
        int actual = scenarioContext.getFeatures("Initial status").getAmount() + arg0;
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        GetAllFeatures featureResponse = apiResponse.getBody(Tags.class);
        int expected = featureResponse.getAmount();
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }
}
