/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities.features.tasks;

import clickup.entities.features.IFeature;

import java.util.List;
import java.util.Map;

public class Tasks implements IFeature {
    private List<Task> tasks;

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
    public Map<String, String> matchesValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }
}
