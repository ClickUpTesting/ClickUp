/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Settings {
    @JsonProperty("show_task_locations")
    private boolean showTaskLocations;
    @JsonProperty("show_subtasks")
    private int showSubtasks;
    @JsonProperty("show_subtask_parent_names")
    private boolean showSubtaskParentNames;
    @JsonProperty("show_closed_subtasks")
    private boolean showClosedSubtasks;
    @JsonProperty("show_assignees")
    private boolean showAssignees;
    @JsonProperty("show_images")
    private boolean showImages;
    @JsonProperty("show_timer")
    private Object showTimer;
    @JsonProperty("collapse_empty_columns")
    private Object collapseEmptyColumns;
    @JsonProperty("me_comments")
    private boolean meComments;
    @JsonProperty("me_subtasks")
    private boolean meSubtasks;
    @JsonProperty("me_checklists")
    private boolean meChecklists;
    @JsonProperty("show_empty_statuses")
    private boolean showEmptyStatuses;
    @JsonProperty("auto_wrap")
    private boolean autoWrap;
    @JsonProperty("time_in_status_view")
    private int timeInStatusView;

    public boolean isShowTaskLocations() {
        return showTaskLocations;
    }

    public void setShowTaskLocations(boolean showTaskLocations) {
        this.showTaskLocations = showTaskLocations;
    }

    public int getShowSubtasks() {
        return showSubtasks;
    }

    public void setShowSubtasks(int showSubtasks) {
        this.showSubtasks = showSubtasks;
    }

    public boolean isShowSubtaskParentNames() {
        return showSubtaskParentNames;
    }

    public void setShowSubtaskParentNames(boolean showSubtaskParentNames) {
        this.showSubtaskParentNames = showSubtaskParentNames;
    }

    public boolean isShowClosedSubtasks() {
        return showClosedSubtasks;
    }

    public void setShowClosedSubtasks(boolean showClosedSubtasks) {
        this.showClosedSubtasks = showClosedSubtasks;
    }

    public boolean isShowAssignees() {
        return showAssignees;
    }

    public void setShowAssignees(boolean showAssignees) {
        this.showAssignees = showAssignees;
    }

    public boolean isShowImages() {
        return showImages;
    }

    public void setShowImages(boolean showImages) {
        this.showImages = showImages;
    }

    public Object getShowTimer() {
        return showTimer;
    }

    public void setShowTimer(Object showTimer) {
        this.showTimer = showTimer;
    }

    public Object getCollapseEmptyColumns() {
        return collapseEmptyColumns;
    }

    public void setCollapseEmptyColumns(Object collapseEmptyColumns) {
        this.collapseEmptyColumns = collapseEmptyColumns;
    }

    public boolean isMeComments() {
        return meComments;
    }

    public void setMeComments(boolean meComments) {
        this.meComments = meComments;
    }

    public boolean isMeSubtasks() {
        return meSubtasks;
    }

    public void setMeSubtasks(boolean meSubtasks) {
        this.meSubtasks = meSubtasks;
    }

    public boolean isMeChecklists() {
        return meChecklists;
    }

    public void setMeChecklists(boolean meChecklists) {
        this.meChecklists = meChecklists;
    }

    public boolean isShowEmptyStatuses() {
        return showEmptyStatuses;
    }

    public void setShowEmptyStatuses(boolean showEmptyStatuses) {
        this.showEmptyStatuses = showEmptyStatuses;
    }

    public boolean isAutoWrap() {
        return autoWrap;
    }

    public void setAutoWrap(boolean autoWrap) {
        this.autoWrap = autoWrap;
    }

    public int getTimeInStatusView() {
        return timeInStatusView;
    }

    public void setTimeInStatusView(int timeInStatusView) {
        this.timeInStatusView = timeInStatusView;
    }
}
