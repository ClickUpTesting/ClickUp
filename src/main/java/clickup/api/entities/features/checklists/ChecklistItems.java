/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.api.entities.features.checklists;

import clickup.api.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.utils.SpecificationProvider.add;

public class ChecklistItems implements IFeature {
    private String id;
    private String name;
    @JsonProperty("orderindex")
    private int orderIndex;
    private String assignee;
    @JsonProperty("group_assignee")
    private String groupAssignee;
    private Boolean resolved;
    private String parent;
    @JsonProperty("date_created")
    private String dateCreated;
    private List<Object> children;

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

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getGroupAssignee() {
        return groupAssignee;
    }

    public void setGroupAssignee(String groupAssignee) {
        this.groupAssignee = groupAssignee;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
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

    /**
     * Creates a map with the values set on the scenario.
     *
     * @param body with the fields set on the scenario
     * @return valuesMap corresponding feature
     * @author Jorge Caceres
     */
    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> body) {
        ChecklistItems checklistItems = (ChecklistItems) featureResponse;
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("name", checklistItems.getName()), () -> body.get("name"));
        return valuesMap;
    }
}
