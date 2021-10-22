/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.api.entities.features.sharedhierarchy;

import clickup.api.entities.features.IFeature;
import clickup.api.entities.features.folders.Folder;
import clickup.api.entities.features.lists.Lisst;
import clickup.api.entities.features.tasks.Task;

import java.util.List;
import java.util.Map;

public class Shared implements IFeature {
    private List<Folder> folders;
    private List<Lisst> lists;
    private List<Task> tasks;

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public List<Lisst> getLists() {
        return lists;
    }

    public void setLists(List<Lisst> lists) {
        this.lists = lists;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public String getRequiredField() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }

    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }
}
