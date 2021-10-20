/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities.features.checklists;

import clickup.entities.features.IFeature;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Checklists implements IFeature {
    private Checklist checklist;

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    @Override
    public String getIdentifier() {
        return checklist.getIdentifier();
    }

    @Override
    public String getRequiredField() {
        return checklist.getRequiredField();
    }

    @Override
    public void setDefaultValues() {

    }

    @Override
    public Map<String, String> matchesValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }
}
