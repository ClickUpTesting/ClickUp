package core.utils;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class MapStringStringToStringObjectTest {
    MapStringStringToStringObject m2 = new MapStringStringToStringObject();
    JsonFileManager jsonFileManager = new JsonFileManager();

    @Test
    public void testBuildMapStringObject() throws IOException {
        Map<String, String> mapInformation = new HashMap<>();
        mapInformation.put("id", "1");
        mapInformation.put("name", "John Doe");
        mapInformation.put("email", "john.doe@example.com");
        mapInformation.put("age", "32");
        mapInformation.put("status{id", "32");
        mapInformation.put("status{ref", "complete");
        mapInformation.put("status{color", "#6bc950");
        mapInformation.put("status{orderindex", "32");
        mapInformation.put("status{type", "8979");
        mapInformation.put("archived", "false");
        mapInformation.put("x-323", "false");
        String actual= jsonFileManager.writeJson(m2.buildMapStringObject(mapInformation));
        String expected = "{\"archived\":\"false\",\"name\":\"John Doe\",\"id\":\"1\",\"age\":\"32\","
                + "\"email\":\"john.doe@example.com\",\"status\":{\"ref\":\"complete\",\"id\":\"32\","
                + "\"color\":\"#6bc950\",\"orderindex\":\"32\",\"type\":\"8979\"},\"x-323\":\"false\"}";
        assertEquals(actual, expected);
    }

    @Test
    public void testBuildMapStringObject2() throws IOException {
        Map<String, String> mapInformation = new HashMap<>();
        mapInformation.put("id", "1");
        mapInformation.put("name", "John Doe");
        mapInformation.put("status{id", "32");
        mapInformation.put("status{ref", "complete");
        mapInformation.put("status{type", "8979");
        mapInformation.put("archived", "false");
        mapInformation.put("x-323", "false");
        mapInformation.put("tags[0]", "tag name 1");
        mapInformation.put("tags[1]", "tag name 2");
        mapInformation.put("assignees[0]", "183");
        String actual= jsonFileManager.writeJson(m2.buildMapStringObject(mapInformation));
        String expected = "{\"archived\":\"false\",\"name\":\"John Doe\",\"assignees\":[\"183\"],\"id\":\"1\","
                + "\"status\":{\"type\":\"8979\",\"ref\":\"complete\",\"id\":\"32\"},\"tags\":[\"tag name 1\","
                + "\"tag name 2\"],\"x-323\":\"false\"}";
        assertEquals(actual, expected);
    }

    @Test
    public void testBuildMapStringObject3() throws IOException {
        Map<String, String> mapInformation = new HashMap<>();
        mapInformation.put("tag{name", "API V2");
        mapInformation.put("tag{tag_fg", "#ffffff");
        mapInformation.put("tag{tag_bg", "#3c9d9b");
        String actual= jsonFileManager.writeJson(m2.buildMapStringObject(mapInformation));
        String expected = "{\"tag\":{\"name\":\"API V2\",\"tag_bg\":\"#3c9d9b\",\"tag_fg\":\"#ffffff\"}}";
        assertEquals(actual, expected);
    }

    @Test
    public void testBuildMapStringObject5() throws IOException {
        Map<String, String> mapInformation = new HashMap<>();
        mapInformation.put("id", "1");
        mapInformation.put("name", "John Doe");
        mapInformation.put("status{id", "32");
        mapInformation.put("status{ref", "complete");
        mapInformation.put("status{type", "8979");
        mapInformation.put("archived", "false");
        mapInformation.put("x-323", "false");
        mapInformation.put("tags[0]", "tag name 1");
        mapInformation.put("tags[1]", "tag name 2");
        mapInformation.put("assignees[0]", "183");
        mapInformation.put("test", "src\\test\\resources\\test\\custom_fields_by_defects.json");
        String actual= jsonFileManager.writeJson(m2.buildMapStringObject(mapInformation));
        String expected = "{\"archived\":\"false\",\"custom_fields\":[{\"value\":23,\"id\":"
                + "\"0a52c486-5f05-403b-b4fd-c512ff05131c\"},{\"value\":\"Text field input\",\"id\":\""
                + "03efda77-c7a0-42d3-8afd-fd546353c2f5\"}],\"name\":\"John Doe\",\"assignees\":[\"183\"],\"id\":\"1\","
                + "\"status\":{\"type\":\"8979\",\"ref\":\"complete\",\"id\":\"32\"},\"tags\":[\"tag name 1\","
                + "\"tag name 2\"],\"x-323\":\"false\"}";
        assertEquals(actual, expected);
    }
}