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

import com.fasterxml.jackson.annotation.JsonProperty;

public class DueDates {
    @JsonProperty("remap_due_dates")
    private boolean remapDueDates;
    @JsonProperty("remap_closed_due_date")
    private boolean remapClosedDueDate;
    private boolean enabled;
    @JsonProperty("start_date")
    private boolean startDate;

    public void setRemapDueDates(final boolean remapDueDates) {
        this.remapDueDates = remapDueDates;
    }

    public boolean isRemapDueDates() {
        return remapDueDates;
    }

    public void setRemapClosedDueDate(final boolean remapClosedDueDate) {
        this.remapClosedDueDate = remapClosedDueDate;
    }

    public boolean isRemapClosedDueDate() {
        return remapClosedDueDate;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setStartDate(final boolean startDate) {
        this.startDate = startDate;
    }

    public boolean isStartDate() {
        return startDate;
    }
}
