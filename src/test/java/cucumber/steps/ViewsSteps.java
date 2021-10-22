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

import clickup.api.ApiEndpoints;
import clickup.api.entities.features.IGetAllFeatures;
import clickup.api.entities.features.views.TaskViews;
import clickup.api.entities.features.views.Views;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
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
import java.util.Map;

import static core.utils.PascalCaseConverter.convertToPascalCase;

public class ViewsSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
    private ApiResponse apiResponse;
    private ApiRequest apiRequest;
    private ScenarioTrash scenarioTrash;
    private int actual;
    private ApiResponse response = new ApiResponse();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private SoftAssert softAssert;

    public ViewsSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert,
                      ScenarioTrash scenarioTrash) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I set the view body with following values:")
    public void setsTheViewBody(final Map<String, String> body) {
        JSONObject viewBody = new JSONObject();
        for (String viewComponent: body.keySet()) {
            viewBody.put(viewComponent, body.get(viewComponent));
        }
        apiRequestBuilder.body(viewBody.toString());
    }

    @When("^I execute the (.*) request for views$")
    public void executesTheRequestForViews(final String method) {
        apiRequest = apiRequestBuilder.method(ApiMethod.valueOf(method)).build();
        ApiManager.execute(apiRequest, apiResponse);
        if (method.equals("POST")) {
            scenarioTrash.setScenarioTrash(String.format("%s_id", "view"),
                    apiResponse.getBody(Views.class).getIdentifier());
        }
    }

    @Given("^I get the initial amount of (.*) views$")
    public void getsTheInitialAmountOfTeamViews(final String viewType) {
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        requestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.valueOf("GET_" + convertToPascalCase(viewType) + "_VIEWS").getEndpoint())
                .cleanParams()
                .pathParams(String.format("%s_id", viewType),
                        scenarioContext.getEnvData(String.format("%s_id", viewType)))
                .method(ApiMethod.GET);
        apiRequest = requestBuilder.build();
        ApiManager.execute(apiRequest, response);
        IGetAllFeatures features = response.getBody(Views.class);
        actual = features.getAmount();
    }

    @When("^I add the amount of (.*) to the total of (.*) views$")
    public void addsAnAmountToTheTotalOfTeamViews(final int amount, final String viewType) {
        LinkedList<String> viewsTrashList = new LinkedList<>();
        requestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(ApiEndpoints.valueOf("CREATE_" + convertToPascalCase(viewType) + "_VIEW").getEndpoint())
                .pathParams(String.format("%s_id", viewType),
                        scenarioContext.getEnvData(String.format("%s_id", viewType)))
                .method(ApiMethod.POST);
        String viewName = "View For Testing Number ";
        JSONObject viewBody = new JSONObject();
        for (int i = 0; i < amount; i++) {
            viewBody.put("name", viewName + i);
            requestBuilder.body(viewBody.toString());
            apiRequest = requestBuilder.build();
            ApiManager.execute(apiRequest, response);
            response.getResponse().then().log().body();
            Views view = response.getBody(Views.class);
            viewsTrashList.addLast(view.getIdentifier());
        }
        scenarioContext.setTrash("Views", viewsTrashList);
    }

    @Then("^I verify the amount of views has increased by (.*)$")
    public void verifiesTheAmountOfTeamViewsHasIncreased(final int addedViews) {
        IGetAllFeatures featureResponse = apiResponse.getBody(Views.class);
        int expected = featureResponse.getAmount();
        softAssert.assertEquals(actual + addedViews, expected);
    }

    @Then("I verify the amount of tasks in the view is {int}")
    public void verifiesTheAmountOfTasksInTheView(final int addedTasks) {
        IGetAllFeatures featureResponse = apiResponse.getBody(TaskViews.class);
        int expected = featureResponse.getAmount();
        softAssert.assertEquals(addedTasks, expected);
    }
}
