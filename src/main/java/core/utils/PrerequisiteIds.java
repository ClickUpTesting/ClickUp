/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @Saul Caspa
 */

package core.utils;

import java.util.HashMap;
import java.util.Map;

public class PrerequisiteIds {

    private Map<String, String> objects;

    public PrerequisiteIds() {
        objects = new HashMap<String, String>();
    }

    /**
     * Gets the id of a given object name.
     *
     * @param objectName represents the name of the object in the map
     * @return a String that represents the id of the object
     * @author saul Caspa
     */
    public String getObjectId(final String objectName) {
        return objects.get(objectName);
    }

    /**
     * Sets the object name and its id in the map.
     *
     * @param objectName re[resents the name of the object in the map
     * @param id represents the id of the object
     * @author saul Caspa
     */
    public void setObjectId(final String objectName, final String id) {
        objects.put(objectName, id);
    }
}
