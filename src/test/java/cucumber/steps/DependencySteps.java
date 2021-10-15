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
import core.api.ApiRequestBuilder;
import io.cucumber.java.en.When;
import org.json.JSONObject;

public class DependencySteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public DependencySteps(ApiRequestBuilder apiRequestBuilder) {
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @When("I set dependency on a task")
    public void addDependencyToEnvTask() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("depends_on", scenarioContext.getEnvData("task_id"));
        apiRequestBuilder.body(jsonBody.toString());

    }
}
