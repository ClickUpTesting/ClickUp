package clickup.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Folder implements Features{
    public String id;
    public String name;
    public Integer orderindex;
    public Boolean override_statuses;
    public Boolean hidden;
    public Space space;
    public String task_count;
    public Boolean archived = false;
    public List<Object> statuses;
    public List<Object> lists;
    public String permission_level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public Boolean getOverride_statuses() {
        return override_statuses;
    }

    public void setOverride_statuses(Boolean override_statuses) {
        this.override_statuses = override_statuses;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public String getTask_count() {
        return task_count;
    }

    public void setTask_count(String task_count) {
        this.task_count = task_count;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public List<Object> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Object> statuses) {
        this.statuses = statuses;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }
}

