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

import core.utils.PropertiesReader;
import java.util.Properties;

public final class EnvConfig {

    private static EnvConfig envConfig;
    private Properties properties;
    private String loginUrl;
    private String browser;
    private int implicitTime;
    private int explicitTime;
    private int sleepTime;
    private String language;

    private EnvConfig() {
        initialize();
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

    /**
     * Returns the language.
     *
     * @return the language
     * @author Gustavo Huanca
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Returns the loginUrl.
     *
     * @return the loginUrl
     * @author Gustavo Huanca
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * Returns the envConfig.
     *
     * @return the envConfig
     * @author Gustavo Huanca
     */
    public static EnvConfig getInstance() {
        if (envConfig == null) {
            envConfig = new EnvConfig();
        }
        return envConfig;
    }


    /**
     * Sets the configuration
     *
     * @author Gustavo Huanca
     */
    private void initialize() {
        initializeGeneralProperties();
    }

    /**
     * Initializes general properties.
     *
     * @author Gustavo Huanca
     */
    private void initializeGeneralProperties() {
        properties = PropertiesReader.getProperties("config.properties");
        loginUrl = getProperty("loginURL");
        browser = getProperty("browser");
        implicitTime = Integer.parseInt(getProperty("implicitTime"));
        explicitTime = Integer.parseInt(getProperty("explicitTime"));
        sleepTime = Integer.parseInt(getProperty("sleepTime"));
        language = getProperty("language");
    }

    /**
     * Gets a property from the Properties instance.
     *
     * @param property represents the property to retrieve
     * @return a String
     * @author Gustavo Huanca
     */
    private String getProperty(final String property) {
        return properties.getProperty(property);
    }
}
