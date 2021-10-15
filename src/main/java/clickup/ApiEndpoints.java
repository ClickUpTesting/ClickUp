/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup;

public enum ApiEndpoints {
    URL_BASE("https://api.clickup.com/api/v2"),
    CREATE_SPACE("/team/{team_id}/space"),
    CREATE_FOLDER_IN_SPACE("/space/{space_id}/folder"),
    GET_SPACE("/space/{space_id}"),
    LIST_IN_FOLDER("/folder/{folder_id}/list"),
    FOLDER_LESS_LIST("/space/{space_id}/list"),
    LIST_IN_SPACE("/space/{space_id}/list"),
    GET_LIST("/list/{list_id}"),
    GET_TAG("/space/{space_id}/tag"),
    CREATE_TAG("/space/{space_id}/tag"),
    DELETE_TAG("/space/{space_id}/tag/{tag_name}"),
    ADD_TAG_TO_TASK("/task/{task_id}/tag/{tag_name}"),
    REMOVE_TAG_FROM_TASK("/task/{task_id}/tag/{tag_name}"),
    ADD_DEPENDENCY("/task/{task_id}/dependency"),
    CREATE_TASK("/list/{list_id}/task"),
    DELETE_TASK("/task/{task_id}"),
    GET_TASK("/task/{task_id}"),
    GET_TASKS("/list/{list_id}/task"),
    CREATE_CHECKLIST("/task/{task_id}/checklist"),
    DELETE_CHECKLIST("/checklist/{checklist_id}"),
    CREATE_CHECKLIST_ITEM("/checklist/{checklist_id}/checklist_item"),
    DELETE_CHECKLIST_ITEM("/checklist/{checklist_id}/checklist_item/{checklist_item_id}"),
    GET_FOLDER("/folder/{folder_id}"),
    GET_FOLDERS("/space/{space_id}/folder"),
    DELETE_FOLDER("/folder/{folder_id}"),
    DELETE_VIEW("/view/{view_id}"),
    CREATE_TEAM_VIEW("/team/{team_id}/view"),
    CREATE_SPACE_VIEW("/space/{space_id}/view"),
    CREATE_FOLDER_VIEW("/folder/{folder_id}/view"),
    CREATE_LIST_VIEW("/list/{list_id}/view"),
    GET_TEAM_VIEWS("/team/{team_id}/view"),
    GET_SPACE_VIEWS("/space/{space_id}/view"),
    GET_FOLDER_VIEWS("/folder/{folder_id}/view"),
    GET_LIST_VIEWS("/list/{list_id}/view"),
    CREATE_LIST_COMMENT("/list/{list_id}/comment"),
    DELETE_COMMENT("/comment/{comment_id}"),
    GET_TASK_COMMENTS("/task/{task_id}/comment"),
    GET_CHAT_VIEW_COMMENTS("/view/{view_id}/comment"),
    GET_LIST_COMMENTS("/list/{list_id}/comment");

    private String endpoint;

    ApiEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
