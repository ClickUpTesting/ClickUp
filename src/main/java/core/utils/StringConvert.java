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

public final class StringConvert {

    private StringConvert() {

    }

    /**
     * Converts the word "null" to null
     *
     * @param value to analyze
     * @return null or value
     * @author Gustavo Huanca
     */
    public static String stringToNull(final String value) {
        if ("null".equals(value)) {
            return null;
        }
        return value;
    }
}
