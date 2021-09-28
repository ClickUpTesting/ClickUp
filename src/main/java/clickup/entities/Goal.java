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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Goal implements IFeatures {
    private String id;
    @JsonProperty("pretty_id")
    private String prettyId;
    private String name;
    @JsonProperty("team_id")
    private String teamId;
    private Integer creator;
    private String color;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("due_date")
    private String dueDate;
    private String description;
    @JsonProperty("private")
    private Boolean is_private;
    private Boolean archived;
    @JsonProperty("multiple_owners")
    private Boolean multipleOwners;
    @JsonProperty("editor_token")
    private String editorToken;
    @JsonProperty("date_updated")
    private String dateUpdated;
    @JsonProperty("folder_id")
    private Object folderId;
    @JsonProperty("folder_name")
    private Object folderName;
    @JsonProperty("editor_expiration")
    private Long editorExpiration;
    private List<Object> members;
    @JsonProperty("group_members")
    private List<Object> groupMembers;
    private List<Owner> owners;
    @JsonProperty("key_results")
    private List<KeyResult> keyResults;
    @JsonProperty("percent_completed")
    private Double percentCompleted;
    private List<History> history;
    @JsonProperty("pretty_url")
    private String prettyUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrettyId() {
        return prettyId;
    }

    public void setPrettyId(String prettyId) {
        this.prettyId = prettyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getMultipleOwners() {
        return multipleOwners;
    }

    public void setMultipleOwners(Boolean multipleOwners) {
        this.multipleOwners = multipleOwners;
    }

    public String getEditorToken() {
        return editorToken;
    }

    public void setEditorToken(String editorToken) {
        this.editorToken = editorToken;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Object getFolderId() {
        return folderId;
    }

    public void setFolderId(Object folderId) {
        this.folderId = folderId;
    }

    public Object getFolderName() {
        return folderName;
    }

    public void setFolderName(Object folderName) {
        this.folderName = folderName;
    }

    public Long getEditorExpiration() {
        return editorExpiration;
    }

    public void setEditorExpiration(Long editorExpiration) {
        this.editorExpiration = editorExpiration;
    }

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    public List<Object> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<Object> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }

    public Double getPercentCompleted() {
        return percentCompleted;
    }

    public void setPercentCompleted(Double percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public String getPrettyUrl() {
        return prettyUrl;
    }

    public void setPrettyUrl(String prettyUrl) {
        this.prettyUrl = prettyUrl;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id='" + id + '\'' +
                ", prettyId='" + prettyId + '\'' +
                ", name='" + name + '\'' +
                ", teamId='" + teamId + '\'' +
                ", creator=" + creator +
                ", color='" + color + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", startDate='" + startDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", description='" + description + '\'' +
                ", is_private=" + is_private +
                ", archived=" + archived +
                ", multipleOwners=" + multipleOwners +
                ", editorToken='" + editorToken + '\'' +
                ", dateUpdated='" + dateUpdated + '\'' +
                ", folderId=" + folderId +
                ", folderName=" + folderName +
                ", editorExpiration=" + editorExpiration +
                ", members=" + members +
                ", groupMembers=" + groupMembers +
                ", owners=" + owners +
                ", keyResults=" + keyResults +
                ", percentCompleted=" + percentCompleted +
                ", history=" + history +
                ", prettyUrl='" + prettyUrl + '\'' +
                '}';
    }

    @Override
    public String getIdentifier() {
        return id;
    }
}
