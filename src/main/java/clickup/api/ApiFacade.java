/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.api;

import clickup.ApiEndpoints;
import clickup.utils.ScenarioContext;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.ApiHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class ApiFacade {
    public ApiRequestBuilder apiRequestBuilder;
    public ApiRequest apiRequest;
    public ApiResponse apiResponse;
    public ScenarioContext scenarioContext;

    public ApiFacade() {
        setUp();
    }

    /**
     * Sets base of request.
     */
    protected void setUp() {
        apiRequest = new ApiRequest();
        apiRequestBuilder = new ApiRequestBuilder();
        scenarioContext = ScenarioContext.getInstance();
        apiResponse = new ApiResponse();
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }

    /**
     * Creates a object from API,
     * this request only permit set one pathParams.
     *
     * @param body            body to set
     * @param endpoint        is the objet's endpoint
     * @param pathParams      is pathParams of request
     * @param valuePathParams is valuePathParams of request
     * @return an ApiResponse
     * @author Gustavo Huanca
     */
    public ApiResponse createObject(final String body, final ApiEndpoints endpoint, final String pathParams,
                                    final String valuePathParams) {
        Map<String, String> mapPathParams = new HashMap<>();
        mapPathParams.put(pathParams, valuePathParams);
        return createObject(body, endpoint, mapPathParams);
    }

    /**
     * Creates a object from API.
     *
     * @param body          body to set
     * @param endpoint      is the objet's endpoint
     * @param mapPathParams is map with values of pathParams
     * @return an ApiResponse
     * @author Gustavo Huanca
     */
    public ApiResponse createObject(final String body, final ApiEndpoints endpoint,
                                    final Map<String, String> mapPathParams) {
        apiRequestBuilder
                .method(ApiMethod.POST)
                .endpoint(endpoint.getEndpoint())
                .cleanParams()
                .pathParams(mapPathParams)
                .clearBody()
                .body(body);
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        return apiResponse;
    }

    /**
     * Deletes an object from API.
     * this request only permit set one pathParams.
     *
     * @param endpoint        is the objet's endpoint
     * @param pathParams      is pathParams of request
     * @param valuePathParams is valuePathParams of request
     * @return an ApiResponse
     * @author Gustavo Huanca
     */
    public ApiResponse deleteObject(final ApiEndpoints endpoint, final String pathParams,
                                    final String valuePathParams) {
        Map<String, String> mapPathParams = new HashMap<>();
        mapPathParams.put(pathParams, valuePathParams);
        return deleteObject(endpoint, mapPathParams);
    }

    /**
     * Deletes an object from API.
     *
     * @param endpoint        is the objet's endpoint
     * @param mapPathParams is map with values of pathParams
     * @return an ApiResponse
     * @author Gustavo Huanca
     */
    public ApiResponse deleteObject(final ApiEndpoints endpoint, final Map<String, String> mapPathParams) {
        apiRequestBuilder
                .method(ApiMethod.DELETE)
                .endpoint(endpoint.getEndpoint())
                .cleanParams()
                .pathParams(mapPathParams)
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        return apiResponse;
    }

    /**
     * Deletes a list of object which are setting in trash map of ScenarioContext
     * this request only permit set one pathParams.
     *
     * @param endpoint      is the objet's endpoint
     * @param NameTrashList is key of trash map which contains identifier of feature to delete
     * @return an ApiResponse
     * @author Gustavo Huanca
     */
    public ApiResponse deleteListsObjects(final ApiEndpoints endpoint, final String NameTrashList) {
        List<String> tagsTrashList = scenarioContext.getTrashList(NameTrashList);
        List<String> pathParamsList = getPathParamsFromEndpoint(endpoint.getEndpoint());
        apiRequestBuilder
                .endpoint(endpoint.getEndpoint())
                .cleanParams()
                .method(ApiMethod.DELETE);
        for (String tagName : tagsTrashList) {
            apiRequestBuilder.cleanParams();
            apiRequestBuilder.pathParams(pathParamsList.get(0), tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
        scenarioContext.getTrashList(NameTrashList).clear();
        return apiResponse;
    }

    /**
     * Gets an object from API.
     * This request only permits set one pathParams.
     *
     * @param endpoint        is the objet's endpoint
     * @param pathParams      is pathParams of request
     * @param valuePathParams is valuePathParams of request
     * @return an ApiResponse
     * @author Jorge Caceres
     */
    public ApiResponse getObject(final ApiEndpoints endpoint, final String pathParams,
                                 final String valuePathParams) {
        apiRequest = apiRequestBuilder
                .clearBody()
                .endpoint(endpoint.getEndpoint())
                .pathParams(pathParams, valuePathParams)
                .method(ApiMethod.GET)
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        return apiResponse;
    }
}
