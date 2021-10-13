/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities.features;

import clickup.entities.features.spaces.Space;
import clickup.entities.features.checklists.ChecklistItems;
import clickup.entities.features.comment.Comment;
import clickup.entities.features.tasks.Task;
import clickup.entities.features.checklists.Checklists;
import clickup.entities.features.folders.Folder;
import clickup.entities.features.lists.Lisst;
import clickup.entities.features.tags.Tags;
import clickup.entities.features.tasks.Tasks;
import clickup.entities.features.views.Views;

public class FeatureFactory {

    /**
     * Creates a feature given a name.
     *
     * @param featureName a String with the required feature type
     * @return the corresponding feature
     * @author Raymundo Guaraguara
     */
    public IFeature getFeature(final String featureName) throws IllegalAccessException {
        String feature = featureName.toLowerCase();
        switch (feature) {
            case "tags":
                return new Tags();
            case "list":
                return new Lisst();
            case "folder":
                return new Folder();
            case "task":
                return new Task();
            case "tasks":
                return new Tasks();
            case "checklist":
                return new Checklists();
            case "checklistItem":
                return new ChecklistItems();
            case "comment":
                return new Comment();
            case "views":
                return new Views();
            case "space":
                return new Space();
            default:
                throw new IllegalAccessException("Feature Not Found");
        }
    }
}
