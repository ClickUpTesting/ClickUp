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

import clickup.api.entities.features.folders.Folder;
import clickup.api.requests.FoldersRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class FolderHooks {
    private FoldersRequest foldersRequest;
    private ScenarioTrash scenarioTrash;

    public FolderHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.foldersRequest = new FoldersRequest();
    }

    @Before(value = "@CreateFolder")
    public void createFolder() throws JsonProcessingException {
        Folder folder = foldersRequest.createFolder();
        scenarioTrash.setScenarioTrash("folder_id", folder.getId());
        scenarioTrash.setScenarioTrash("folder_name", folder.getName());
    }

    @After(value = "@DeleteFolder")
    public void deleteFolder() {
        foldersRequest.deleteFolder(scenarioTrash.getTrashValue("folder_id"));
    }

    @After(value = "@DeleteFolders")
    public void deleteFolders() {
        foldersRequest.deleteFolders();
    }
}
