/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package clickup.ui.utils;

import core.config.EnvConfig;

import java.util.HashMap;
import java.util.Map;

public class PageUrl {
    private static String baseUrl = EnvConfig.getInstance().getBaseUrl();
    private static final Map<String, String> URLS = new HashMap<>();
    static {
        URLS.put("my teams", String.format("/%s/settings/teams"));
        URLS.put("team form", "/onboarding");
        URLS.put("login page", "/login");
    }

    /**
     * Gets an url of page of clickUp.
     *
     * @param pageURL is a key of  URLs.
     * @return a complete url of feature.
     */
    public static String getUrlPage(String pageURL) {
        return baseUrl.concat(URLS.get(pageURL));
    }
}
