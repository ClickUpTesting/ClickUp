/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class StringToMap {
    private ScenarioContext scenarioContext;

    public StringToMap() {
        scenarioContext = ScenarioContext.getInstance();
    }

    /**
     * Extracts path params from endpoint and set in map.
     * find the path params in scenarioTrash and scenarioContext
     *
     * @param endPoint      to extract path params
     * @param scenarioTrash contains the id and path params
     * @return a map according the values of path params
     */
    public Map<String, String> extractPathParams(String endPoint, ScenarioTrash scenarioTrash) {
        Map<String, String> mapPathParams = new HashMap<>();
        List<String> pathParamsList = getPathParamsFromEndpoint(endPoint);
        for (String pathParams : pathParamsList) {
            if (scenarioTrash.getTrashValue(pathParams) != null) {
                mapPathParams.put(pathParams, scenarioTrash.getTrashValue(pathParams));
            } else {
                mapPathParams.put(pathParams, scenarioContext.getEnvData(pathParams));
            }
        }
        return mapPathParams;
    }
}
