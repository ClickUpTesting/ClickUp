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
import clickup.utils.ScenarioTrash;
import core.api.ApiRequestBuilder;
import io.cucumber.java.en.When;
import org.json.JSONObject;

public class DependencySteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ScenarioTrash scenarioTrash;

    public DependencySteps(ApiRequestBuilder apiRequestBuilder, ScenarioTrash scenarioTrash) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I set dependency on a task")
    public void addDependencyToEnvTask() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("depends_on", scenarioContext.getEnvData("task_id"));
        apiRequestBuilder.body(jsonBody.toString());

    }

    @When("I remove the dependency from a task")
    public void removeADependencyFromATask() {
        apiRequestBuilder
                .cleanQueryParams()
                .queryParams("depends_on", scenarioContext.getEnvData("task_id"))
                .queryParams("dependency_of", scenarioTrash.getTrashValue("task_id"));
    }
}
