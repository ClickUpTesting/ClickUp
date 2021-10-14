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
import clickup.entities.features.comment.Comment;
import clickup.entities.features.comment.Comments;
import clickup.utils.ScenarioTrash;
import clickup.utils.StringToMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiHeaders;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static core.utils.StringConvert.replaceSpaceToUnderscore;
import static core.utils.RandomCustom.random;
import static org.testng.Assert.assertEquals;

public class CommentsSteps {
    private ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private ScenarioTrash scenarioTrash;
    private ApiResponse response = new ApiResponse();
    private StringToMap stringToMap = new StringToMap();

    public CommentsSteps(ApiResponse apiResponse, ScenarioTrash scenarioTrash) {
        this.apiResponse = apiResponse;
        this.scenarioTrash = scenarioTrash;
    }

    @Given("^I add the amount of (.*) to the total of comments in the \"(task|view|list)\"$")
    public void createNFeatures(String amount, String featureContainer)
            throws JsonProcessingException {
        String endpoint = ApiEndpoints.valueOf(String.format("GET_%s_COMMENTS",
                replaceSpaceToUnderscore(featureContainer).toUpperCase())).getEndpoint();
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue())
                .endpoint(endpoint)
                .pathParams(stringToMap.extractPathParams(endpoint, scenarioTrash))
                .method(ApiMethod.POST);
        Comment comment = new Comment();
        for (int i = 0; i < Integer.parseInt(amount); i++) {
            comment.setCommentText("Serial comment".concat(random()));
            apiRequestBuilder.body(new ObjectMapper().writeValueAsString(comment));
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, response);
            response.getResponse().then().log().all();
        }
    }

    @Then("I verify the amount of comments has increased by {int}")
    public void verifiesTheAmountOfFoldersHasIncreased(int addedTasks) {
        int expected = apiResponse.getBody(Comments.class).getComments().size();
        apiResponse.getResponse().then().log().all();
        assertEquals(addedTasks, expected);
    }
}
