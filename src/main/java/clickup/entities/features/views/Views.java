/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities.features.views;

import clickup.entities.features.IFeature;
import clickup.entities.features.IGetAllFeatures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.api.ApiRequestSpecificationProvider.add;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Views implements IFeature, IGetAllFeatures {
    @JsonProperty("view")
    private View view;
    @JsonProperty("views")
    private List<View> views;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }

    @Override
    public String getIdentifier() {
        return view.getId();
    }

    @Override
    public String getRequiredField() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }

    @Override
    public int getAmount() {
        return views.size();
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
        Views viewsResponse = (Views) featureResponse;
        Map<String, String> valuesMap = new HashMap<>();
        add(() -> valuesMap.put("name", viewsResponse.getView().getName()), () -> baseMap.get("name"));
        add(() -> valuesMap.put("type", viewsResponse.getView().getType()), () -> baseMap.get("type"));
        return valuesMap;
    }
}
