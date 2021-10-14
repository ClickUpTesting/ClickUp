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
import clickup.utils.ScenarioTrash;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import java.util.List;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class ListsSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert = new SoftAssert();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ScenarioTrash scenarioTrash;
    private Lists lists;

    public ListsSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse,
                      ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @And("I verify the deleted list doesn't exist in the folder")
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
                if (scenarioTrash.getTrashValue("list_id").equals(lisst.getId())) {
                    actual = true;
                    break;
                }
            }
        }
        softAssert.assertEquals(actual, false);
        softAssert.assertAll();
    }

    @And("^I verify the list exists in the \"(folder|space)\"$")
    public void verifyTheIdOfListExistInContainer(String feature) {
        String endpoint = ApiEndpoints.valueOf(String.format("LIST_IN_%s", feature.toUpperCase())).getEndpoint();
        List<String> pathParamsList = getPathParamsFromEndpoint(endpoint);
        apiRequestBuilder
                .method(ApiMethod.GET)
                .endpoint(endpoint)
                .cleanParams()
                .pathParams(pathParamsList.get(0), scenarioContext.getEnvData(pathParamsList.get(0)))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        lists = apiResponse.getBody(Lists.class);
        int actual = 0;
        if (lists.getLists().size() != 0) {
            for (Lisst lisst : lists.getLists()) {
                for (String featureInList : scenarioContext.getTrashList("FeatureName Trash")) {
                    if (featureInList.equals(lisst.getId())) {
                        actual++;
                        break;
                    }
                }
            }
        }
       softAssert.assertEquals(actual, scenarioContext.getTrashList("FeatureName Trash").size());
        softAssert.assertEquals(lists.getLists().size(),
                scenarioContext.getTrashList("FeatureName Trash").size() + 1);
        softAssert.assertAll();
    }
}
