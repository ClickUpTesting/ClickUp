/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.Tasks;

import clickup.entities.Checklists;
import clickup.entities.Assignee;
import clickup.entities.WatchersItem;
import clickup.entities.Project;
import clickup.entities.Space;
import clickup.entities.Creator;
import clickup.entities.Priority;
import clickup.entities.Status;
import clickup.entities.features.IFeature;
import clickup.entities.features.folders.Folder;
import clickup.entities.features.lists.Lisst;
import clickup.entities.features.tags.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task implements IFeature {
    private String id;
    private List<Checklists> checklists;
    private Object parent;
    @JsonProperty("date_updated")
    private String dateUpdated;
    @JsonProperty("text_content")
    private String textContent;
    private String description;
    private List<Assignee> assignees;
    private List<WatchersItem> watchers;
    private Project project;
    @JsonProperty("team_id")
    private String teamId;
    private Space space;
    private Object points;
    @JsonProperty("time_spent")
    private int timeSpent;
    private boolean archived;
    @JsonProperty("date_closed")
    private String dateClosed;
    @JsonProperty("start_date")
    private String startDate;
    private Creator creator;
    @JsonProperty("orderindex")
    private String orderIndex;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("custom_fields")
    private List<Object> customFields;
    @JsonProperty("custom_id")
    private Object customId;
    @JsonProperty("due_date")
    private String dueDate;
    private Priority priority;
    @JsonProperty("list")
    private Lisst lisst;
    private String url;
    private List<Tag> tags;
    private List<Object> dependencies;
    @JsonProperty("time_estimate")
    private int timeEstimate;
    @JsonProperty("permission_level")
    private String permissionLevel;
    @JsonProperty("linked_tasks")
    private List<Object> linkedTasks;
    private Folder folder;
    private String name;
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Checklists> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Checklists> checklists) {
        this.checklists = checklists;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }

    public List<WatchersItem> getWatchers() {
        return watchers;
    }

    public void setWatchers(List<WatchersItem> watchers) {
        this.watchers = watchers;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
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

    public List<Object> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<Object> customFields) {
        this.customFields = customFields;
    }

    public Object getCustomId() {
        return customId;
    }

    public void setCustomId(Object customId) {
        this.customId = customId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Lisst getList() {
        return lisst;
    }

    public void setList(Lisst list) {
        this.lisst = list;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Object> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Object> dependencies) {
        this.dependencies = dependencies;
    }

    public int getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(int timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public List<Object> getLinkedTasks() {
        return linkedTasks;
    }

    public void setLinkedTasks(List<Object> linkedTasks) {
        this.linkedTasks = linkedTasks;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
