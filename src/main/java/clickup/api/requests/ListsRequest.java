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
import clickup.api.entities.features.lists.Lisst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static core.utils.RandomCustom.random;

public class ListsRequest extends BaseRequest {

    /**
     * Creates a list in a folder and returns its identifier.
     *
     * @return a list_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Gustavo huanca
     */
    public String createListInFolder() throws JsonProcessingException {
        Lisst lisst = new Lisst();
        lisst.setName("List before From API".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(lisst),
                ApiEndpoints.LIST_IN_FOLDER, "folder_id", scenarioContext.getEnvData("folder_id"));
        return apiResponse.getBody(Lisst.class).getId();

    }

    /**
     * Creates a list in a spacer and returns its identifier.
     *
     * @return a list_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Gustavo Huanca
     */
    public String createListInSpace() throws JsonProcessingException {
        Lisst lisst = new Lisst();
        lisst.setName("List before in space From API".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(lisst),
                ApiEndpoints.LIST_IN_SPACE, "space_id", scenarioContext.getEnvData("space_id"));
        return apiResponse.getBody(Lisst.class).getId();

    }

    /**
     * Deletes a list.
     *
     * @param id the list id to be deleted
     * @author Gustavo Huanca
     */
    public void deleteList(final String id) {
        apiFacade.deleteObject(ApiEndpoints.GET_LIST, "list_id", id);
    }

    /**
     * Deletes a List's list.
     *
     * @author Gustavo Huanca
     */
    public void deleteLists() {
        apiFacade.deleteListsObjects(ApiEndpoints.GET_LIST, "FeatureName Trash");
    }
}
