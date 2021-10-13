/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.hooks;

import clickup.requests.ChecklistItemRequest;
import clickup.requests.ChecklistRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CheckListHooks {
    private ScenarioTrash scenarioTrash;
    private ChecklistRequest checklistRequest;
    private ChecklistItemRequest checklistItemRequest;

    public CheckListHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.checklistRequest = new ChecklistRequest();
        this.checklistItemRequest = new ChecklistItemRequest();
    }

    @Before(value = "@CreateChecklist")
    public void createChecklist() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("checklist_id", checklistRequest.createChecklist());
    }

    @After(value = "@DeleteChecklist")
    public void deleteChecklist() {
        checklistRequest.deleteChecklist(scenarioTrash.getTrashValue("checklist_id"));
    }

    @Before(value = "@CreateChecklistItem")
    public void createChecklistItem() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("checklist_item_id", checklistItemRequest.createChecklistItem());
    }

    @After(value = "@DeleteChecklistItem")
    public void deleteChecklistItem() {
        checklistItemRequest.deleteChecklistItem(scenarioTrash.getTrashValue("checklist_item_id"));
    }
}
