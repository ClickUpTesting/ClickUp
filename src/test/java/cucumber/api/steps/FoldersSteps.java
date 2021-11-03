/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package cucumber.api.steps;

import clickup.api.ApiEndpoints;
import clickup.api.entities.features.IGetAllFeatures;
import clickup.api.entities.features.folders.Folder;
import clickup.api.entities.features.folders.Folders;
import clickup.utils.ScenarioContext;
import core.api.ApiHeaders;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import java.util.LinkedList;

public class FoldersSteps {
    private ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse response = new ApiResponse();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private SoftAssert softAssert;
    private ApiResponse apiResponse;
    private int actual;

    public FoldersSteps(ApiResponse apiResponse, SoftAssert softAssert) {
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @When("I add the amount of {int} to the total of folders")
    public void addsTheAmountOfFoldersToTheTotal(final int amount) {
        LinkedList<String> foldersTrashList = new LinkedList<>();
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.CREATE_FOLDER_IN_SPACE.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST);
        String folderName = "Folder For Testing Number ";
        JSONObject folderBody = new JSONObject();
        for (int i = 0; i < amount; i++) {
            folderBody.put("name", folderName + i);
            apiRequestBuilder.body(folderBody.toString());
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, response);
            response.getResponse().then().log().body();
            Folder folder = response.getBody(Folder.class);
            foldersTrashList.addLast(folder.getId());
        }
        scenarioContext.setTrash("Folders", foldersTrashList);
    }

    @Then("I verify the amount of folders has increased by {int}")
    public void verifiesTheAmountOfFoldersHasIncreased(int addedFolders) {
        IGetAllFeatures featureResponse = apiResponse.getBody(Folders.class);
        int expected = featureResponse.getAmount();
        softAssert.assertEquals(actual + addedFolders, expected);
    }

    @Given("^I get the initial amount of (.*) folders$")
    public void getsTheInitialAmountOfFolders(final String archived) {
        boolean archivedStatus = "archived".equals(archived);
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        requestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.GET_FOLDERS.getEndpoint())
                .cleanParams()
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .queryParams("archived", Boolean.toString(archivedStatus))
                .method(ApiMethod.GET);
        apiRequest = requestBuilder.build();
        ApiManager.execute(apiRequest, response);
        IGetAllFeatures features = response.getBody(Folders.class);
        actual = features.getAmount();
    }
}
