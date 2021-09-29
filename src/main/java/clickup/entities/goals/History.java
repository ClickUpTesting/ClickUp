/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.entities.goals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class History {
    public String id;
    @JsonProperty("key_result_id")
    public String keyResultId;
    @JsonProperty("userid")
    public Integer userId;
    public String note;
    @JsonProperty("date_modified")
    public String dateModified;
    @JsonProperty("steps_taken")
    public Integer stepsTaken;
    @JsonProperty("steps_before")
    public Integer stepsBefore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyResultId() {
        return keyResultId;
    }

    public void setKeyResultId(String keyResultId) {
        this.keyResultId = keyResultId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Integer getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(Integer stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public Integer getStepsBefore() {
        return stepsBefore;
    }

    public void setStepsBefore(Integer stepsBefore) {
        this.stepsBefore = stepsBefore;
    }
}
