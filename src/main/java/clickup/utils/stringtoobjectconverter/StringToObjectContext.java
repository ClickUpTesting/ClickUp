/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.utils.stringtoobjectconverter;

public final class StringToObjectContext {
    private StringToObjectContext() {
    }

    /**
     * Converts an object type to another.
     *
     * @param value a String with the value to convert
     * @param dataType a String with the type to convert
     * @return the value with the required data type
     * @author Raymundo Guaraguara
     */
    public static Object convertStringToObject(final String value, final String dataType) {
        if (value == null) {
            return null;
        }
        return ObjectsNames.valueOf(dataType).getStringToObjectConverter()
                .convertStringToObject(value);
    }
}
