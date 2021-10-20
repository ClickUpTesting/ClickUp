/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.tasks;

import clickup.entities.Priority;
import clickup.entities.features.spaces.Space;
import clickup.entities.Status;
import clickup.entities.features.IFeature;
import clickup.entities.features.folders.Folder;
import clickup.entities.features.tags.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.api.ApiRequestSpecificationProvider.add;
import static core.utils.StringConvert.nullToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Task implements IFeature {
    public String id;
    public Object custom_id;
    public String name;
    public Object text_content;
    public Object description;
    public Status status;
    @JsonProperty("orderindex")
    public String orderIndex;
    @JsonProperty("date_created")
    public String dateCreated;
    @JsonProperty("date_updated")
    public String dateUpdated;
    @JsonProperty("date_closed")
    public Object dateClosed;
    public boolean archived;
    public Object creator;
    public List<Object> assignees;
    public List<Object> watchers;
    public List<Object> checklists;
    public List<Tag> tags;
    public Object parent;
    public Priority priority;
    @JsonProperty("due_date")
    public Object dueDate;
    @JsonProperty("start_date")
    public Object startDate;
    public Object points;
    @JsonProperty("time_estimate")
    public Object timeEstimate;
    public int time_spent;
    @JsonProperty("custom_fields")
    public List<Object> customFields;
    public List<Object> dependencies;
    @JsonProperty("linked_tasks")
    public List<Object> linkedTasks;
    @JsonProperty("team_id")
    public String teamId;
    public String url;
    @JsonProperty("permission_level")
    public String permissionLevel;
    public Object list;
    public Object project;
    public Folder folder;
    public Space space;
    public String[] attachments;


    public String[] getAttachments() {
        return attachments;
    }

    public void setAttachments(String[] attachments) {
        this.attachments = attachments;
    }

    public Object getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(Object custom_id) {
        this.custom_id = custom_id;
    }

    public Object getText_content() {
        return text_content;
    }

    public void setText_content(Object text_content) {
        this.text_content = text_content;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Object getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Object dateClosed) {
        this.dateClosed = dateClosed;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public List<Object> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Object> assignees) {
        this.assignees = assignees;
    }

    public List<Object> getWatchers() {
        return watchers;
    }

    public void setWatchers(List<Object> watchers) {
        this.watchers = watchers;
    }

    public List<Object> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Object> checklists) {
        this.checklists = checklists;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Object getDueDate() {
        return dueDate;
    }

    public void setDueDate(Object dueDate) {
        this.dueDate = dueDate;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public Object getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(Object timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public int getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(int time_spent) {
        this.time_spent = time_spent;
    }

    public List<Object> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<Object> customFields) {
        this.customFields = customFields;
    }

    public List<Object> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Object> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Object> getLinkedTasks() {
        return linkedTasks;
    }

    public void setLinkedTasks(List<Object> linkedTasks) {
        this.linkedTasks = linkedTasks;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getIdentifier() {
        return id;
    }

    @Override
    public String getRequiredField() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }

    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> baseMap) {
        Task taskResponse = (Task) featureResponse;
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("name", taskResponse.getName()), () -> baseMap.get("name"));
        add(() -> valuesMap.put("description", (String) taskResponse.getDescription()),
                () -> baseMap.get("description"));
        add(() -> valuesMap.put("tags[0]", taskResponse.getTags().get(0).getName()), () -> baseMap.get("tags[0]"));
        add(() -> valuesMap.put("status", taskResponse.getStatus().getStatus()), () -> baseMap.get("status"));
        add(() -> valuesMap.put("priority", taskResponse.getPriority().getOrderIndex()), () -> baseMap.get("priority"));
        add(() -> valuesMap.put("due_date", String.valueOf(taskResponse.getDueDate())), () -> baseMap.get("due_date"));
        add(() -> valuesMap.put("time_estimate", taskResponse.getTimeEstimate().toString()),
                () -> baseMap.get("time_estimate"));
        add(() -> valuesMap.put("start_date", (String) taskResponse.getStartDate()), () -> baseMap.get("start_date"));
        add(() -> valuesMap.put("parent", nullToString((String) taskResponse.getParent())),
                () -> baseMap.get("parent"));
        add(() -> valuesMap.put("archived", String.valueOf(taskResponse.isArchived())), () -> baseMap.get("archived"));
        //This values doesn't exist in response body
        add(() -> valuesMap.put("due_date_time", baseMap.get("due_date_time")), () -> baseMap.get("due_date_time"));
        add(() -> valuesMap.put("start_date_time", baseMap.get("start_date_time")),
                () -> baseMap.get("start_date_time"));
        add(() -> valuesMap.put("notify_all", baseMap.get("notify_all")), () -> baseMap.get("notify_all"));
        add(() -> valuesMap.put("Custom fields", baseMap.get("Custom fields")), () -> baseMap.get("Custom fields"));
        return valuesMap;
    }
}
