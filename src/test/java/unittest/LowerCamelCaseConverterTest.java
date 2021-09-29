/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package unittest;

import org.testng.annotations.Test;

import static core.utils.LowerCamelCaseConverter.convertToLowerCamelCase;
import static org.testng.Assert.assertEquals;

public class LowerCamelCaseConverterTest {

    @Test
    public void testConvertToLowerCamelCase() {
        String value = "HELLO world";
        String actual = convertToLowerCamelCase(value);
        String expected = "helloWorld";
        assertEquals(actual, expected);
    }
}
