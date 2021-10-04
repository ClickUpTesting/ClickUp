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

import clickup.entities.Space;
import clickup.entities.Status;
import clickup.entities.features.folders.Folder;
import clickup.entities.features.tags.Tag;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TasksResponse {
    public String id;
    public Object custom_id;
    public String name;
    public Object text_content;
    public Object description;
    public Status status;
    public String orderindex;
    public String date_created;
    public String date_updated;
    public Object date_closed;
    public boolean archived;
    public Object creator;
    public List<Object> assignees;
    public List<Object> watchers;
    public List<Object> checklists;
    public List<Tag> tags;
    public Object parent;
    public Object priority;
    public Object due_date;
    public Object start_date;
    public Object points;
    public Object time_estimate;
    public int time_spent;
    public List<Object> custom_fields;
    public List<Object> dependencies;
    public List<Object> linked_tasks;
    public String team_id;
    public String url;
    public String permission_level;
    public Object list;
    public Object project;
    public Folder folder;
    public Space space;

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

    public String getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(String orderindex) {
        this.orderindex = orderindex;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public Object getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(Object date_closed) {
        this.date_closed = date_closed;
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

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Object getDue_date() {
        return due_date;
    }

    public void setDue_date(Object due_date) {
        this.due_date = due_date;
    }

    public Object getStart_date() {
        return start_date;
    }

    public void setStart_date(Object start_date) {
        this.start_date = start_date;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public Object getTime_estimate() {
        return time_estimate;
    }

    public void setTime_estimate(Object time_estimate) {
        this.time_estimate = time_estimate;
    }

    public int getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(int time_spent) {
        this.time_spent = time_spent;
    }

    public List<Object> getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(List<Object> custom_fields) {
        this.custom_fields = custom_fields;
    }

    public List<Object> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Object> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Object> getLinked_tasks() {
        return linked_tasks;
    }

    public void setLinked_tasks(List<Object> linked_tasks) {
        this.linked_tasks = linked_tasks;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
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
}
