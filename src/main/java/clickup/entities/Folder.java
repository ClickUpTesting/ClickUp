/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Folder {
    private boolean access;
    private boolean archived;
    @JsonProperty("permission_level")
    private String permissionLevel;
    private int orderindex;
    private boolean hidden;
    private List<Lisst> lists;
    private String name;
    private List<Status> statuses;
    private String id;
    private Space space;
    @JsonProperty("override_statuses")
    private boolean overrideStatuses;
    private String taskCount;

    public boolean isAccess() {
        return access;
    }

    public void setAccess(final boolean access) {
        this.access = access;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(final boolean archived) {
        this.archived = archived;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(final String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public int getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(final int orderindex) {
        this.orderindex = orderindex;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(final boolean hidden) {
        this.hidden = hidden;
    }

    public List<Lisst> getLists() {
        return lists;
    }

    public void setLists(final List<Lisst> lists) {
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(final List<Status> statuses) {
        this.statuses = statuses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(final Space space) {
        this.space = space;
    }

    public boolean isOverrideStatuses() {
        return overrideStatuses;
    }

    public void setOverrideStatuses(final boolean overrideStatuses) {
        this.overrideStatuses = overrideStatuses;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(final String taskCount) {
        this.taskCount = taskCount;
    }
}
