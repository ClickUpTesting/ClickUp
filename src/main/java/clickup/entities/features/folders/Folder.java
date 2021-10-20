/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Cristian Choque
 */

package clickup.entities.features.folders;

import clickup.entities.features.IFeature;
import clickup.entities.features.lists.Lisst;
import clickup.entities.features.spaces.Space;
import clickup.entities.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.api.ApiRequestSpecificationProvider.add;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Folder implements IFeature {
    private String id;
    private String name;
    @JsonProperty("orderindex")
    private Integer orderIndex;
    @JsonProperty("override_statuses")
    private Boolean overrideStatuses;
    private Boolean hidden;
    private Space space;
    @JsonProperty("task_count")
    private String taskCount;
    private Boolean archived;
    private List<Status> statuses;
    private List<Lisst> lists;
    @JsonProperty("permission_level")
    private String permissionLevel;

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

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Boolean getOverrideStatuses() {
        return overrideStatuses;
    }

    public void setOverrideStatuses(Boolean overrideStatuses) {
        this.overrideStatuses = overrideStatuses;
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

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public List<Lisst> getLists() {
        return lists;
    }

    public void setLists(List<Lisst> lists) {
        this.lists = lists;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
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
    public String toString() {
        return "Folder{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", orderIndex=" + orderIndex
                + ", overrideStatuses=" + overrideStatuses
                + ", hidden=" + hidden
                + ", space=" + space
                + ", taskCount='" + taskCount + '\''
                + ", archived=" + archived
                + ", statuses=" + statuses
                + ", lists=" + lists
                + ", permissionLevel='" + permissionLevel + '\''
                + '}';
    }

    @Override
    public void setDefaultValues() {
        Status toDoStatus = new Status("p12971248_vjPS6rbE", "to do", 0, "#d3d3d3", "open");
        Status completeStatus = new Status("p12971248_2Uv0jXRR", "complete", 1, "#6bc950", "closed");
        statuses.add(toDoStatus);
        statuses.add(completeStatus);
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
        Folder folder = (Folder) featureResponse;
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("name", folder.getName()), () -> baseMap.get("name"));
        return valuesMap;
    }
}
