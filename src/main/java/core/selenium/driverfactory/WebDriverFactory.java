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

public final class WebDriverFactory {
    private static final Map<String, IWebDriver> DRIVERS = new HashMap<>();
    static {
        DRIVERS.put("CHROME", new ChromeWebDriver());
        DRIVERS.put("FIREFOX", new FirefoxWebDriver());
        DRIVERS.put("EDGE", new EdgeWebDriver());
    }

    private WebDriverFactory() {
    }

    /**
     * Gets the type of driver.
     *
     * @param webDriver to define which type will be returned.
     * @return the driver type.
     * @author Jorge Caceres
     */
    public static WebDriver getDriver(final String webDriver) {
        if (DRIVERS.containsKey(webDriver)){
            return DRIVERS.get(webDriver).getWebDriver();
        }else {
            throw new InvalidArgumentException("The supported Browsers are: CHROME, FIREFOX, EDGE ");
        }
    }
}
