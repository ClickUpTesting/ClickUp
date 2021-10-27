/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.config;

import core.utils.JsonFileManager;
import java.io.IOException;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import org.openqa.selenium.InvalidArgumentException;

public final class DriverConfig {
    private static DriverConfig driverConfig;
    private String browser;
    private int implicitTime;
    private int explicitTime;
    private int sleepTime;
    private JsonFileManager jsonFileManager;

    private DriverConfig() {
        jsonFileManager = new JsonFileManager();
        initializeGeneralProperties();
    }

    /**
     * Returns the envConfig.
     *
     * @return the envConfig
     * @author Gustavo Huanca
     */
    public static DriverConfig getInstance() {
        if (driverConfig == null) {
            driverConfig = new DriverConfig();
        }
        return driverConfig;
    }

    /**
     * Initializes general properties.
     *
     * @author Gustavo Huanca
     */
    private void initializeGeneralProperties() {
        browser = System.getenv("BROWSER_UI");
        try {
            JsonObject browserBody = jsonFileManager
                    .readFileJsonToJsonObject("config/driver/driver_configuration.json")
                    .getAsJsonObject(browser);
            implicitTime = browserBody.get("implicitTime").getAsInt();
            explicitTime = browserBody.get("explicitTime").getAsInt();
            sleepTime = browserBody.get("sleepTime").getAsInt();
        } catch (IOException e) {
            throw new InvalidArgumentException("Invalid path or error occurs opening the file. "
                    + "Verify the config/driver/driver_configuration.json is correct");
        }
    }

    /**
     * Gets the browser to run the tests on.
     *
     * @return a String
     * @author Gustavo Huanca
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Gets the implicit time.
     *
     * @return int represents the driver implicit time
     * @author Gustavo Huanca
     */
    public int getImplicitTime() {
        return implicitTime;
    }

    /**
     * Gets the explicit time.
     *
     * @return int represents the driver explicit time
     * @author Gustavo Huanca
     */
    public int getExplicitTime() {
        return explicitTime;
    }

    /**
     * Gets the sleep time.
     *
     * @return int represents the driver sleep time
     * @author Gustavo Huanca
     */
    public int getSleepTime() {
        return sleepTime;
    }
}
