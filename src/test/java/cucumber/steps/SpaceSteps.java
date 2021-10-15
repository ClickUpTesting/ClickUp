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
import clickup.entities.features.IGetAllFeatures;
import clickup.entities.features.folders.Folders;
import clickup.entities.features.spaces.Space;
import clickup.entities.features.spaces.Spaces;
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

public class SpaceSteps {
    private ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse response = new ApiResponse();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private SoftAssert softAssert;
    private ApiResponse apiResponse;
    private int actual;

    public SpaceSteps(SoftAssert softAssert, ApiResponse apiResponse) {
        this.softAssert = softAssert;
        this.apiResponse = apiResponse;
    }

    @Given("^I get the initial amount of (.*) spaces$")
    public void getsTheInitialAmountOfNotArchivedSpaces(final String archived) {
        boolean archivedStatus = "archived".equals(archived);
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        requestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.GET_SPACES.getEndpoint())
                .cleanParams()
                .pathParams("team_id", scenarioContext.getEnvData("team_id"))
                .queryParams("archived", Boolean.toString(archivedStatus))
                .method(ApiMethod.GET);
        apiRequest = requestBuilder.build();
        ApiManager.execute(apiRequest, response);
        IGetAllFeatures features = response.getBody(Folders.class);
        actual = features.getAmount();
    }

    @When("I add the amount of {int} to the total of spaces")
    public void addsAnAmountOfSpaces(final int amount) {
        LinkedList<String> spacesTrashList = new LinkedList<>();
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.CREATE_FOLDER_IN_SPACE.getEndpoint())
                .pathParams("team_id", scenarioContext.getEnvData("team_id"))
                .method(ApiMethod.POST);
        String spaceName = "Space For Testing Number ";
        JSONObject folderBody = new JSONObject();
        for (int i = 0; i < amount; i++) {
            folderBody.put("name", spaceName + i);
            apiRequestBuilder.body(folderBody.toString());
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, response);
            response.getResponse().then().log().body();
            Space space = response.getBody(Space.class);
            spacesTrashList.addLast(space.getId());
        }
        scenarioContext.setTrash("Spaces", spacesTrashList);
    }

    @Then("I verify the amount of spaces has increased by {int}")
    public void verifiesTheAmountOfSpacesHasIncreased(final int addedSpaces) {
        IGetAllFeatures featureResponse = apiResponse.getBody(Spaces.class);
        int expected = featureResponse.getAmount();
        softAssert.assertEquals(actual + addedSpaces, expected);
    }
}
