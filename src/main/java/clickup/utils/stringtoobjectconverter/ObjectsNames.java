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

public enum ObjectsNames {
    Boolean(new StringToBoolean()),
    Double(new StringToDouble()),
    Long(new StringToLong()),
    Integer(new StringToInteger());

    private StringToObjectConverter stringToObjectConverter;

    ObjectsNames(final StringToObjectConverter stringToObjectConverter) {
        this.stringToObjectConverter = stringToObjectConverter;
    }

    /**
     * Gets the object StringToObjectConverter of the enum.
     *
     * @return the proper object StringToObjectConverter
     * @author Raymundo Guaraguara
     */
    public StringToObjectConverter getStringToObjectConverter() {
        return stringToObjectConverter;
    }
}
