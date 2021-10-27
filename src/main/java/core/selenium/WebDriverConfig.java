/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.selenium;

import core.config.DriverConfig;

public class WebDriverConfig {
    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private static WebDriverConfig instance;

    public WebDriverConfig() {
        initialize();
    }

    /**
     * Returns a new instance.
     *
     * @return a web driver config object
     * @author Gustavo Huanca
     */
    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    /**
     * Sets all the values to be configured.
     *
     * @author Gustavo Huanca
     */
    public void initialize() {
        browser = DriverConfig.getInstance().getBrowser();
        implicitWaitTime = DriverConfig.getInstance().getImplicitTime();
        explicitWaitTime = DriverConfig.getInstance().getExplicitTime();
        waitSleepTime = DriverConfig.getInstance().getSleepTime();
    }

    /**
     * Returns the type of browser.
     *
     * @return the browser
     * @author Gustavo Huanca
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Returns the implicitWaitTime.
     *
     * @return the implicitWaitTime
     * @author Gustavo Huanca
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Returns the explicitWaitTime.
     *
     * @return the explicitWaitTime
     * @author Gustavo Huanca
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Returns the waitSleepTime.
     *
     * @return the waitSleepTime
     * @author Gustavo Huanca
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
