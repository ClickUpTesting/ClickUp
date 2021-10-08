/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.requests;

import clickup.ApiEndpoints;
import core.api.ApiRequest;

public class ViewsRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Deletes a view.
     *
     * @param id the view id to be deleted
     * @author Raymundo GuaraGuara
     */
    public void deleteView(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_VIEW, "view_id", id);
    }
}
