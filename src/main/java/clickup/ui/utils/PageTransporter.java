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
     * @author Gustavo Huanca
     */
    public void goToUrl(final String url) {
        webDriverManager.getWebDriver().navigate().to(url);
    }

    /**
     * Navigates to pages
     *
     * @param featureName is key of page
     * @author Gustavo Huanca
     */
    public void navigateToPage(String featureName) {
        goToUrl(getUrlPage(featureName));
    }
}
