/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.steps;

import clickup.entities.features.checklists.ChecklistItems;
import clickup.entities.features.checklists.Checklists;
import clickup.utils.ScenarioTrash;
import core.api.ApiResponse;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class CheckListSteps {
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    private ScenarioTrash scenarioTrash;

    public CheckListSteps(ApiResponse apiResponse, SoftAssert softAssert, ScenarioTrash scenarioTrash) {
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @Then("I verify that the checklist item response status is {int}")
    public void verifyChecklistResponseCode(int responseCode) {
        List<ChecklistItems> checklistItemsList = apiResponse.getBody(Checklists.class).getChecklist().getItems();
        ChecklistItems createdItem = checklistItemsList.get(0);
        scenarioTrash.setScenarioTrash("checklist_item_id", createdItem.getId());
        softAssert.assertEquals(apiResponse.getStatusCode(), responseCode);
    }
}
