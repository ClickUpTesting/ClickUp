/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.api.entities.features;

import java.util.Map;

public interface IFeature {

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
