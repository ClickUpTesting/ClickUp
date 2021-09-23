/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package core.utils;

public class PascalCaseConverter {
    /**
     * Converts a string to Pascal Case format.
     *
     * @param value a string
     * @return the string with pascal case format
     * @author Raymundo Guaraguara
     */
    public static String convertToPascalCase(final String value) {
        return value.toUpperCase().replaceAll("\\s", "_");
    }
}
