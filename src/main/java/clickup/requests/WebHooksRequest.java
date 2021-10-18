/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.features.webhooks.WebHooks;
import core.utils.JsonFileManager;
import core.utils.MapStringStringToStringObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebHooksRequest extends BaseRequest {
    private Map<String, String> body;

    /**
     * Creates a webhook and returns its identifier.
     *
     * @return a webhook_id
     * @throws IOException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createWebhook() throws IOException {
        body = new HashMap<>();
        body.put("endpoint", "https://clickupapitesting.com");
        body.put("events[0]", "taskCreated");
        MapStringStringToStringObject converter = new MapStringStringToStringObject();
        JsonFileManager jsonFileManager = new JsonFileManager();
        apiResponse = apiFacade.createObject(jsonFileManager.writeJson(converter.buildMapStringObject(body)),
                ApiEndpoints.CREATE_WEBHOOK, "team_id", teamId);
        return apiResponse.getBody(WebHooks.class).getId();
    }

    /**
     * Deletes a webhook.
     *
     * @param id webhook_id
     * @author Jorge Caceres
     */
    public void deleteWebhook(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_WEBHOOK, "webhook_id", id);
    }
}
