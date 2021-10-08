/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.Space;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SpaceRequest extends BaseRequest {

    /**
     * Creates a space and returns its identifier.
     *
     * @return a space_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createSpace() throws JsonProcessingException {
        Space space = new Space();
        space.setName("Space created RunTest before From API");
        apiResponse = apiFacade.createObject(space, ApiEndpoints.CREATE_SPACE, "team_id", teamId);
        return apiResponse.getBody(Space.class).getId();
    }

    /**
     * Deletes a space.
     *
     * @param id space_id
     * @author Jorge Caceres
     */
    public void deleteSpace(final String id) {
        apiFacade.deleteObject(ApiEndpoints.GET_SPACE, "space_id", id);
    }
}
