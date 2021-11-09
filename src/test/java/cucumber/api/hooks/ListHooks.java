/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.api.hooks;

import clickup.api.entities.features.lists.Lisst;
import clickup.api.requests.ListsRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ListHooks {

    private ListsRequest listsRequest;
    private ScenarioTrash scenarioTrash;

    public ListHooks(ScenarioTrash scenarioTrash) {
        this.listsRequest = new ListsRequest();
        this.scenarioTrash = scenarioTrash;
    }

    @Before(value = "@CreateListInFolder")
    public void createListInFolder() throws JsonProcessingException {
        Lisst lisst = listsRequest.createListInFolder();
        scenarioTrash.setScenarioTrash("list_id", lisst.getId());
        scenarioTrash.setScenarioTrash("list_name", lisst.getName());
    }

    @Before(value = "@CreateListInSpace")
    public void createListInSpace() throws JsonProcessingException {
        Lisst lisst = listsRequest.createListInSpace();
        scenarioTrash.setScenarioTrash("list_id", lisst.getId());
        scenarioTrash.setScenarioTrash("list_name", lisst.getName());
    }

    @After(value = "@DeleteList")
    public void deleteList() {
        listsRequest.deleteList(scenarioTrash.getTrashValue("list_id"));
    }

    @After(value = "@DeleteLists")
    public void deleteLists() {
        listsRequest.deleteLists();
    }
}
