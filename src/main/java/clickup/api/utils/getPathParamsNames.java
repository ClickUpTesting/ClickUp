/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.api.utils;

import java.util.ArrayList;
import java.util.List;

public final class getPathParamsNames {
    private getPathParamsNames() {
    }

    /**
     * Gets the path params from an endpoint.
     *
     * @param endpoint base to get path params
     * @return List with all path params inside an endpoint
     * @author Raymundo Guaraguara
     */
    public static List<String> getPathParamsFromEndpoint(final String endpoint) {
        List<String> pathParamsNames = new ArrayList();
        String[] endpointParts = endpoint.split("/");
        for (int i = 0; i < endpointParts.length; i++) {
            if (endpointParts[i].contains("{") && endpointParts[i].contains("}")) {
                pathParamsNames.add(endpointParts[i].substring(1, endpointParts[i].length() - 1));
            }
        }
        return pathParamsNames;
    }
}
