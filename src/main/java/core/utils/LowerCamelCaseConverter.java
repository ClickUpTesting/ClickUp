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

public final class LowerCamelCaseConverter {
    private LowerCamelCaseConverter() {
    }

    /**
     * Converts a string to Lower Camel Case format.
     *
     * @param value a string
     * @return the string with lower camel case format
     * @author Raymundo Guaraguara
     */
    public static String convertToLowerCamelCase(final String value) {
        String[] words = value.split("\\s");
        String lowerCamelCaseWord = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                lowerCamelCaseWord = lowerCamelCaseWord.concat(words[i].toLowerCase());
            } else {
                lowerCamelCaseWord = lowerCamelCaseWord.concat(words[i].substring(0, 1).toUpperCase()
                        .concat(words[i].substring(1).toLowerCase()));
            }
        }
        return lowerCamelCaseWord;
    }
}
