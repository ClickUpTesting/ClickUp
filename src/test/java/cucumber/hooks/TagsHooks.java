/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.hooks;

import clickup.requests.TagsRequest;
import clickup.utils.ScenarioTrash;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TagsHooks {
    private TagsRequest tagsRequest;
    private ScenarioTrash scenarioTrash;


    public TagsHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.tagsRequest = new TagsRequest();
    }

    @Before(value = "@CreateTag")
    public void createTag() {
        String tagName = "deleteMe";
        tagsRequest.createTag(tagName);
        scenarioTrash.setScenarioTrash("tag_name", tagName);
    }

    @After(value = "@DeleteTag")
    public void deleteTag() {
        tagsRequest.deleteTag(scenarioTrash.getTrashValue("tag_name"));
    }

    @After(value = "@DeleteTagsList")
    public void deleteTagsList() {
        tagsRequest.deleteTagsList();
    }

}
