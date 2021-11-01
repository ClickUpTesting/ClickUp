/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.utils;

import core.config.EnvConfig;

import java.util.HashMap;
import java.util.Map;

public final class PageUrl {
    private static String baseUrl = EnvConfig.getInstance().getBaseUrl();
    private static final Map<String, String> URLS = new HashMap<>();

    static {
        URLS.put("workspace form", baseUrl.concat("/onboarding"));
        URLS.put("login page", baseUrl.concat("/login"));
        URLS.put("base ClickUp", baseUrl);
    }

    private PageUrl() {
    }

    /**
     * Gets an url of page of clickUp.
     *
     * @param pageURL is a key of  URLs.
     * @return a complete url of feature.
     * @author Gustavo Huanca
     */
    public static String getUrlPage(String pageURL) {
        return URLS.get(pageURL);
    }
}
