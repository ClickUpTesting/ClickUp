/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Saul Caspa
 */

package core.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static core.api.ApiRequestSpecificationProvider.add;
import static io.restassured.RestAssured.given;

public final class ApiManager {

    private ApiManager() {
    }

    /**
     * Executes a ApiRequest without body.
     *
     * @param apiRequest  Contains all data of request
     * @param apiResponse after execution of request
     * @author Saul Caspa
     */
    public static void execute(final ApiRequest apiRequest, final ApiResponse apiResponse) {
        Response response = buildRequest(apiRequest).request(apiRequest.getMethod().name(),
                apiRequest.getEndpoint());
        apiResponse.setResponse(response);
    }

    /**
     * Builds a RequestSpecification.
     *
     * @param apiRequest Contains all data of request
     * @return RequestSpecification
     * @author Saul Caspa
     */
    private static RequestSpecification buildRequest(final ApiRequest apiRequest) {
        RequestSpecification requestSpecification = given();
        add(() -> requestSpecification.headers(apiRequest.getHeaders()), () -> apiRequest.getHeaders());
        add(() -> requestSpecification.queryParams(apiRequest.getQueryParams()), () -> apiRequest.getQueryParams());
        add(() -> requestSpecification.pathParams(apiRequest.getPathParams()), () -> apiRequest.getPathParams());
        add(() -> requestSpecification.baseUri(apiRequest.getBaseUri()), () -> apiRequest.getBaseUri());
        add(() -> requestSpecification.params(apiRequest.getParams()), () -> apiRequest.getParams());
        add(() -> requestSpecification.contentType(apiRequest.getContentType()), () -> apiRequest.getContentType());
        add(() -> requestSpecification.body(apiRequest.getBody()), () -> apiRequest.getBody());
        return requestSpecification;
    }
}
