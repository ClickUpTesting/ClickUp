/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.webhooks;

import clickup.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WebHooks implements IFeature {

    private String id;
    private WebHook webHook;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WebHook getWebHook() {
        return webHook;
    }

    public void setWebHook(WebHook webHook) {
        this.webHook = webHook;
    }

    /**
     * Gets identifier of feature
     *
     * @return a string with value of identifier
     * @author Gustavo Huanca
     */
    @Override
    public String getIdentifier() {
        return webHook.getId();
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

    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }
}
