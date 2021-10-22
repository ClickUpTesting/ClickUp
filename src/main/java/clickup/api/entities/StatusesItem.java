/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.api.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StatusesItem {
    private int orderindex;
    private String color;
    private String id;
    private String type;
    private String status;

    public void setOrderindex(final int orderindex) {
        this.orderindex = orderindex;
    }

    public int getOrderindex() {
        return orderindex;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
