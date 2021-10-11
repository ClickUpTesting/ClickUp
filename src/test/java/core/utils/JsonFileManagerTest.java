package core.utils;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class JsonFileManagerTest {
    private JsonFileManager jsonFileManager = new JsonFileManager();

    @Test
    public void testReadFileJson() throws IOException {
        String actual = jsonFileManager.readFileJson("src\\test\\resources\\test\\test.json");
        String expected = "{\"name\":\"New Task Name\",\"assignees\":[183],\"status\":\"complete\","
                + "\"due_date\":1508369194377,\"due_date_time\":false,\"custom_fields\":"
                + "[{\"id\":\"0a52c486-5f05-403b-b4fd-c512ff05131c\",\"value\":23},{\"id\":"
                + "\"03efda77-c7a0-42d3-8afd-fd546353c2f5\",\"value\":\"Text field input\"}]}";
        assertEquals(actual, expected);
    }
}
