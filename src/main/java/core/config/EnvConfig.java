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
    private String language;

    private EnvConfig() {
        initializeGeneralProperties();
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
     * Initializes general properties.
     *
     * @author Gustavo Huanca
     */
    private void initializeGeneralProperties() {
        properties = PropertiesReader.getProperties("config/environment/env_config.properties");
        loginUrl = properties.getProperty("loginURL");
        language = properties.getProperty("language");
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
}
