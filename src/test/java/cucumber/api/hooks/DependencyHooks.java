/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.api.hooks;

import clickup.api.requests.DependencyRequest;
import clickup.api.requests.TasksRequests;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.Before;

public class DependencyHooks {
    private DependencyRequest dependencyRequest = new DependencyRequest();
    private TasksRequests tasksRequests = new TasksRequests();
    private ScenarioTrash scenarioTrash;
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public DependencyHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
    }

    @Before(value = "@AddDependency")
    public void addDependency() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("task_id", tasksRequests.createTask().getId());
        dependencyRequest.addDependency(scenarioTrash.getTrashValue("task_id"));
    }

    @Before(value = "@LinkTask")
    public void linkTask() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("task_id", tasksRequests.createTask().getId());
        scenarioTrash.setScenarioTrash("links_to", scenarioContext.getEnvData("task_id"));
    }
    @Before(value = "@AddLinkTask")
    public void addLinkTask() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("task_id", tasksRequests.createTask().getId());
        scenarioTrash.setScenarioTrash("links_to", scenarioContext.getEnvData("task_id"));
        dependencyRequest.addLinkTask(scenarioTrash.getTrashValue("task_id"),
                scenarioTrash.getTrashValue("links_to"));
    }
}
