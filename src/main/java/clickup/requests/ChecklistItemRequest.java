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
import clickup.entities.features.checklists.ChecklistItems;
import clickup.entities.features.checklists.Checklists;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.utils.RandomCustom.random;

public class ChecklistItemRequest extends BaseRequest {

    /**
     * Creates a checklist item and returns its identifier.
     *
     * @return a checklist_item_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createChecklistItem() throws JsonProcessingException {
        ChecklistItems checklistItems = new ChecklistItems();
        checklistItems.setName("Checklist Item created by API".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(checklistItems),
                ApiEndpoints.CREATE_CHECKLIST_ITEM, "checklist_id",
                scenarioContext.getEnvData("checklist_id"));
        List<ChecklistItems> checklistItemsList = apiResponse.getBody(Checklists.class).getChecklist().getItems();
        ChecklistItems createdItem = checklistItemsList.stream()
                .filter(item -> item.getName().equals(checklistItems.getName())).findAny().get();
        return createdItem.getId();
    }

    /**
     * Deletes a checklist item from a checklist.
     *
     * @param id to be deleted from a checklist
     * @author Jorge Caceres
     */
    public void deleteChecklistItem(final String id) {
        Map<String, String> mapPathParams = new HashMap<>();
        mapPathParams.put("checklist_id", scenarioContext.getEnvData("checklist_id"));
        mapPathParams.put("checklist_item_id", id);
        apiFacade.deleteObject(ApiEndpoints.DELETE_CHECKLIST_ITEM, mapPathParams);
    }
}
