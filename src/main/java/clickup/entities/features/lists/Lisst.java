/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities.features.lists;

import clickup.entities.Assignee;
import clickup.entities.Priority;
import clickup.entities.Space;
import clickup.entities.Status;
import clickup.entities.StatusesItem;
import clickup.entities.features.IFeature;
import clickup.entities.features.folders.Folder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static core.utils.RandomCustom.random;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Lisst implements IFeature {
    @JsonProperty("orderindex")
    private int orderIndex;
    @JsonProperty("due_date")
    private String dueDate;
    private Priority priority;
    private String content;
    private Space space;
    @JsonProperty("override_statuses")
    private boolean overrideStatuses;
    private boolean archived;
    @JsonProperty("permission_level")
    private String permissionLevel;
    private boolean deleted;
    private Folder folder;
    private String name;
    private List<StatusesItem> statuses;
    private String id;
    private Assignee assignee;
    private Status status;
    @JsonProperty("start_date")
    private Object startDate;
    @JsonProperty("inbound_address")
    private String inboundAddress;
    @JsonProperty("task_count")
    private String taskCount;

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(final String taskCount) {
        this.taskCount = taskCount;
    }

    public void setOrderIndex(final int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setPriority(final Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSpace(final Space space) {
        this.space = space;
    }

    public Space getSpace() {
        return space;
    }

    public void setOverrideStatuses(final boolean overrideStatuses) {
        this.overrideStatuses = overrideStatuses;
    }

    public boolean isOverrideStatuses() {
        return overrideStatuses;
    }

    public void setArchived(final boolean archived) {
        this.archived = archived;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setPermissionLevel(final String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setFolder(final Folder folder) {
        this.folder = folder;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatuses(final List<StatusesItem> statuses) {
        this.statuses = statuses;
    }

    public List<StatusesItem> getStatuses() {
        return statuses;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAssignee(final Assignee assignee) {
        this.assignee = assignee;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStartDate(final Object startDate) {
        this.startDate = startDate;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setInboundAddress(final String inboundAddress) {
        this.inboundAddress = inboundAddress;
    }

    public String getInboundAddress() {
        return inboundAddress;
    }

    @Override
    public String getIdentifier() {
        return id;
    }

    @Override
    @JsonIgnore
    @JsonProperty(value = "requiredField")
    public String getRequiredField() {
        return String.format("{ \"name\": \"List Required %s\"}", random());
    }

    @Override
    public void setDefaultValues() {

    }
}
