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

import clickup.api.requests.TasksRequests;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TasksHooks {

    private TasksRequests tasksRequests;
    private ScenarioTrash scenarioTrash;

    public TasksHooks(ScenarioTrash scenarioTrash) {
        this.tasksRequests = new TasksRequests();
        this.scenarioTrash = scenarioTrash;
    }

    @Before(value = "@CreateTask")
    public void createTask() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("task_id", tasksRequests.createTask());
    }

    @After(value = "@DeleteTask")
    public void deleteTask() {
        tasksRequests.deleteTask(scenarioTrash.getTrashValue("task_id"));
    }
}
