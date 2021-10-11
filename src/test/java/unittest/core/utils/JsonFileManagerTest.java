/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package unittest.core.utils;

import core.utils.JsonFileManager;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class JsonFileManagerTest {
    private JsonFileManager jsonFileManager = new JsonFileManager();

    @Test
    public void testReadFileJson() throws IOException {
        String actual = jsonFileManager.readFileJson("src\\test\\resources\\test\\test.json");
        String expected = "{\"name\":\"New Task Name\",\"assignees\":[183],\"status\":\"complete\","
                + "\"due_date\":1508369194377,\"due_date_time\":false,\"tag\":{\"name\":\"API V2\","
                + "\"tag_fg\":\"#ffffff\",\"tag_bg\":\"#3c9d9b\"},\"custom_fields\":[{\"id\":"
                + "\"0a52c486-5f05-403b-b4fd-c512ff05131c\",\"value\":23},{\"id\":\""
                + "03efda77-c7a0-42d3-8afd-fd546353c2f5\",\"value\":\"Text field input\"}]}";
        assertEquals(actual, expected);
    }
}
