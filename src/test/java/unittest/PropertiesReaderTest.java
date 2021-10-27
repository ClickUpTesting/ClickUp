package unittest;

import core.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesReaderTest {
    private Properties propertiesReader;
    private String pathPropertiesField = "src/test/resources/test/test.properties";

    @DataProvider(name = "propertyReader")
    public static Object[][] valuesOfPropertyReader() {
        return new Object[][]{{"world", "testPassed"},
                {"Not found", null},
                {"position", "500"}};
    }

    @Test(dataProvider = "propertyReader")
    public void readPropertyFieldAWorld(String world, String expected) {
        propertiesReader = PropertiesReader.getProperties(pathPropertiesField);
        String actual = propertiesReader.getProperty(world);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {RuntimeException.class},
            expectedExceptionsMessageRegExp = "File not found or Unable to read the properties file")
    public void fieldNotFoundInPropertyReader() {
        propertiesReader = PropertiesReader.getProperties("test.properties");
    }
}
