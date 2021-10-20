/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.tags;

import clickup.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

import static core.api.ApiRequestSpecificationProvider.add;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag implements IFeature {
    @JsonProperty("name")
    private String name;
    @JsonProperty("tag_fg")
    private String tagFg;
    @JsonProperty("tag_bg")
    private String tagBg;
    private Integer creator;

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

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

    @Override
    public String getIdentifier() {
        return name;
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
     * @author Jorge Caceres
     */
    public Map<String, String> getMapOfValues(final Map<String, String> baseMap) {
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("name", this.getName()), () -> baseMap.get("name"));
        add(() -> valuesMap.put("tag_fg", this.getTagFg()), () -> baseMap.get("tag_fg"));
        add(() -> valuesMap.put("tag_bg", this.getTagBg()), () -> baseMap.get("tag_bg"));
        return  valuesMap;
    }

    @Override
    public Map<String, String> matchesValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }
}
