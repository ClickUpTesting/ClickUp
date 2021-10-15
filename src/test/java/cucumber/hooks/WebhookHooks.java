/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.hooks;

import clickup.requests.WebHooksRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebhookHooks {
    private WebHooksRequest webHooksRequest;
    private ScenarioTrash scenarioTrash;

    public WebhookHooks(WebHooksRequest webHooksRequest, ScenarioTrash scenarioTrash) {
        this.webHooksRequest = webHooksRequest;
        this.scenarioTrash = scenarioTrash;
    }

    @Before(value = "@CreateWebhook")
    public void createWebhook() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("webhook_id", webHooksRequest.createWebhook());
    }

    @After(value = "@DeleteWebhook")
    public void deleteWebhook() {
        webHooksRequest.deleteWebhook(scenarioTrash.getTrashValue("webhook_id"));
    }
}
