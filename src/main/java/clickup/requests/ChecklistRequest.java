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
import clickup.entities.features.checklists.Checklist;
import clickup.entities.features.checklists.Checklists;
import com.fasterxml.jackson.core.JsonProcessingException;

import static core.utils.RandomCustom.random;

public class ChecklistRequest extends BaseRequest {

    /**
     * Creates a checklist and returns its identifier.
     *
     * @return a checklist_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Jorge Caceres
     */
    public String createChecklist() throws JsonProcessingException {
        Checklist checklist = new Checklist();
        checklist.setName("Checklist created by API".concat(random()));
        apiResponse = apiFacade.createObject(checklist, ApiEndpoints.CREATE_CHECKLIST, "task_id",
                scenarioContext.getEnvData("task_id"));
        return apiResponse.getBody(Checklists.class).getIdentifier();
    }

    /**
     * Deletes a checklist.
     *
     * @param id the checklist id to be deleted
     * @author Jorge Caceres
     */
    public void deleteChecklist(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_CHECKLIST, "checklist_id", id);
    }
}
