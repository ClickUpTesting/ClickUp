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

import clickup.entities.features.views.Views;
import clickup.utils.ScenarioTrash;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.util.Map;

public class ViewsSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiResponse apiResponse;
    private ApiRequest apiRequest;
    private ScenarioTrash scenarioTrash;

    public ViewsSteps(ApiRequestBuilder apiRequestBuilder, ScenarioTrash scenarioTrash, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.scenarioTrash = scenarioTrash;
        this.apiResponse = apiResponse;
    }

    @When("I set the view body with following values:")
    public void setsTheViewBody(final Map<String, String> body) {
        JSONObject viewBody = new JSONObject();
        for (String viewComponent: body.keySet()) {
            viewBody.put(viewComponent, body.get(viewComponent));
        }
        apiRequestBuilder.body(viewBody.toString());
    }

    @And("^I execute the (.*) request for views$")
    public void executesThePOSTRequestForViews(final String method) {
        apiRequest = apiRequestBuilder.method(ApiMethod.valueOf(method)).build();
        ApiManager.execute(apiRequest, apiResponse);
        scenarioTrash.setScenarioTrash(String.format("%s_id", "view"),
                apiResponse.getBody(Views.class).getIdentifier());
    }
}
