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
import io.cucumber.java.After;

public class ViewHooks {
    private ViewsRequest viewsRequest;
    private ScenarioTrash scenarioTrash;

    public ViewHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.viewsRequest = new ViewsRequest();
    }

    @After(value = "@DeleteView")
    public void deleteFolder() {
        viewsRequest.deleteView(scenarioTrash.getTrashValue("view_id"));
    }
}
