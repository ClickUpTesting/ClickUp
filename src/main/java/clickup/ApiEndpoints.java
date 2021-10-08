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
    CREATE_TASK("/list/{list_id}/task"),
    DELETE_TASK("/task/{task_id}"),
    CREATE_CHECKLIST("/task/{task_id}/checklist"),
    UPDATE_CHECKLIST("/checklist/{checklist_id}"),
    DELETE_CHECKLIST("/checklist/{checklist_id}"),
    GET_FOLDER("/folder/{folder_id}"),
    GET_FOLDERS("/space/{space_id}/folder"),
    DELETE_FOLDER("/folder/{folder_id}"),
    DELETE_VIEW("/view/{view_id}");

    private String endpoint;

    ApiEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
