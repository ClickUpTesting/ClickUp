/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.webhooks;

import clickup.entities.Health;
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
public class WebHook implements IFeature {

    private String id;
    @JsonProperty("userid")
    private int userId;
    @JsonProperty("team_id")
    private int teamId;
    private String endpoint;
    @JsonProperty("client_id")
    private String clientId;
    private List<String> events;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("list_id")
    private String listId;
    @JsonProperty("folder_id")
    private String folderId;
    @JsonProperty("space_id")
    private String spaceId;
    private Health health;
    private String secret;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * Gets identifier of feature
     *
     * @return a string with value of identifier
     * @author Gustavo Huanca
     */
    @Override
    public String getIdentifier() {
        return id;
    }

    /**
     * Gets string with required field to create a feature in JSON format.
     *
     * @return a string in JSON format
     * @author Gustavo Huanca
     */
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
     * @author Jorge Caceres
     */
    @Override
    public Map<String, String> getMatchedValues(IFeature featureResponse, Map<String, String> baseMap) {
        WebHook webHook = (WebHook) featureResponse;
        System.out.println(webHook.getEvents().toString());
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("endpoint", webHook.getEndpoint()), () -> baseMap.get("endpoint"));
        for (int i = 0; i < baseMap.size(); i++) {
            int finalI = i;
            add(() -> valuesMap.put("events[" + finalI + "]",
                    baseMap.get("events[" + finalI + "]")), () -> baseMap.get("events[" + finalI + "]"));
        }
        return valuesMap;
    }
}
