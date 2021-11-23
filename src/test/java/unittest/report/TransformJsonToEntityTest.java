/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package unittest.report;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import core.report.cucumber.core.entities.ScenarioEntity;
import core.utils.JsonFileManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TransformJsonToEntityTest {
    private static JsonFileManager jsonFileManager;

    public TransformJsonToEntityTest() {
        jsonFileManager = new JsonFileManager();
    }

    @DataProvider(name = "fileJson")
    public static Object[][] valuesOfJsonFile() throws IOException {
        Type listType = new TypeToken<List<ScenarioEntity>>() {
        }.getType();
        List<ScenarioEntity> scenarioEntityList = new Gson().fromJson(
                jsonFileManager.readFileJsonToJsonArray("src/test/resources/test/cucumber.json").toString(),
                listType);
        ScenarioEntity scenarioEntity = scenarioEntityList.get(0);
        return new Object[][]{{scenarioEntity.getName(), "Update task"},
                {scenarioEntity.getKeyword(), "Feature"},
                {scenarioEntity.getTags().get(0).getName(), "@GUI"},
                {scenarioEntity.getTags().get(0).getType(), "Tag"},
                {scenarioEntity.getElements().get(0).getStartTimestamp(), "2021-11-17T15:16:57.454Z"},
                {scenarioEntity.getElements().get(0).getDescription(), ""},
                {scenarioEntity.getElements().get(0).getName(), "Update a task with default setting"}
        };
    }

    @Test(dataProvider = "fileJson")
    public void assertObjectWithJsonFile(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
}
