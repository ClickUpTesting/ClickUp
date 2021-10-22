/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.api.entities.features.webhooks;

import clickup.api.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WebHooks implements IFeature {

    private String id;
    private WebHook webhook;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WebHook getWebhook() {
        return webhook;
    }

    public void setWebhook(WebHook webhook) {
        this.webhook = webhook;
    }

    /**
     * Gets identifier of feature
     *
     * @return a string with value of identifier
     * @author Gustavo Huanca
     */
    @Override
    public String getIdentifier() {
        return webhook.getId();
    }

    /**
     * Gets string with required field to create a feature in JSON format.
     *
     * @return a string in JSON format
     * @author Gustavo Huanca
     */
    @Override
    public String getRequiredField() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }

    /**
     * Creates a map with the values set on the scenario.
     *
     * @param baseMap with the fields set on the scenario
     * @return valuesMap corresponding feature
     * @author Jorge Caceres
     */
    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> baseMap) {
        WebHooks webHooks = (WebHooks) featureResponse;
        return webhook.getMatchedValues(webHooks.getWebhook(), baseMap);
    }
}
