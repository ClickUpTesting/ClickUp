package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.features.Tasks.TasksResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

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
        TasksResponse tasksResponse = new TasksResponse();
        tasksResponse.setName("Task created in TasksHooks From API".concat(random()));
        apiResponse = apiFacade.createObject(tasksResponse, ApiEndpoints.CREATE_TASK, "list_id",
                scenarioContext.getEnvData("list_id"));
        return apiResponse.getBody(TasksResponse.class).getId();
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
}
