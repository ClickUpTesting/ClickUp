/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.linkedtasks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

import static core.api.ApiRequestSpecificationProvider.add;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LinkedTask {

    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("link_id")
    private String linkId;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("userid")
    private String userId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Creates a map with the values set on the scenario.
     *
     * @param baseMap with the fields set on the scenario
     * @return valuesMap corresponding feature
     * @author Jorge Caceres
     */
    public Map<String, String> getMapOfValues(final Map<String, String> baseMap) {
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("task_id", this.getTaskId()), () -> baseMap.get("task_id"));
        add(() -> valuesMap.put("links_to", this.getLinkId()), () -> baseMap.get("links_to"));
        return  valuesMap;
    }
}

