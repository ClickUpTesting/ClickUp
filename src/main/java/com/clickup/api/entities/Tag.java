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
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "tag_fg",
        "tag_bg",
        "creator"
})
public class Tag {

    @JsonProperty("name")
    private String name;
    @JsonProperty("tag_fg")
    private String tagFg;
    @JsonProperty("tag_bg")
    private String tagBg;
    @JsonProperty("creator")
    private Object creator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("tag_fg")
    public String getTagFg() {
        return tagFg;
    }

    @JsonProperty("tag_fg")
    public void setTagFg(String tagFg) {
        this.tagFg = tagFg;
    }

    @JsonProperty("tag_bg")
    public String getTagBg() {
        return tagBg;
    }

    @JsonProperty("tag_bg")
    public void setTagBg(String tagBg) {
        this.tagBg = tagBg;
    }

    @JsonProperty("creator")
    public Object getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(Object creator) {
        this.creator = creator;
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
