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
import java.util.List;
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
        "name",
        "orderindex",
        "content",
        "status",
        "priority",
        "assignee",
        "task_count",
        "due_date",
        "due_date_time",
        "start_date",
        "start_date_time",
        "folder",
        "space",
        "statuses",
        "inbound_address"
})
public class Lisst implements ObjectToString {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("orderindex")
    private Integer orderindex;
    @JsonProperty("content")
    private String content;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("assignee")
    private Object assignee;
    @JsonProperty("task_count")
    private Object taskCount;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("due_date_time")
    private Boolean dueDateTime;
    @JsonProperty("start_date")
    private Object startDate;
    @JsonProperty("start_date_time")
    private Object startDateTime;
    @JsonProperty("folder")
    private Folder folder;
    @JsonProperty("space")
    private Space space;
    @JsonProperty("statuses")
    private List<Status> statuses = null;
    @JsonProperty("inbound_address")
    private String inboundAddress;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("orderindex")
    public Integer getOrderindex() {
        return orderindex;
    }

    @JsonProperty("orderindex")
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("priority")
    public Priority getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @JsonProperty("assignee")
    public Object getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(Object assignee) {
        this.assignee = assignee;
    }

    @JsonProperty("task_count")
    public Object getTaskCount() {
        return taskCount;
    }

    @JsonProperty("task_count")
    public void setTaskCount(Object taskCount) {
        this.taskCount = taskCount;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due_date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("due_date_time")
    public Boolean getDueDateTime() {
        return dueDateTime;
    }

    @JsonProperty("due_date_time")
    public void setDueDateTime(Boolean dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    @JsonProperty("start_date")
    public Object getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("start_date_time")
    public Object getStartDateTime() {
        return startDateTime;
    }

    @JsonProperty("start_date_time")
    public void setStartDateTime(Object startDateTime) {
        this.startDateTime = startDateTime;
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

    @JsonProperty("statuses")
    public List<Status> getStatuses() {
        return statuses;
    }

    @JsonProperty("statuses")
    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    @JsonProperty("inbound_address")
    public String getInboundAddress() {
        return inboundAddress;
    }

    @JsonProperty("inbound_address")
    public void setInboundAddress(String inboundAddress) {
        this.inboundAddress = inboundAddress;
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
