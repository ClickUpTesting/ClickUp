/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.api.request;

public enum Header {
    SOBJECTS("sobjects"),
    AUTHORIZATION("Authorization"),
    BEARER("Bearer "),
    ACCEPT("Accept"),
    APPLICATION_JSON("application/json"),
    CONTENT_TYPE("Content-Type"),
    X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded");

    private String value;

    Header(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
