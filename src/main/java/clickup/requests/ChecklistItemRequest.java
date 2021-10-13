package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.features.checklists.ChecklistItems;
import clickup.entities.features.checklists.Checklists;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;

import java.util.List;

import static core.utils.RandomCustom.random;

public class ChecklistItemRequest extends BaseRequest {
    private ApiRequest apiRequest;

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
        apiResponse = apiFacade.createObject(checklistItems, ApiEndpoints.CREATE_CHECKLIST_ITEM, "checklist_id",
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
        apiRequestBuilder
                .cleanParams()
                .clearBody()
                .endpoint(ApiEndpoints.DELETE_CHECKLIST_ITEM.getEndpoint())
                .pathParams("checklist_id", scenarioContext.getEnvData("checklist_id"))
                .pathParams("checklist_item_id", id)
                .method(ApiMethod.DELETE);
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }
}
