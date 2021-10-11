package core.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;

public class MapStringStringToStringObject {
    private JsonFileManager jsonFileManager;
    private static Map<String, Object> mapMain;
    List<Object> arrayBody;
    Map<String, Object> mapObjectBody;
    private String objectName = "";
    private String arrayName = "";

    public MapStringStringToStringObject() {
        jsonFileManager = new JsonFileManager();
    }

    public Map<String, Object> buildMapStringObject(Map<String, String> mapConverter) throws IOException {
        Map<String, String> mapInformation = new TreeMap<>(mapConverter);

        mapMain = new HashMap<>();
        for (String key : mapInformation.keySet()) {
            analyser(key, mapInformation.get(key));
        }
        defaultSetting();
        return mapMain;
    }

    protected void analyser(String key, String value) throws IOException {
        if (key.contains("{")) {
            objectBody(key, value);
            return;
        }
        if (key.contains("[")) {
            arrayBody(key, value);
            return;
        }
        if (value.contains(".json")){
            setByDefaultProperty(value);
            return;
        }
        defaultSetting();
        addMainMapBody(key, value);
    }

    protected void defaultSetting(){
        if (null != mapObjectBody) {
            addMainMapBody(objectName, mapObjectBody);
            objectName = "";
        }
        if (null != arrayBody) {
            addMainMapBody(arrayName, arrayBody);
            arrayName = "";
        }
    }

    protected void addMainMapBody(String parameter, Object value) {
        if (!"".equals(parameter)) {
            mapMain.put(parameter, value);
        }
    }

    protected void arrayBody(String parameter, String value) {
        String[] divided = parameter.split("\\[");
        if ("".equals(arrayName)) {
            arrayName = divided[0];
            arrayBody = new ArrayList<>();
            arrayBody.add(value);
            return;
        }
        if (arrayName.equals(divided[0])) {
            arrayBody.add(value);
            return;
        }
        arrayName = "";
        addMainMapBody(divided[0], arrayBody);
        arrayBody = null;
    }

    protected void objectBody(String parameter, String value) {
        String[] divided = parameter.split("\\{");

        if ("".equals(objectName)) {
            objectName = divided[0];
            mapObjectBody = new HashMap<>();
            mapObjectBody.put(divided[1], value);
            return;
        }
        if (objectName.equals(divided[0])) {
            mapObjectBody.put(divided[1], value);
            return;
        }
        objectName = "";
        addMainMapBody(divided[0], mapObjectBody);
        mapObjectBody = null;
    }

    protected void setByDefaultProperty(String path) throws IOException {
        HashMap<String, Object> yourHashMap = new Gson().fromJson(jsonFileManager.readFileJsonToJsonObject(path)
                .toString(), HashMap.class);
        mapMain.putAll(yourHashMap);
    }
}
