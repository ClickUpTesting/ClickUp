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
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class DependencyRequest extends BaseRequest {

    /**
     * Add a dependency to a task.
     *
     * @param id to be set on the tag
     * @author Jorge Caceres
     */
    public void addDependency(final String id) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("depends_on", scenarioContext.getEnvData("task_id"));
        apiFacade.createObject(jsonBody.toString(), ApiEndpoints.ADD_DEPENDENCY, "task_id", id);
    }

    /**
     * Add a link to a task.
     *
     * @param taskId that will be linked
     * @param linkTask to link
     * @author Jorge Caceres
     */
    public void addLinkTask(final String taskId, final String linkTask) {
        Map<String, String> mapPathParams = new HashMap<>();
        mapPathParams.put("task_id", taskId);
        mapPathParams.put("links_to", linkTask);
        apiFacade.createObject("", ApiEndpoints.LINK_TASK, mapPathParams);
    }
}
