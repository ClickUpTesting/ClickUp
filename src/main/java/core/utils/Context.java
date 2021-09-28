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

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, String> pathParams;
    private Map<String, String> pathParamsStep;
    public Context() {
        pathParams = new HashMap<>();
        pathParamsStep = new HashMap<>();
    }

    /**
     * Gets the map with values of path params.
     *
     * @return Map with values of path params
     * @author Gustavo Huanca
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }

    /**
     * Sets the values for path params.
     *
     * @param param String with the path params name
     * @param value String with the path params value
     * @author Gustavo Huanca
     */
    public void addPathParams(final String param, final String value) {
        pathParams.put(param, value);
    }

    /**
     * Gets the map with values of path params.
     *
     * @return Map with values of path params
     * @author Gustavo Huanca
     */
    public Map<String, String> getPathParamsStep() {
        return pathParamsStep;
    }

    /**
     * Sets the values for path params.
     *
     * @param param String with the path params name
     * @param value String with the path params value
     * @author Gustavo Huanca
     */
    public void addPathParamsStep(final String param, final String value) {
        pathParamsStep.put(param, value);
    }
}
