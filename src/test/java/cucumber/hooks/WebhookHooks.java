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
    public void createSpace() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("webhook_id", webHooksRequest.createWebhook());
    }

    @After(value = "@DeleteWebhook")
    public void deleteSpace() {
        webHooksRequest.deleteWebhook(scenarioTrash.getTrashValue("webhook_id"));
    }
}
