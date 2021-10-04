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
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import java.util.LinkedList;
import java.util.Map;

public class SetTagBodyStep {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public SetTagBodyStep(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @When("I set the tags body with following values:")
    public void setTagBody(final Map<String, String> body) {
        LinkedList<String> trashList =  new LinkedList<>();
        if (body.get("name") != null) {
            trashList.addLast(body.get("name"));
            scenarioContext.setTrash("Tags", trashList);
        }
        JSONObject jsonBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        for (String tagComponent: body.keySet()) {
            tagBody.put(tagComponent, body.get(tagComponent));
        }
        jsonBody.put("tag", tagBody);
        apiRequestBuilder.body(jsonBody.toString());
    }
}
