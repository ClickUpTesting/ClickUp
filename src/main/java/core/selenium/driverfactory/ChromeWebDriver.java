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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements IWebDriver {

    private ChromeOptions chromeOptions;

    /**
     * Configures Chrome browser's options.
     *
     * @author Jorge Caceres
     */
    public void setChromeOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox");
    }

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     * @author Jorge Caceres
     */
    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        setChromeOptions();
        return new ChromeDriver(chromeOptions);
    }
}
