/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package cucumber.hooks;

import clickup.requests.ViewsRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ViewHooks {
    private ViewsRequest viewsRequest;
    private ScenarioTrash scenarioTrash;

    public ViewHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.viewsRequest = new ViewsRequest();
    }

    @Before(value = "@CreateTeamView")
    public void createTeamView() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("view_id", viewsRequest.createTeamView());
    }

    @After(value = "@DeleteView")
    public void deleteFolder() {
        viewsRequest.deleteView(scenarioTrash.getTrashValue("view_id"));
    }

    @After(value = "@DeleteViews")
    public void deleteFolders() {
        viewsRequest.deleteViews();
    }
}
