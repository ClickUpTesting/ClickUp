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

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    /**
     * Gets the type of driver.
     *
     * @param type to define which type will be returned.
     * @return the driver type.
     * @author Jorge Caceres
     */
    public static WebDriver getDriver(final String type) {
        switch (type) {
            case "CHROME":
                return new ChromeBrowser().getWebDriver();
            case "EDGE":
                return new EdgeBrowser().getWebDriver();
            case "FIREFOX":
                return new FirefoxBrowser().getWebDriver();
            default:
                throw new InvalidArgumentException("Unsupported WebDriver");
        }
    }
}
