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

import clickup.api.entities.features.spaces.Space;
import clickup.api.requests.SpaceRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SpaceHooks {
    private SpaceRequest spaceRequest;
    private ScenarioTrash scenarioTrash;

    public SpaceHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.spaceRequest = new SpaceRequest();
    }

    @Before(value = "@CreateSpace")
    public void createSpace() throws JsonProcessingException {
        Space space = spaceRequest.createSpace();
        scenarioTrash.setScenarioTrash("space_id", space.getId());
        scenarioTrash.setScenarioTrash("name_space", space.getName());
    }

    @After(value = "@DeleteSpace")
    public void deleteSpace() {
        spaceRequest.deleteSpace(scenarioTrash.getTrashValue("space_id"));
    }

    @After(value = "@DeleteSpaces")
    public void deleteSpaces() {
        spaceRequest.deleteSpaces();
    }
}
