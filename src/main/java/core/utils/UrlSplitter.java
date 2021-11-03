/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package core.utils;

import org.openqa.selenium.WebDriver;

public final class UrlSplitter {
    private UrlSplitter() {
    }

    /**
     * Gets the last ID number on a URL
     *
     * @param webDriver to get the url
     * @return a String with an ID
     * @author Jogre Caceres
     */
    public static String getLastUrlID(final WebDriver webDriver) {
        String[] urlElements = webDriver.getCurrentUrl().split("/");
        return urlElements[urlElements.length - 1];
    }
}
