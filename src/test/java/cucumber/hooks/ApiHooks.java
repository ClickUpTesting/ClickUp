/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.hooks;

import core.api.ApiHeaders;
import core.api.ApiRequestBuilder;
import io.cucumber.java.Before;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;

    public ApiHooks(final ApiRequestBuilder apiRequestBuilder) {
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @Before(order  = 1)
    public void setUp() {
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), "18915744_4f5e1d5e81284a083475fe64660390d8d6bb17db")
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }
}
