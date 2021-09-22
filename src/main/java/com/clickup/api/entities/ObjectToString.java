package com.clickup.api.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

public interface ObjectToString<T> {

    /**
     * Return a string out of a entity object.
     *
     * @param entity represents an object class
     * @return a String represening the object as a string body
     * @throws JsonProcessingException
     */
    default String asString(T entity) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(entity);
    }
}
