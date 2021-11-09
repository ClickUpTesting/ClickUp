/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.api.hooks;

import clickup.api.requests.TagsRequest;
import clickup.api.requests.TasksRequests;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.Locale;

import static core.utils.RandomCustom.generateFourRandom;

public class TagsHooks {
    private TagsRequest tagsRequest;
    private ScenarioTrash scenarioTrash;
    TasksRequests tasksRequests = new TasksRequests();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public TagsHooks(ScenarioTrash scenarioTrash) {
        this.scenarioTrash = scenarioTrash;
        this.tagsRequest = new TagsRequest();
    }

    @Before(value = "@CreateTag")
    public void createTag() {
        String tagName = "tag".concat(generateFourRandom()).toLowerCase(Locale.ROOT);
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

    @Before(value = "@AddTagToTask")
    public void addTagToTask() throws JsonProcessingException {
        String tagName = "tag".concat(generateFourRandom()).toLowerCase(Locale.ROOT);
        tagsRequest.createTag(tagName);
        scenarioTrash.setScenarioTrash("tag_name", tagName);
        scenarioTrash.setScenarioTrash("task_id", tasksRequests.createTask());
        tagsRequest
                .addTagToTask(scenarioTrash.getTrashValue("tag_name"), scenarioTrash.getTrashValue("task_id"));
    }

    @After(value = "@RemoveTagFromTask")
    public void removeTagFromTask() {
        tagsRequest.removeTagFromTask(scenarioTrash.getTrashValue("tag_name"));
        tasksRequests.getTask(scenarioContext.getEnvData("task_id"));
        tagsRequest.deleteTag(scenarioTrash.getTrashValue("tag_name"));
        tasksRequests.getTask(scenarioContext.getEnvData("task_id"));
    }
}
