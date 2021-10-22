/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.api.entities.features;

import clickup.api.entities.features.sharedhierarchy.Shares;
import clickup.api.entities.features.spaces.Space;
import clickup.api.entities.features.checklists.ChecklistItems;
import clickup.api.entities.features.comment.Comment;
import clickup.api.entities.features.tasks.Task;
import clickup.api.entities.features.checklists.Checklists;
import clickup.api.entities.features.folders.Folder;
import clickup.api.entities.features.lists.Lisst;
import clickup.api.entities.features.tags.Tags;
import clickup.api.entities.features.tasks.Tasks;
import clickup.api.entities.features.views.Views;
import clickup.api.entities.features.webhooks.WebHooks;

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
            case "checklists":
                return new Checklists();
            case "checklistItem":
                return new ChecklistItems();
            case "comment":
                return new Comment();
            case "views":
            case "view":
                return new Views();
            case "space":
                return new Space();
            case "shares":
                return new Shares();
            case "webhooks":
                return new WebHooks();
            default:
                throw new IllegalAccessException("Feature Not Found");
        }
    }
}
