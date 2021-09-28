/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities;

public class FeatureFactory {
    /**
     * Creates a feature given a name.
     *
     * @param featureName a String with the required feature type
     * @return the corresponding feature
     * @author Raymundo Guaraguara
     */
    public IFeatures getFeature(String featureName) {
        if (featureName.equalsIgnoreCase("Goal")) {
            return new Goal();
        } else if (featureName.equalsIgnoreCase("Goals")) {
            return new Goals();
        }
        if (featureName.equalsIgnoreCase("List")) {
            return new Lisst();
        }
        return null;
    }
}
