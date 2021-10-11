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

    public String readFileJson(String pathFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(pathFile));
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
        return parser.toString();
    }

    public JsonObject readFileJsonToJsonObject(String pathFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(pathFile));
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
        return parser;
    }

    public String writeJson(Map<String, Object> jsonMapBody){
        JSONObject jsonBody = new JSONObject(jsonMapBody);
        return jsonBody.toString();
    }
}
