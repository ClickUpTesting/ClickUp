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

import java.util.HashMap;
import java.util.Map;

public class ScenarioTrash {
    private Map<String, String> scenarioTrash;

    public ScenarioTrash() {
        scenarioTrash = new HashMap<>();
    }

    /**
     * Sets the trash data.
     *
     * @param key   to be set on the trash map
     * @param value that will contain the trash map
     * @author Jorge Caceres
     */
    public void setScenarioTrash(final String key, final String value) {
        if (null != value) {
            scenarioTrash.put(key, value);
        }
    }

    /**
     * Gets the trash value assigned to a key.
     *
     * @param key to get the content
     * @return String stored the map
     * @author Jorge Caceres
     */
    public String getTrashValue(final String key) {
        return scenarioTrash.get(key);
    }

    /**
     * Gets the trash value assigned to a key.
     *
     * @return Map stored the map
     * @author Jorge Caceres
     */
    public Map<String, String> getScenarioTrash() {
        return scenarioTrash;
    }
}
