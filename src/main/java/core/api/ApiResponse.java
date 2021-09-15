/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Cristian Choque
 */

package core.api;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiResponse {

    private Response response;

    public ApiResponse(final Response response) {
        this.response = response;
    }

    /**
     * Gets the response.
     *
     * @return an object with the response
     * @author Cristian Choque
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the response.
     *
     * @param response an object to set the response
     * @author Cristian Choque
     */
    public void setResponse(final Response response) {
        this.response = response;
    }

    /**
     * Gets the status of the code.
     *
     * @return an int with the status code
     * @author Cristian Choque
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets a body.
     *
     * @param entityClass is type of entity.
     * @param <T>         is type of entity
     * @return Body response as class
     * @author Cristian Choque
     */
    public <T> T getBody(final Class<T> entityClass) {
        return response.getBody().as(entityClass);
    }

    /**
     * Validates the schema of feature.
     *
     * @param schema schema of the feature
     * @author Cristian Choque
     */
    public void validateBodySchema(final String schema) {
        response.then().log().body().assertThat().body(matchesJsonSchemaInClasspath(schema));
    }

    /**
     * Gets the json's path.
     *
     * @param path a String with the url path
     * @return a String with the json's path
     * @author Cristian Choque
     */
    public String getPath(final String path) {
        return response.getBody().jsonPath().getJsonObject(path);
    }
}
