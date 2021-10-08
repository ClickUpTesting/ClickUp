/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.requests;

import clickup.api.ApiFacade;
import clickup.utils.ScenarioContext;
import core.api.ApiHeaders;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;

public abstract class BaseRequest {

    private final String TOKEN = System.getenv("API_TOKEN");
    protected String teamId = System.getenv("TEAM_ID");
    protected ApiRequestBuilder apiRequestBuilder;
    protected ApiResponse apiResponse;
    protected ApiFacade apiFacade = new ApiFacade();
    protected ScenarioContext scenarioContext = ScenarioContext.getInstance();

    /**
     * Sets base request.
     */
    public BaseRequest() {
        this.apiRequestBuilder = new ApiRequestBuilder();
        this.apiResponse = new ApiResponse();
        setBaseRequest();
    }

    /**
     * Sets base headers.
     *
     * @author Jorge Caceres
     */
    protected void setBaseRequest() {
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), TOKEN)
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }
}
