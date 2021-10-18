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
import clickup.entities.features.IGetAllFeatures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WebHooksList implements IFeature, IGetAllFeatures {
    private List<WebHook> webHooks;

    public List<WebHook> getWebHooks() {
        return webHooks;
    }

    public void setWebHooks(List<WebHook> webHooks) {
        this.webHooks = webHooks;
    }

    /**
     * Gets identifier of feature
     *
     * @return a string with value of identifier
     * @author Gustavo Huanca
     */
    @Override
    public String getIdentifier() {
        return null;
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
     * Gets the list's size.
     *
     * @return int with the size of a list
     * @author Jorge Caceres
     */
    @Override
    public int getAmount() {
        return webHooks.size();
    }
}
