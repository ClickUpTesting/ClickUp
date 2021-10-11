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

import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.cucumber.messages.internal.com.google.gson.JsonParser;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonFileManager {

    /**
     * Reads a file json.
     *
     * @param pathFile a path of file to read
     * @return a string with content of file
     * @throws IOException is exception if path or file are wrong
     * @author Gustavo Huanca
     */
    public String readFileJson(final String pathFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(pathFile));
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
        return parser.toString();
    }

    /**
     * Reads a file json.
     *
     * @param pathFile a path of file to read
     * @return a JsonObject with content of file
     * @throws IOException is exception if path or file are wrong
     * @author Gustavo Huanca
     */
    public JsonObject readFileJsonToJsonObject(final String pathFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(pathFile));
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
        return parser;
    }

    /**
     * Writes a string with format json
     *
     * @param jsonMapBody is map to convert json format
     * @return string with content of map
     * @author Gustavo Huanca
     */
    public String writeJson(final Map<String, Object> jsonMapBody) {
        JSONObject jsonBody = new JSONObject(jsonMapBody);
        return jsonBody.toString();
    }
}
