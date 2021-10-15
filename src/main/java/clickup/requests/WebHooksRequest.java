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
import clickup.entities.features.webhooks.WebHook;
import clickup.entities.features.webhooks.WebHooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;

public class WebHooksRequest extends BaseRequest {
    private List<String> events;

    /**
     * Creates a webhook and returns its identifier.
     *
     * @return a webhook_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createWebhook() throws JsonProcessingException {
        WebHook webHook = new WebHook();
        events = new ArrayList<>();
        events.add("taskCreated");
        webHook.setEndpoint("https://clickupapitest.com");
        webHook.setEvents(events);
        apiResponse = apiFacade.createObject(events, ApiEndpoints.CREATE_WEBHOOK, "team_id", teamId);
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
