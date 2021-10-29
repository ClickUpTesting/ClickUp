/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package clickup.ui.utils;

import core.selenium.WebDriverManager;

import static clickup.ui.utils.PageUrl.getUrlPage;

public class PageTransporter {
    private WebDriverManager webDriverManager;

    public PageTransporter(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    /**
     * Goes directly to a page by an url.
     *
     * @param url to go.
     */
    public void goToUrl(final String url) {
        webDriverManager.getWebDriver().navigate().to(url);
    }


    public void navigateToPage(String featureName) {
        goToUrl(getUrlPage(featureName));
    }
}
