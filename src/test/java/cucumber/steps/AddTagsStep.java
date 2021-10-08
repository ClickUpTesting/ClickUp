/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.steps;

import clickup.requests.TagsRequest;
import clickup.utils.ScenarioContext;
import io.cucumber.java.en.When;
import java.util.LinkedList;

public class AddTagsStep {
    private TagsRequest tagsRequest;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public AddTagsStep() {
        this.tagsRequest = new TagsRequest();
    }

    @When("I add the amount of {int} to the total of tags")
    public void tagsBulkAdd(int amount) {
        LinkedList<String> tagsTrashList = new LinkedList<>();
        String tagName = "tag00";
        for (int i = 0; i < amount; i++) {
            tagName = tagName + i;
            tagsRequest.createTag(tagName);
            tagsTrashList.addLast(tagName);
        }
        scenarioContext.setTrash("Tags", tagsTrashList);
    }
}
