package core.utils;

import clickup.entities.GetAllFeatures;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, String> baseEnvironment;
    private Map<String, GetAllFeatures> featuresAmount;
    private static ScenarioContext instance;

    public ScenarioContext() {
        initialize();
    }

    public void initialize() {
        baseEnvironment = new HashMap<>();
        featuresAmount = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void setBaseEnvironment(final String key, final String value) {
        baseEnvironment.put(key, value);
    }

    public String getEnvData(final String key) {
        return baseEnvironment.get(key);
    }

    public void setFeatures(String key, GetAllFeatures feature) {
        featuresAmount.put(key, feature);
    }

    public GetAllFeatures getFeatures(String key) {
        return featuresAmount.get(key);
    }
}
