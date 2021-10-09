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

import clickup.ApiEndpoints;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import core.api.ApiRequestBuilder;
import io.cucumber.java.en.Given;

public class SetComposedEndpointStep {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ScenarioTrash scenarioTrash;

    public SetComposedEndpointStep(ApiRequestBuilder apiRequestBuilder, ScenarioTrash scenarioTrash) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.scenarioTrash = scenarioTrash;
    }

    @Given("^I set the (.*) composed endpoint (.*)$")
    public void setComposedEndpoint(final String featureName, final String endpoint) {
        apiRequestBuilder
                .cleanParams()
                .clearBody()
                .endpoint(endpoint)
                .pathParams("task_id", scenarioContext.getEnvData("task_id"))
                .pathParams("tag_name",scenarioTrash.getTrashValue("tag_name"));
    }
}
