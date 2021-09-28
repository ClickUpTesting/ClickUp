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
    public Features getFeature(final String featureName) throws IllegalAccessException {
        String feature = featureName.toLowerCase();
        switch (feature) {
            case "goal":
                return new Goal();
            case "goals":
                return new Goals();
            case "tags":
                return new Tags();
            default:
                throw new IllegalAccessException("Feature Not Found");
        }
    }
}
