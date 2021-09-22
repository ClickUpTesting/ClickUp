/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa
 */

package com.clickup.api.utils;

import core.api.ApiRequestBuilder;
import core.utils.PropertiesReader;

import java.util.Properties;

public final class BaseRequest {

    private BaseRequest() {
    }

    /**
     * Sets a baseRequest for Clickup
     *
     * @return a ApiRequestBuilder instance
     */
    public static ApiRequestBuilder baseRequest() {
        Properties properties = PropertiesReader.getProperties("configuration.properties");
        return new ApiRequestBuilder()
                .baseUri(properties.getProperty("baseUrl"))
                .headers("Authorization", properties.getProperty("token"))
                .headers("Content-Type", "application/json");
    }
}
