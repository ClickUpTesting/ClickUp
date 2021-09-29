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

public class StringToDouble implements StringToObjectConverter {
    @Override
    public Object convertStringToObject(String string) {
        return Double.valueOf(string);
    }
}
