/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.hooks;

import clickup.ApiEndpoints;
import clickup.api.ApiFacade;
import clickup.entities.features.lists.Lisst;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import clickup.utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static core.utils.RandomCustom.random;

public class ListHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiResponse apiResponse;
    private ApiFacade apiFacade = new ApiFacade();

    public ListHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@CreateList or @AddTagToTask", order = 2)
    public void createList() throws JsonProcessingException {
        Lisst lisst = new Lisst();
        lisst.setName("List before From API".concat(random()));
        apiResponse = apiFacade.createObject(lisst, ApiEndpoints.LIST_IN_FOLDER, "folder_id",
                scenarioContext.getEnvData("folder_id"));
        scenarioContext.setBaseEnvironment("list_id", apiResponse.getBody(Lisst.class).getId());
    }

    @After(value = "@DeleteList or @AddTagToTask", order = 2)
    public void deleteList() {
        apiFacade.deleteObject(ApiEndpoints.GET_LIST, "list_id", scenarioContext.getEnvData("list_id"));
    }

    @After(value = "@DeleteLists")
    public void deleteLists() {
        apiFacade.deleteListsObjects(ApiEndpoints.GET_LIST, "FeatureName Trash");
    }
}
