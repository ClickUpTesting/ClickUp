/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities.goals;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KeyResult {
    public String id;
    @JsonProperty("goal_id")
    public String goalId;
    public String name;
    public Integer creator;
    public Object owner;
    public String type;
    @JsonProperty("date_created")
    public String dateCreated;
    @JsonProperty("steps_start")
    public Integer stepsStart;
    @JsonProperty("steps_end")
    public Object stepsEnd;
    @JsonProperty("stepsCurrent")
    public Object steps_current;
    public String unit;
    @JsonProperty("goal_pretty_id")
    public String goalPrettyId;
    @JsonProperty("percent_completed")
    public Double percentCompleted;
    public Boolean completed;
    public List<Owner> owners;
    @JsonProperty("task_ids")
    public List<String> taskIds;
    @JsonProperty("subcategory_ids")
    public List<String> subcategoryIds;
    @JsonProperty("last_action")
    public LastAction lastAction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoalId() {
        return goalId;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getStepsStart() {
        return stepsStart;
    }

    public void setStepsStart(Integer stepsStart) {
        this.stepsStart = stepsStart;
    }

    public Object getStepsEnd() {
        return stepsEnd;
    }

    public void setStepsEnd(Object stepsEnd) {
        this.stepsEnd = stepsEnd;
    }

    public Object getSteps_current() {
        return steps_current;
    }

    public void setSteps_current(Object steps_current) {
        this.steps_current = steps_current;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoalPrettyId() {
        return goalPrettyId;
    }

    public void setGoalPrettyId(String goalPrettyId) {
        this.goalPrettyId = goalPrettyId;
    }

    public Double getPercentCompleted() {
        return percentCompleted;
    }

    public void setPercentCompleted(Double percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    public List<String> getSubcategoryIds() {
        return subcategoryIds;
    }

    public void setSubcategoryIds(List<String> subcategoryIds) {
        this.subcategoryIds = subcategoryIds;
    }

    public LastAction getLastAction() {
        return lastAction;
    }

    public void setLastAction(LastAction lastAction) {
        this.lastAction = lastAction;
    }
}
