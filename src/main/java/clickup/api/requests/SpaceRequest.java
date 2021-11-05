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
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import java.util.LinkedList;
import org.json.JSONObject;

import static core.utils.RandomCustom.random;

public class SpaceRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Creates a space and returns its identifier.
     *
     * @return a space_id
     * @author Jorge Caceres
     */
    public Space createSpace() {
        JSONObject spaceBody = new JSONObject();
        JSONObject featuresBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        tagBody.put("enabled", true);
        featuresBody.put("tags", tagBody);
        spaceBody.put("name", "Space created RunTest before From API".concat(random()));
        spaceBody.put("features", featuresBody);
        apiResponse = apiFacade.createObject(spaceBody.toString(),
                ApiEndpoints.CREATE_SPACE, "team_id", teamId);
        return apiResponse.getBody(Space.class);
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
