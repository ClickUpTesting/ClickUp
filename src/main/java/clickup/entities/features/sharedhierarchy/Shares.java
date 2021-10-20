/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities.features.sharedhierarchy;

import clickup.entities.features.IFeature;
import clickup.entities.features.IGetAllFeatures;

import java.util.Map;

public class Shares implements IGetAllFeatures, IFeature {

    private Shared shared;

    public void setShared(Shared shared) {
        this.shared = shared;
    }

    public Shared getShared() {
        return shared;
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public String getRequiredField() {
        return null;
    }

    @Override
    public void setDefaultValues() {

    }

    @Override
    public Map<String, String> matchesValues(IFeature featureResponse, Map<String, String> body) {
        return null;
    }

    @Override
    public int getAmount() {
        return 0;
    }
}
