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

import core.selenium.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebDriverManager {
    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private WebDriver webDriver;
    private WebDriverWait wait;

    /**
     * Initializes the web driver configuration configuration.
     *
     * @author Gustavo Huanca
     */
    public WebDriverManager() {
        initialize();
    }

    /**
     * Returns a webDriver instance.
     *
     * @return a webDriver
     * @author Gustavo Huanca
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Returns a webDriver wait.
     *
     * @return a web driver wait
     * @author Gustavo Huanca
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Quit the web driver.
     *
     * @author Gustavo Huanca
     */
    public void quitWebDriver() {
        webDriver.quit();
    }

    /**
     * Closes the web driver.
     *
     * @author Gustavo Huanca
     */
    public void closeWebDriver() {
        webDriver.close();
    }

    /**
     * Sets size of windows is equals to screen.
     *
     * @author Gustavo Huanca
     */
    public void maximizeScreen() {
        webDriver.manage().window().maximize();
    }

    /**
     * Deletes all cookies.
     *
     * @author Gustavo Huanca
     */
    public void deleteAllCookies() {
        webDriver.manage().deleteAllCookies();
    }

    /**
     * Initializes the webDriverManager configuration.
     *
     * @author Gustavo Huanca
     */
    private void initialize() {
        this.webDriver = DriverFactory.getDriver(webDriverConfig.getBrowser());
        maximizeScreen();
        deleteAllCookies();
        setDriverWaits(webDriverConfig.getImplicitWaitTime(), webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }

    /**
     * Sets the web driver waits to the minimum to handle datatable elements.
     *
     * @author Gustavo Huanca
     */
    public void setTableWaitMode() {
        setDriverWaits(0, 0, 0);
    }

    /**
     * Sets the web driver waits to the property values.
     *
     * @author Gustavo Huanca
     */
    public void setDefaultWaitMode() {
        setDriverWaits(webDriverConfig.getImplicitWaitTime(), webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }

    /**
     * Set a new WebDriverWait with a specific time.
     *
     * @param implicitWaitTime is implicit wait time in seconds
     * @param explicitWaitTime is explicit wait time in seconds
     * @param sleepTime        is sleep time in milliseconds
     * @author Gustavo Huanca
     */
    private void setDriverWaits(final int implicitWaitTime, final int explicitWaitTime, final int sleepTime) {
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(explicitWaitTime), Duration.ofMillis(sleepTime));
    }
}
