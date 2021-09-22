/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa
 */

package com.clickup.api;

public final class Endpoints {

    private Endpoints() {
    }
    public static final String CREATE_FOLDERLESS_LIST = "/space/{space_id}/list";
    public static final String DELETE_LIST = "/v2/list/{list_id}";
}
