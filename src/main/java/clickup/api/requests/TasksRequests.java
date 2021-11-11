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
     * @return a Task
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public Task createTask() throws JsonProcessingException {
        return createTask(scenarioContext.getEnvData("list_id"));
    }

    /**
     * Creates a task and returns an object Task.
     *
     * @param listId the listId where the task was created
     * @return a Task
     * @throws JsonProcessingException when the response is not a valid json
     * @author Gustavo Huanca
     */
    public Task createTask(String listId) throws JsonProcessingException {
        Task task = new Task();
        task.setName("Task created in TasksRequests From API".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(task),
                ApiEndpoints.CREATE_TASK, "list_id", listId);
        return apiResponse.getBody(Task.class);
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
