/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.api.hooks;

import core.api.ApiHeaders;
import core.api.ApiRequestBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private SoftAssert softAssert;

    public ApiHooks(ApiRequestBuilder apiRequestBuilder, SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.softAssert = softAssert;
    }

    @Before(order = 1, value = "@API")
    public void setUp() {
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }
    @After(order = 1, value = "@API")
    public void assertAllSteps() {
        softAssert.assertAll();
    }
}
