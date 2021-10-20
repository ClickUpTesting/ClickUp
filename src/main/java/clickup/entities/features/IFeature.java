/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities.features;

import org.apache.commons.beanutils.PropertyUtils;
import java.lang.reflect.Field;
import java.util.Map;

import static clickup.utils.stringtoobjectconverter.StringToObjectContext.convertStringToObject;

public interface IFeature {
    /**
     * Sets all the attributes on the class.
     *
     * @param map a Map with the attributes to set
     * @author Raymundo Guaraguara
     */
    default void setAllFields(final Map map)
            throws Exception {
        Field[] attributes = this.getClass().getDeclaredFields();
        for (Object key : map.keySet()) {
            for (Field attribute : attributes) {
                if (key.equals(attribute.getName())) {
                    if (map.get(key) == null) {
                        PropertyUtils.setSimpleProperty(this, attribute.getName(), map.get(key));
                    } else if (attribute.getType().equals(map.get(key).getClass())) {
                        PropertyUtils.setSimpleProperty(this, attribute.getName(), map.get(key));
                    } else {
                        PropertyUtils.setSimpleProperty(this,
                                attribute.getName(), convertStringToObject((String) map.get(key),
                                        attribute.getType().getSimpleName()));
                    }
                }
            }
        }
    }

    /**
     * Gets identifier of feature
     *
     * @return a string with value of identifier
     * @author Gustavo Huanca
     */
    String getIdentifier();

    /**
     * Gets string with required field to create a feature in JSON format.
     *
     * @return a string in JSON format
     * @author Gustavo Huanca
     */
    String getRequiredField();

    /**
     * Creates a map according the values set on scenario,
     * The new map contains featureResponse values according baseMap
     *
     * @param featureResponse is IFeature which extract the values the response
     * @param baseMap baseMap with the fields set on the scenario
     * @return valuesMap corresponding featureResponse
     * @author Gustavo Huanca
     */
    Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> baseMap);

    void setDefaultValues();
}
