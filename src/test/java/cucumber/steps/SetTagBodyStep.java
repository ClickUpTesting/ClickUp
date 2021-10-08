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


import clickup.utils.ScenarioTrash;
import core.api.ApiRequestBuilder;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import java.util.Map;

public class SetTagBodyStep {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioTrash scenarioTrash;

    public SetTagBodyStep(ApiRequestBuilder apiRequestBuilder, ScenarioTrash scenarioTrash) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I set the tags body with following values:")
    public void setTagBody(final Map<String, String> body) {
        if (body.get("name") != null) {
            scenarioTrash.setScenarioTrash("tag_name", body.get("name"));
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
