/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.hooks;

import clickup.Endpoints;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.request.Header;
import core.utils.Context;
import io.cucumber.java.After;

public class ListHooks {
    private ApiRequest apiRequest;
    private ApiResponse apiResponse = new ApiResponse();
    private Context context;
    private final String TOKEN = "pk_18915744_BBOVH8SIAV8XZZA3W06NS6PSY8WZI7LJ";

    public ListHooks(Context context) {
        this.context = context;
    }

    /**
     * Sets base of request.
     *
     * @return ApiRequestBuilder contains base request
     */
    private ApiRequestBuilder baseRequest() {
        return new ApiRequestBuilder()
                .baseUri(Endpoints.URL_BASE.getEndpoint())
                .headers(Header.AUTHORIZATION.getValue(), TOKEN)
                .headers(Header.CONTENT_TYPE.getValue(), Header.APPLICATION_JSON.getValue());
    }

    @After(value = "@CreateList", order = 1)
    public void deleteList() {
        apiRequest = baseRequest()
                .method(ApiMethod.DELETE)
                .endpoint(Endpoints.GET_LIST.getEndpoint())
                .pathParams("list_id", context.getPathParamsStep().get("list_id"))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
    }
}
