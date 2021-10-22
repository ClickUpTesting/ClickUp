/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.api.requests;

import clickup.api.ApiEndpoints;
import clickup.api.entities.features.spaces.Space;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import java.util.LinkedList;
import com.fasterxml.jackson.databind.ObjectMapper;

import static core.utils.RandomCustom.random;

public class SpaceRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Creates a space and returns its identifier.
     *
     * @return a space_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createSpace() throws JsonProcessingException {
        Space space = new Space();
        space.setName("Space created RunTest before From API".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(space),
                ApiEndpoints.CREATE_SPACE, "team_id", teamId);
        return apiResponse.getBody(Space.class).getId();
    }

    /**
     * Deletes a space.
     *
     * @param id space_id
     * @author Jorge Caceres
     */
    public void deleteSpace(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_SPACE, "space_id", id);
    }

    /**
     * Deletes all spaces.
     *
     * @author Raymundo GuaraGuara
     */
    public void deleteSpaces() {
        LinkedList<String> spacesTrashList = scenarioContext.getTrashList("Spaces");
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_SPACE.getEndpoint())
                .method(ApiMethod.DELETE);
        for (String spaceId : spacesTrashList) {
            apiRequestBuilder.pathParams("space_id", spaceId);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
        scenarioContext.getTrashList("Spaces").clear();
    }
}
