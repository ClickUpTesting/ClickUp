/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.utils;

import clickup.entities.features.GetAllFeatures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ScenarioContext {
    private Map<String, String> baseEnvironment;
    private Map<String, GetAllFeatures> featuresAmount;
    private Map<String, LinkedList> trash;
    private static ScenarioContext instance;

    public ScenarioContext() {
        initialize();
    }

    /**
     * Initializes all the maps inside the scenario context.
     *
     * @author Jorge Caceres
     */
    public void initialize() {
        baseEnvironment = new HashMap<>();
        featuresAmount = new HashMap<>();
        trash = new HashMap<>();
    }

    /**
     * Gets a scenario context instance.
     *
     * @return instance of the scenario context
     * @author Jorge Caceres
     */
    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    /**
     * Sets the base environment data.
     *
     * @param key   to be set on the base env map
     * @param value that will contain the env map
     * @author Jorge Caceres
     */
    public void setBaseEnvironment(final String key, final String value) {
        if (null != value) {
            baseEnvironment.put(key, value);
        }
    }

    /**
     * Gets the environment value assigned to a key.
     *
     * @param key to get the content
     * @return String stored the map
     * @author Jorge Caceres
     */
    public String getEnvData(final String key) {
        return baseEnvironment.get(key);
    }

    /**
     * Sets a feature inside the features map.
     *
     * @param key     to be set on the feature's map
     * @param feature that will contain the feature's map
     * @author Jorge Caceres
     */
    public void setFeatures(final String key, final GetAllFeatures feature) {
        featuresAmount.put(key, feature);
    }

    /**
     * Gets the feature assigned to a key.
     *
     * @param key to get the content
     * @return feature stored on the map
     * @author Jorge Caceres
     */
    public GetAllFeatures getFeatures(final String key) {
        return featuresAmount.get(key);
    }

    /**
     * Sets a list of trash data for tests.
     *
     * @param trashName   key to be set on the trash map
     * @param trashIdList that will contain the trash map
     * @author Jorge Caceres
     */
    public void setTrash(final String trashName,  LinkedList<String> trashIdList) {
        if (getTrashList(trashName) == null) {
            trash.put(trashName, trashIdList);
        } else {
            getTrashList(trashName).addAll(trashIdList);
        }
    }

    /**
     * Gets the trash list assigned to a key.
     *
     * @param trashName to get the content
     * @return List stored on the map
     * @author Jorge Caceres
     */
    public LinkedList<String> getTrashList(String trashName) {
        return trash.get(trashName);
    }
}
