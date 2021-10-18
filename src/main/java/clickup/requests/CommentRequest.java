/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.features.comment.Comment;
import clickup.entities.features.spaces.Space;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static core.utils.RandomCustom.random;

public class CommentRequest extends BaseRequest {

    /**
     * Creates a comment and returns its identifier.
     *
     * @return a comment_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Gustavo Huanca
     */
    public String createCommentInList() throws JsonProcessingException {
        Comment comment = new Comment();
        comment.setCommentText("Comment in List".concat(random()));
        apiResponse = apiFacade.createObject(new ObjectMapper().writeValueAsString(comment),
                ApiEndpoints.CREATE_LIST_COMMENT, "list_id", scenarioContext.getEnvData("list_id"));
        return apiResponse.getBody(Space.class).getId();
    }

    /**
     * Deletes a comment.
     *
     * @param id comment_id
     * @author Gustavo Huanca
     */
    public void deleteComment(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_COMMENT, "comment_id", id);
    }
}
