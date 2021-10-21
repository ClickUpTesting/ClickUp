/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities.features.spaces;

import clickup.entities.Features;
import clickup.entities.StatusesItem;
import clickup.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.api.ApiRequestSpecificationProvider.add;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Space implements IFeature {
    public Features features;
    public boolean archived;
    public boolean jsonMemberPrivate;
    public String name;
    public List<StatusesItem> statuses;
    @JsonProperty("id")
    public String id;
    @JsonProperty("multiple_assignees")
    public boolean multipleAssignees;
    @JsonProperty("private")
    public boolean privatee;

    public void setPrivatee(final boolean privatee) {
        this.privatee = privatee;
    }

    public boolean isPrivatee() {
        return privatee;
    }

    public void setFeatures(final Features features) {
        this.features = features;
    }

    public Features getFeatures() {
        return features;
    }

    public void setArchived(final boolean archived) {
        this.archived = archived;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setJsonMemberPrivate(final boolean jsonMemberPrivate) {
        this.jsonMemberPrivate = jsonMemberPrivate;
    }

    public boolean isJsonMemberPrivate() {
        return jsonMemberPrivate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatuses(final List<StatusesItem> statuses) {
        this.statuses = statuses;
    }

    public List<StatusesItem> getStatuses() {
        return statuses;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMultipleAssignees(final boolean multipleAssignees) {
        this.multipleAssignees = multipleAssignees;
    }

    public boolean isMultipleAssignees() {
        return multipleAssignees;
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
     * @param baseMap with the fields set on the scenario
     * @return valuesMap corresponding feature
     * @author Gustavo Huanca
     */
    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> baseMap) {
        Space space = (Space) featureResponse;
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("name", space.getName()), () -> baseMap.get("name"));
        return valuesMap;
    }
}
