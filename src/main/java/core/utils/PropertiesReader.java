/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesReader {

    private PropertiesReader() {

    }

    /**
     * Load and returns a properties file.
     *
     * @param path of the properties file.
     * @return a properties Object.
     * @author Gustavo Huanca
     */
    public static Properties getProperties(final String path) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("File not found or Unable to read the properties file", e);
        }
        return properties;
    }
}
