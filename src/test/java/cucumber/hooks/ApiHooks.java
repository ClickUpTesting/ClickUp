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
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private SoftAssert softAssert;

    public ApiHooks(final ApiRequestBuilder apiRequestBuilder, final SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.softAssert = softAssert;
    }

    @Before(order  = 1)
    public void setUp() {
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), "3152915_d6831bb6342aea560c0d7bdcfd16a6f9ce50b1fb")
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }

    @After
    public void assertAllSteps() {
        softAssert.assertAll();
    }
}
