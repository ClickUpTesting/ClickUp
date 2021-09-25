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
