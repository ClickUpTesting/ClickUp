/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    private String id;
    private String status;
    @JsonProperty("orderindex")
    private Integer orderIndex;
    private String color;
    private String type;

    public Status() {
    }

    public Status(String id, String status, Integer orderIndex, String color, String type) {
        this.id = id;
        this.status = status;
        this.orderIndex = orderIndex;
        this.color = color;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Status{"
                + "id='" + id + '\''
                + ", status='" + status + '\''
                + ", orderIndex=" + orderIndex
                + ", color='" + color + '\''
                + ", type='" + type + '\''
                + '}';
    }
}
