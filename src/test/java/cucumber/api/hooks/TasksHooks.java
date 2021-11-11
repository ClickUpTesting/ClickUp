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

import clickup.api.entities.features.lists.Lisst;
import clickup.api.entities.features.tasks.Task;
import clickup.api.requests.ListsRequest;
import clickup.api.requests.TasksRequests;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TasksHooks {
    private ListsRequest listsRequest;
    private TasksRequests tasksRequests;
    private ScenarioTrash scenarioTrash;

    public TasksHooks(ScenarioTrash scenarioTrash) {
        this.tasksRequests = new TasksRequests();
        this.scenarioTrash = scenarioTrash;
        this.listsRequest = new ListsRequest();
    }

    @Before(value = "@CreateTask")
    public void createTask() throws JsonProcessingException {
        Task task = tasksRequests.createTask();
        scenarioTrash.setScenarioTrash("task_id", task.getId());
        scenarioTrash.setScenarioTrash("task_name", task.getName());
    }

    @Before(value = "@CreateTaskInList")
    public void createTaskInList() throws JsonProcessingException {
        Lisst lisst = listsRequest.createListInSpace();
        scenarioTrash.setScenarioTrash("list_id", lisst.getId());
        scenarioTrash.setScenarioTrash("list_name", lisst.getName());
        Task task = tasksRequests.createTask(lisst.getId());
        scenarioTrash.setScenarioTrash("task_id", task.getId());
        scenarioTrash.setScenarioTrash("task_name", task.getName());
    }

    @After(value = "@DeleteTask")
    public void deleteTask() {
        tasksRequests.deleteTask(scenarioTrash.getTrashValue("task_id"));
    }
}
