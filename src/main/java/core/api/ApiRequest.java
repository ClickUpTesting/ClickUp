/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package core.api;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiRequest {
    private String baseUri;
    private String endpoint;
    private String body;
    private String token;
    private Enum<ApiMethod> method;
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Map<String, String> params;
    private ContentType contentType;

    public ApiRequest() {
        headers = new ArrayList<>();
        queryParams = new HashMap<>();
        pathParams = new HashMap<>();
        params = new HashMap<>();
    }

    /**
     * Gets the base Uri.
     *
     * @return a String with the base Uri
     * @author Jorge Caceres
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the base Uri.
     *
     * @param baseUri a String with the value to set
     * @author Jorge Caceres
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * Gets the endpoint.
     *
     * @return a String with the endpoint
     * @author Jorge Caceres
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint.
     *
     * @param endpoint a String with the value to set
     * @author Jorge Caceres
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Gets the body.
     *
     * @return a String with the body
     * @author Jorge Caceres
     */
    public String getBody() {
        if (body == null) {
            return "";
        }
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body a String with the value to set
     * @author Jorge Caceres
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the token.
     *
     * @return a String with the token
     * @author Jorge Caceres
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token a String with the value to set
     * @author Jorge Caceres
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the Api method.
     *
     * @return a String with the Api method
     * @author Jorge Caceres
     */
    public Enum<ApiMethod> getMethod() {
        return method;
    }

    /**
     * Sets the Api method.
     *
     * @param method a String with the value to set
     * @author Jorge Caceres
     */
    public void setMethod(Enum<ApiMethod> method) {
        this.method = method;
    }

    /**
     * Sets the values for header request.
     *
     * @param header String with the header's name
     * @param value  String with the headers' value
     * @author Jorge Caceres
     */
    public void addHeaders(final String header, final String value) {
        headers.add(new Header(header, value));
    }

    /**
     * Adds the query parameters.
     *
     * @param queryParams a Map with the query parameters to add
     * @author Jorge Caceres
     */
    public void addQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * Sets the values for path params.
     *
     * @param param String with the path params name
     * @param value String with the path params value
     * @author Jorge Caceres
     */
    public void addPathParams(final String param, final String value) {
        pathParams.put(param, value);
    }

    /**
     * Removes all the values added to the path params Map.
     *
     * @author Jorge Caceres
     */
    public void clearPathParams() {
        pathParams.clear();
    }

    /**
     * Removes all the values added to the query params Map.
     *
     * @author Jorge Caceres
     */
    public void clearQueryParams() {
        queryParams.clear();
    }

    /**
     * Removes all the values added to the params Map.
     *
     * @author Jorge Caceres
     */
    public void clearParams() {
        params.clear();
    }

    /**
     * Gets the headers.
     *
     * @return an Object with the headers
     * @author Jorge Caceres
     */
    public Headers getHeaders() {
        return new Headers(headers);
    }

    /**
     * Gets the query parameters.
     *
     * @return a Map of Strings with the query parameters
     * @author Jorge Caceres
     */
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Gets the path parameters.
     *
     * @return a Map of Strings with the path parameters
     * @author Jorge Caceres
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }

    /**
     * Sets the values for params.
     *
     * @param param String with the params name
     * @param value String with the params value
     * @author Jorge Caceres
     */
    public void addParams(final String param, final String value) {
        params.put(param, value);
    }

    /**
     * Gets the request params.
     *
     * @return a Map with List of params
     * @author Jorge Caceres
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * Gets the ContentType
     *
     * @return the ContentType Enum
     * @author Saul Caspa
     */
    public ContentType getContentType() {
        return contentType;
    }

    /**
     * Sets the ContentType
     *
     * @param contentType the content type Enum
     * @author Saul Caspa
     */
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
}
