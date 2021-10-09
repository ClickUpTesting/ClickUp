/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.api;

import java.util.Map;

public class ApiRequestBuilder implements IBuilderApiRequest {

    private ApiRequest apiRequest;

    public ApiRequestBuilder() {
        this.apiRequest = new ApiRequest();
    }

    /**
     * Sets the base Uri to request.
     *
     * @param baseUri is path to base Uri to request
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder baseUri(final String baseUri) {
        this.apiRequest.setBaseUri(baseUri);
        return this;
    }

    /**
     * Sets endpoint to request.
     *
     * @param endpoint is the path to endpoint
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder endpoint(final String endpoint) {
        this.apiRequest.setEndpoint(endpoint);
        return this;
    }

    /**
     * Sets body to response.
     *
     * @param body is body to request
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder body(final String body) {
        this.apiRequest.setBody(body);
        return this;
    }

    /**
     * Sets method to response.
     *
     * @param method is method to response
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder method(final Enum<ApiMethod> method) {
        this.apiRequest.setMethod(method);
        return this;
    }

    /**
     * Sets headers to request.
     *
     * @param header is the key of header
     * @param value  is a value of header
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder headers(final String header, final String value) {
        this.apiRequest.addHeaders(header, value);
        return this;
    }

    /**
     * Removes all the values added to the path params Map.
     *
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder cleanParams() {
        this.apiRequest.clearPathParams();
        this.apiRequest.clearQueryParams();
        return this;
    }

    /**
     * Removes all the values added to the path params Map.
     *
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder clearBody() {
        this.apiRequest.clearBody();
        return this;
    }

    /**
     * Sets params to request.
     *
     * @param param is the key of param
     * @param value is a value of param
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder pathParams(final String param, final String value) {
        this.apiRequest.addPathParams(param, value);
        return this;
    }

    /**
     * Sets params to request.
     *
     * @param mapPathParam map with the path params values
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder pathParams(final Map<String, String> mapPathParam) {
        this.apiRequest.addPathParams(mapPathParam);
        return this;
    }

    /**
     * Sets params to request.
     *
     * @param param is the key of param
     * @param value is a value of param
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequestBuilder params(final String param, final String value) {
        this.apiRequest.addParams(param, value);
        return this;
    }

    /**
     * Finishes the build to object.
     *
     * @return ApiRequest in order to build request
     * @author Gustavo Huanca
     */
    public ApiRequest build() {
        return apiRequest;
    }

    /**
     * Sets query parameters to request.
     *
     * @param queryParam is a key with the query parameter name
     * @param value is the value of the parameter
     * @return ApiRequest in order to build request
     * @author Raymundo Guaraguara
     */
    public ApiRequestBuilder queryParams(final String queryParam, final String value) {
        this.apiRequest.addQueryParams(queryParam, value);
        return this;
    }
}
