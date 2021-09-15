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

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Manages the creation of RequestSpecification and execution of an ApiRequest.
 */
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
     * Executes a ApiRequest without body without log.
     *
     * @param apiRequest  Contains all data of request
     * @param apiResponse after execution of request
     * @author Saul Caspa
     */
    public static void executeWithoutLog(final ApiRequest apiRequest, final ApiResponse apiResponse) {
        Response response = buildRequestWithoutLog(apiRequest)
                .request(apiRequest.getMethod().name(), apiRequest.getEndpoint());
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
        return given()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    /**
     * Builds a RequestSpecification without log.
     *
     * @param apiRequest Contains all data of request
     * @return RequestSpecification without log
     * @author Saul Caspa
     */
    private static RequestSpecification buildRequestWithoutLog(final ApiRequest apiRequest) {
        return given()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .contentType(ContentType.JSON);
    }

    /**
     * Executes a ApiRequest with body.
     *
     * @param apiRequest  Contains all data of request
     * @param apiResponse Contains all data of a response
     * @author Saul Caspa
     */
    public static void executeWithBody(final ApiRequest apiRequest, final ApiResponse apiResponse) {
        Response response = buildRequest(apiRequest)
                .body(apiRequest.getBody())
                .request(apiRequest.getMethod().name(), apiRequest.getEndpoint());
        apiResponse.setResponse(response);
    }

    /**
     * Executes the Api request and assignment to response using param.
     *
     * @param apiRequest contains all the parameters for the execution to request.
     * @return a new instance to response.
     */
    public static ApiResponse executeParam(final ApiRequest apiRequest) {
        Response response = given().headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .params(apiRequest.getParams())
                .log().all()
                .request(apiRequest.getMethod().name(),
                        apiRequest.getEndpoint());
        return new ApiResponse(response);
    }
}
