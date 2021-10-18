/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities.features.views;

import clickup.entities.features.IGetAllFeatures;
import clickup.entities.features.tasks.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TaskViews implements IGetAllFeatures {
    private List<Task> tasks;
    @JsonProperty("last_page")
    private boolean lastPage;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public int getAmount() {
        return tasks.size();
    }
}
