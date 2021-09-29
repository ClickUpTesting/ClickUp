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

import static core.utils.PascalCaseConverter.convertToPascalCase;
import static org.testng.Assert.assertEquals;

public class PascalCaseConverterTest {

    @Test
    public void testConvertToPascalCase() {
        String value = "Hello World!";
        String actual = convertToPascalCase(value);
        String expected = "HELLO_WORLD!";
        assertEquals(actual, expected);
    }
}
