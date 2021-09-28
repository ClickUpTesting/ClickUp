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

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Space {
    private IFeatures features;
    private boolean archived;
    private boolean jsonMemberPrivate;
    private String name;
    private List<StatusesItem> statuses;
    private String id;
    private boolean multipleAssignees;

    public void setFeatures(IFeatures features){
        this.features = features;
    }

    public IFeatures getFeatures(){
        return features;
    }

    public void setArchived(boolean archived){
        this.archived = archived;
    }

    public boolean isArchived(){
        return archived;
    }

    public void setJsonMemberPrivate(boolean jsonMemberPrivate){
        this.jsonMemberPrivate = jsonMemberPrivate;
    }

    public boolean isJsonMemberPrivate(){
        return jsonMemberPrivate;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setStatuses(List<StatusesItem> statuses){
        this.statuses = statuses;
    }

    public List<StatusesItem> getStatuses(){
        return statuses;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setMultipleAssignees(boolean multipleAssignees){
        this.multipleAssignees = multipleAssignees;
    }

    public boolean isMultipleAssignees(){
        return multipleAssignees;
    }
}
