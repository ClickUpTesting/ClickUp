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

import clickup.ApiEndpoints;
import clickup.entities.features.lists.Lisst;
import clickup.entities.features.lists.Lists;
import clickup.utils.ScenarioContext;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;

public class VerifyIdInFeaturesSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert = new SoftAssert();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private Lists lists;

    public VerifyIdInFeaturesSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @And("I verify the list exists in the folder")
    public void verifyTheIdOfListExistInFolder() {
        apiRequestBuilder
                .method(ApiMethod.GET)
                .endpoint(ApiEndpoints.LIST_IN_FOLDER.getEndpoint())
                .cleanParams()
                .pathParams("folder_id", scenarioContext.getEnvData("folder_id"))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        lists = apiResponse.getBody(Lists.class);
        boolean actual = false;
        if (lists.getLists().size() != 0) {
            for (Lisst lisst : lists.getLists()) {
                if (scenarioContext.getEnvData("list_id").equals(lisst.getId())) {
                    actual = true;
                    break;
                }
            }
        }
        softAssert.assertEquals(actual, false);
        softAssert.assertAll();
    }
}
