/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamSidebar {
    private List<Object> assignees;
    @JsonProperty("group_assignees")
    private List<Object> groupAssignees;
    @JsonProperty("assigned_comments")
    private boolean assignedComments;
    @JsonProperty("unassigned_tasks")
    private boolean unassignedTasks;

    public List<Object> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Object> assignees) {
        this.assignees = assignees;
    }

    public List<Object> getGroupAssignees() {
        return groupAssignees;
    }

    public void setGroupAssignees(List<Object> groupAssignees) {
        this.groupAssignees = groupAssignees;
    }

    public boolean isAssignedComments() {
        return assignedComments;
    }

    public void setAssignedComments(boolean assignedComments) {
        this.assignedComments = assignedComments;
    }

    public boolean isUnassignedTasks() {
        return unassignedTasks;
    }

    public void setUnassignedTasks(boolean unassignedTasks) {
        this.unassignedTasks = unassignedTasks;
    }
}
