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
import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {
    private static final Map<String, Browser> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("CHROME", new ChromeBrowser());
        BROWSERS.put("FIREFOX", new FirefoxBrowser());
        BROWSERS.put("EDGE", new EdgeBrowser());
    }

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
        try {
            return BROWSERS.get(type).getWebDriver();
        } catch (InvalidArgumentException e) {
            throw new InvalidArgumentException("Unsupported Browser");
        }
    }
}
