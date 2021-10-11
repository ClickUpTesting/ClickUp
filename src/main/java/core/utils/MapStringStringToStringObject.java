/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import static core.utils.StringConvert.stringToNull;

/**
 * This class to convert a Map< String,String > to Map< String, Object >.
 * The main of function is to read a map in .feature and use it in request body
 * Rules of conventions:
 * to set array the key has to have [] example assignees[0]
 * to set object the key has to have { example tag{tag_fg
 * Check \src\test\resources\test\test.json and the MapStringStringToStringObjectTest.java unittest
 */
public class MapStringStringToStringObject {
    private JsonFileManager jsonFileManager;
    private static Map<String, Object> mapMain;
    private List<Object> arrayBody;
    private Map<String, Object> mapObjectBody;
    private String objectName = "";
    private String arrayName = "";

    public MapStringStringToStringObject() {
        jsonFileManager = new JsonFileManager();
    }

    /**
     * Converts Map< String, String > to Map< String, Object >
     *
     * @param mapConverter a map to convert
     * @return a map to set body of request
     * @throws IOException a exception when the file doesn't exit
     * @author Gustavo Huanca
     */
    public Map<String, Object> buildMapStringObject(final Map<String, String> mapConverter) throws IOException {
        Map<String, String> mapInformation = new TreeMap<>(mapConverter);

        mapMain = new HashMap<>();
        for (String key : mapInformation.keySet()) {
            analyser(key, mapInformation.get(key));
        }
        defaultSetting();
        return mapMain;
    }

    /**
     * Analyzes the value and the key of map.
     *
     * @param key   is key of map
     * @param value is value of map
     * @throws IOException a exception when the file doesn't exit
     * @author Gustavo Huanca
     */
    protected void analyser(final String key, final String value) throws IOException {
        if (key.contains("{")) {
            objectBody(key, value);
            return;
        }
        if (key.contains("[")) {
            arrayBody(key, value);
            return;
        }
        if (value.contains(".json")) {
            setByDefaultProperty(value);
            return;
        }
        defaultSetting();
        addMainMapBody(key, stringToNull(value));
    }

    /**
     * Adds mapObjectBody and arrayBody to mapMain.
     *
     * @author Gustavo Huanca
     */
    protected void defaultSetting() {
        if (null != mapObjectBody) {
            addMainMapBody(objectName, mapObjectBody);
            objectName = "";
        }
        if (null != arrayBody) {
            addMainMapBody(arrayName, arrayBody);
            arrayName = "";
        }
    }

    /**
     * Analyzes if parameter is empty.
     *
     * @param key   is key of map
     * @param value is value of map
     * @author Gustavo Huanca
     */
    protected void addMainMapBody(final String key, final Object value) {
        if (!"".equals(key)) {
            mapMain.put(key, value);
        }
    }

    /**
     * Builds and create array in map.
     *
     * @param parameter to Analyze
     * @param value     to set in array
     * @author Gustavo Huanca
     */
    protected void arrayBody(final String parameter, final String value) {
        String[] divided = parameter.split("\\[");
        if ("".equals(arrayName)) {
            arrayName = divided[0];
            arrayBody = new ArrayList<>();
            arrayBody.add(stringToNull(value));
            return;
        }
        if (arrayName.equals(divided[0])) {
            arrayBody.add(stringToNull(value));
            return;
        }
        arrayName = "";
        addMainMapBody(divided[0], arrayBody);
        arrayBody = null;
    }

    /**
     * Builds and create object in map.
     *
     * @param parameter to Analyze
     * @param value     to set in object
     * @author Gustavo Huanca
     */
    protected void objectBody(final String parameter, final String value) {
        String[] divided = parameter.split("\\{");

        if ("".equals(objectName)) {
            objectName = divided[0];
            mapObjectBody = new HashMap<>();
            mapObjectBody.put(divided[1], stringToNull(value));
            return;
        }
        if (objectName.equals(divided[0])) {
            mapObjectBody.put(divided[1], stringToNull(value));
            return;
        }
        objectName = "";
        addMainMapBody(divided[0], mapObjectBody);
        mapObjectBody = null;
    }

    /**
     * Sets and add .json to mapMain
     *
     * @param path to the json file
     * @throws IOException a exception when the file doesn't exit
     * @author Gustavo Huanca
     */
    protected void setByDefaultProperty(final String path) throws IOException {
        HashMap<String, Object> yourHashMap = new Gson().fromJson(jsonFileManager.readFileJsonToJsonObject(path)
                .toString(), HashMap.class);
        mapMain.putAll(yourHashMap);
    }
}
