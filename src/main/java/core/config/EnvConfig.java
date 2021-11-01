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

import static core.utils.EncryptManager.decryptText;

public final class EnvConfig {
    private static EnvConfig envConfig;
    private Properties properties;
    private String baseUrl;
    private String language;
    private String adminUser;
    private String adminPass;
    private String guestUser;
    private String guestPass;


    private EnvConfig() {
        initializeGeneralProperties();
        initializeAdminProperties();
        initializeGuestProperties();
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
        baseUrl = properties.getProperty("baseURL");
        language = properties.getProperty("language");
    }

    /**
     * Initializes admin credentials.
     *
     * @author Jorge Caceres
     */
    private void initializeAdminProperties() {
        adminUser = System.getenv("CLICK_UP_USER");
        adminPass = decryptText(System.getenv("CLICK_UP_PASS"));
    }

    /**
     * Initializes guest credentials.
     *
     * @author Jorge Caceres
     */
    private void initializeGuestProperties() {
        properties = PropertiesReader.getProperties("config/users/guest.properties");
        guestUser = properties.getProperty("guestUser");
        guestPass = decryptText(properties.getProperty("guestPassword"));
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
     * Returns the baseURL.
     *
     * @return the loginUrl
     * @author Gustavo Huanca
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Gets the admin user.
     *
     * @return the admin user
     * @author Jorge Caceres
     */
    public String getAdminUser() {
        return adminUser;
    }

    /**
     * Gets the admin pass.
     *
     * @return the admin pass
     * @author Jorge Caceres
     */
    public String getAdminPass() {
        return adminPass;
    }

    /**
     * Gets the guest user.
     *
     * @return the guest user
     * @author Jorge Caceres
     */
    public String getGuestUser() {
        return guestUser;
    }

    /**
     * Gets the guest pass.
     *
     * @return the guest pass
     * @author Jorge Caceres
     */
    public String getGuestPass() {
        return guestPass;
    }
}
