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