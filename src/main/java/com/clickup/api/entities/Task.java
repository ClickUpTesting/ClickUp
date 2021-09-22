/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa
 */

package com.clickup.api.entities;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "custom_id",
        "name",
        "text_content",
        "description",
        "status",
        "orderindex",
        "date_created",
        "date_updated",
        "date_closed",
        "archived",
        "creator",
        "assignees",
        "watchers",
        "checklists",
        "tags",
        "parent",
        "priority",
        "due_date",
        "start_date",
        "points",
        "time_estimate",
        "time_spent",
        "custom_fields",
        "dependencies",
        "linked_tasks",
        "team_id",
        "url",
        "permission_level",
        "list",
        "project",
        "folder",
        "space"
})
public class Task {

    @JsonProperty("id")
    private String id;
    @JsonProperty("custom_id")
    private Object customId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("text_content")
    private String textContent;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("orderindex")
    private String orderindex;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_updated")
    private String dateUpdated;
    @JsonProperty("date_closed")
    private Object dateClosed;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("creator")
    private Creator creator;
    @JsonProperty("assignees")
    private java.util.List<Object> assignees = null;
    @JsonProperty("watchers")
    private java.util.List<Watcher> watchers = null;
    @JsonProperty("checklists")
    private java.util.List<Object> checklists = null;
    @JsonProperty("tags")
    private java.util.List<Tag> tags = null;
    @JsonProperty("parent")
    private Object parent;
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("points")
    private Object points;
    @JsonProperty("time_estimate")
    private Integer timeEstimate;
    @JsonProperty("time_spent")
    private Integer timeSpent;
    @JsonProperty("custom_fields")
    private java.util.List<Object> customFields = null;
    @JsonProperty("dependencies")
    private java.util.List<Object> dependencies = null;
    @JsonProperty("linked_tasks")
    private java.util.List<Object> linkedTasks = null;
    @JsonProperty("team_id")
    private String teamId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("permission_level")
    private String permissionLevel;
    @JsonProperty("list")
    private Lisst list;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("folder")
    private Folder folder;
    @JsonProperty("space")
    private Space space;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("custom_id")
    public Object getCustomId() {
        return customId;
    }

    @JsonProperty("custom_id")
    public void setCustomId(Object customId) {
        this.customId = customId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("text_content")
    public String getTextContent() {
        return textContent;
    }

    @JsonProperty("text_content")
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("orderindex")
    public String getOrderindex() {
        return orderindex;
    }

    @JsonProperty("orderindex")
    public void setOrderindex(String orderindex) {
        this.orderindex = orderindex;
    }

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("date_updated")
    public String getDateUpdated() {
        return dateUpdated;
    }

    @JsonProperty("date_updated")
    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @JsonProperty("date_closed")
    public Object getDateClosed() {
        return dateClosed;
    }

    @JsonProperty("date_closed")
    public void setDateClosed(Object dateClosed) {
        this.dateClosed = dateClosed;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @JsonProperty("creator")
    public Creator getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    @JsonProperty("assignees")
    public java.util.List<Object> getAssignees() {
        return assignees;
    }

    @JsonProperty("assignees")
    public void setAssignees(java.util.List<Object> assignees) {
        this.assignees = assignees;
    }

    @JsonProperty("watchers")
    public java.util.List<Watcher> getWatchers() {
        return watchers;
    }

    @JsonProperty("watchers")
    public void setWatchers(java.util.List<Watcher> watchers) {
        this.watchers = watchers;
    }

    @JsonProperty("checklists")
    public java.util.List<Object> getChecklists() {
        return checklists;
    }

    @JsonProperty("checklists")
    public void setChecklists(java.util.List<Object> checklists) {
        this.checklists = checklists;
    }

    @JsonProperty("tags")
    public java.util.List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(java.util.List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("parent")
    public Object getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Object parent) {
        this.parent = parent;
    }

    @JsonProperty("priority")
    public Priority getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due_date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("points")
    public Object getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Object points) {
        this.points = points;
    }

    @JsonProperty("time_estimate")
    public Integer getTimeEstimate() {
        return timeEstimate;
    }

    @JsonProperty("time_estimate")
    public void setTimeEstimate(Integer timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    @JsonProperty("time_spent")
    public Integer getTimeSpent() {
        return timeSpent;
    }

    @JsonProperty("time_spent")
    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    @JsonProperty("custom_fields")
    public java.util.List<Object> getCustomFields() {
        return customFields;
    }

    @JsonProperty("custom_fields")
    public void setCustomFields(java.util.List<Object> customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("dependencies")
    public java.util.List<Object> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(java.util.List<Object> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("linked_tasks")
    public java.util.List<Object> getLinkedTasks() {
        return linkedTasks;
    }

    @JsonProperty("linked_tasks")
    public void setLinkedTasks(java.util.List<Object> linkedTasks) {
        this.linkedTasks = linkedTasks;
    }

    @JsonProperty("team_id")
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("permission_level")
    public String getPermissionLevel() {
        return permissionLevel;
    }

    @JsonProperty("permission_level")
    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @JsonProperty("list")
    public Lisst getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(Lisst list) {
        this.list = list;
    }

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonProperty("folder")
    public Folder getFolder() {
        return folder;
    }

    @JsonProperty("folder")
    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    @JsonProperty("space")
    public Space getSpace() {
        return space;
    }

    @JsonProperty("space")
    public void setSpace(Space space) {
        this.space = space;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

