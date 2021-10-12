/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.features.views.View;
import clickup.entities.features.views.Views;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;

import java.util.LinkedList;

import static core.utils.RandomCustom.random;

public class ViewsRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Creates a team view and returns its identifier.
     *
     * @return a view_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Raymundo GuaraGuara
     */
    public String createTeamView() throws JsonProcessingException {
        View view = new View();
        view.setName("Team View created in ViewHooks From API".concat(random()));
        apiResponse = apiFacade.createObject(view, ApiEndpoints.CREATE_TEAM_VIEW, "team_id",
                scenarioContext.getEnvData("team_id"));
        return apiResponse.getBody(Views.class).getIdentifier();
    }

    /**
     * Deletes a view.
     *
     * @param id the view id to be deleted
     * @author Raymundo GuaraGuara
     */
    public void deleteView(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_VIEW, "view_id", id);
    }

    /**
     * Deletes a folder's list.
     *
     * @author Raymundo GuaraGuara
     */
    public void deleteViews() {
        LinkedList<String> viewsTrashList = scenarioContext.getTrashList("Views");
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_VIEW.getEndpoint())
                .method(ApiMethod.DELETE);
        for (String viewId : viewsTrashList) {
            apiRequestBuilder.pathParams("view_id", viewId);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
        scenarioContext.getTrashList("Views").clear();
    }
}
