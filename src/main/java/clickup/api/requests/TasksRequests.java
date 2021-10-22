/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.api.requests;

import clickup.api.ApiEndpoints;
import clickup.api.entities.features.tasks.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static core.utils.RandomCustom.random;

public class TasksRequests extends BaseRequest {

    /**
     * Creates a task and returns its identifier.
     *
     * @return a task_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createTask() throws JsonProcessingException {
        Task task = new Task();
        task.setName("Task created in TasksRequests From API".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(task),
                ApiEndpoints.CREATE_TASK, "list_id", scenarioContext.getEnvData("list_id"));
        return apiResponse.getBody(Task.class).getId();
    }

    /**
     * Deletes a task.
     *
     * @param id the task id to be deleted
     * @author Jorge Caceres
     */
    public void deleteTask(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_TASK, "task_id", id);
    }

    /**
     * Gets a task.
     *
     * @param taskId the task id to be deleted
     * @return TaskResponse
     * @author Jorge Caceres
     */
    public Task getTask(final String taskId) {
        apiResponse = apiFacade.getObject(ApiEndpoints.GET_TASK, "task_id", taskId);
        return apiResponse.getBody(Task.class);
    }
}
