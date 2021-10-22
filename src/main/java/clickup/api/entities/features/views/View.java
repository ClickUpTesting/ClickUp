/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.api.entities.features.views;

import clickup.api.entities.Columns;
import clickup.api.entities.Divide;
import clickup.api.entities.Filters;
import clickup.api.entities.Grouping;
import clickup.api.entities.Parent;
import clickup.api.entities.Settings;
import clickup.api.entities.Sorting;
import clickup.api.entities.TeamSidebar;
import clickup.api.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class View implements IFeature {
    private String id;
    private String name;
    private String type;
    private Parent parent;
    private Grouping grouping;
    private Divide divide;
    private Sorting sorting;
    private Filters filters;
    private Columns columns;
    @JsonProperty("team_sidebar")
    private TeamSidebar teamSidebar;
    private Settings settings;
    @JsonProperty("date_created")
    private String dateCreated;
    private int creator;
    private String visibility;
    @JsonProperty("protected")
    private boolean isProtected;
    @JsonProperty("protected_note")
    private Object protectedNote;
    @JsonProperty("protected_by")
    private Object protectedBy;
    @JsonProperty("date_protected")
    private Object dateProtected;
    @JsonProperty("orderindex")
    private int orderIndex;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Grouping getGrouping() {
        return grouping;
    }

    public void setGrouping(Grouping grouping) {
        this.grouping = grouping;
    }

    public Divide getDivide() {
        return divide;
    }

    public void setDivide(Divide divide) {
        this.divide = divide;
    }

    public Sorting getSorting() {
        return sorting;
    }

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public Columns getColumns() {
        return columns;
    }

    public void setColumns(Columns columns) {
        this.columns = columns;
    }

    public TeamSidebar getTeamSidebar() {
        return teamSidebar;
    }

    public void setTeamSidebar(TeamSidebar teamSidebar) {
        this.teamSidebar = teamSidebar;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public Object getProtectedNote() {
        return protectedNote;
    }

    public void setProtectedNote(Object protectedNote) {
        this.protectedNote = protectedNote;
    }

    public Object getProtectedBy() {
        return protectedBy;
    }

    public void setProtectedBy(Object protectedBy) {
        this.protectedBy = protectedBy;
    }

    public Object getDateProtected() {
        return dateProtected;
    }

    public void setDateProtected(Object dateProtected) {
        this.dateProtected = dateProtected;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
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

    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }
}
