/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.api.hooks;

import clickup.api.requests.CommentRequest;
import clickup.utils.ScenarioTrash;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommentHooks {

    private CommentRequest commentRequest;
    private ScenarioTrash scenarioTrash;

    public CommentHooks(ScenarioTrash scenarioTrash) {
        this.commentRequest = new CommentRequest();
        this.scenarioTrash = scenarioTrash;
    }

    @Before(value = "@CreateCommentInList")
    public void createCommentInList() throws JsonProcessingException {
        scenarioTrash.setScenarioTrash("comment_id", commentRequest.createCommentInList());
    }

    @After(value = "@DeleteComment")
    public void deleteList() {
        commentRequest.deleteComment(scenarioTrash.getTrashValue("comment_id"));
    }
}
