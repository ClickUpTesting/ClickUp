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

public enum Endpoints {
    URL_BASE("https://api.clickup.com/api/v2"),
    CREATE_SPACE("/team/{team_id}/space"),
    CREATE_FOLDER_IN_SPACE("/space/{space_id}/folder"),
    GET_SPACE("/space/{space_id}"),
    LIST_IN_FOLDER("/folder/{folder_id}/list"),
    LIST("/list/{list_id}"),
    CREATE_GOAL("/team/{TeamId}/goal");

    private String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}