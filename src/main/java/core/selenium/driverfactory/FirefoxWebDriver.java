/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package core.selenium.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxWebDriver implements IWebDriver {

    FirefoxOptions firefoxOptions;

    /**
     * Configures Chrome browser's options.
     *
     * @author Jorge Caceres
     */
    public void setFirefoxOptions() {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");
    }

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     * @author Jorge Caceres
     */
    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        setFirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }
}
